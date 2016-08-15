package designPattern.templateMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class sample
{
	public static void main(String[] args)
	{
		UserJDBC uJdbc=new UserJDBC();
		//add
		UserDTO dto=new UserDTO();
		dto.setCode("llb");
		dto.setName("liulibo");
		dto.setAge(33);
		uJdbc.create(dto);
		

	}
}
/**
 * 一个简单的实现JDBC增删改查功能的模板
 *
 */
abstract class JDBCTemplate
{
	//定义当前的操作类型是新增
	protected final static int TYPE_CREATE=1;
	protected final static int TYPE_UPDATE=2;
	protected final static int TYPE_DELETE=3;
	protected final static int TYPE_CONDITION=4;//按条件查询
	
	/***  模板方法 *****************************/
	/**
	 * 实现新增功能
	 * @param obj
	 */
	public final void create(Object obj)
	{
		//1获取新增的sql
		String sql=this.getMainSql(TYPE_CREATE);
		//2 调用通用的更新实现
		this.executeUpdate(sql,TYPE_CREATE,obj);
	}
	public final void update(Object obj)
	{
		//
		String sql=this.getMainSql(TYPE_UPDATE);
		//2 调用通用的更新实现
		this.executeUpdate(sql,TYPE_UPDATE,obj);
	}
	public final void delete(Object obj)
	{
		//
		String sql=this.getMainSql(TYPE_DELETE);
		//2 调用通用的更新实现
		this.executeUpdate(sql,TYPE_DELETE,obj);
	}
	public final Collection getByCondition(Object qm)
	{
		//1 获取查询的sql
		String sql=getMainSql(TYPE_CONDITION);
		return this.getByCondition(sql,qm);
	}

	
	/*********原语操作****************************************/
	/**
	 * 获取CRUD的sql
	 * @param operateType
	 * @return
	 */
	protected abstract  String getMainSql(int operateType);
	/**
	 * 为sql中的占位符“？”设置值
	 * @param type
	 * @param statement
	 * @param obj
	 */
	protected abstract void setUpdateSqlValue(int type,PreparedStatement statement,Object obj) ;
	/**
	 * 为通用查询动态拼接sql的条件
	 *基本思路：只有用户填写了相应的条件，才在sql中添加对应的条件
	 * @param sql
	 * @param obj
	 * @return
	 */
	protected abstract String prepareQuerySql(String sql,Object obj);
	/**
	 * 为通用的查询sql动态设置条件的值
	 * @param statement
	 * @param obj
	 */
	protected abstract void setQuerySqlValue(PreparedStatement statement,Object obj);
	/**
	 * 将查询结果转换为数据对象
	 * @param rs
	 * @return
	 */
	protected abstract Object rs2Object(ResultSet rs);
	
	/***钩子操作*********************************************/
	
	/**连接数据库的默认实现，可以被子类覆盖
	* @throws ClassNotFoundException 
	 * @throws SQLException
	 */ 
	protected Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("JDBC驱动类");
		return DriverManager.getConnection("数据库连接RUL","用户名","密码");
	}
	//执行查询
	protected Collection getByCondition(String sql, Object qm)
	{
		Collection collection=new ArrayList<>();
		Connection conn=null;
		try
		{
			//调用钩子操作
			conn=this.getConnection();
			//调用原语操作
			sql=this.prepareQuerySql(sql, qm);
			PreparedStatement statement=conn.prepareStatement(sql);
			this.setQuerySqlValue(statement, qm);
			ResultSet rs=statement.executeQuery();
			while (rs.next())
			{
				collection.add(this.rs2Object(rs));
			}
			rs.close();
			statement.close();
			
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return collection;

	}
	/**
	 * 执行更改数据的sql，包括增删改的功能
	 * @param sql
	 * @param typeCreate
	 * @param obj
	 */
	private void executeUpdate(String sql, int operateType, Object obj)
	{
		Connection conn=null;
		try
		{
			conn=this.getConnection();
			PreparedStatement statement=conn.prepareStatement(sql);
			this.setUpdateSqlValue(operateType, statement, obj);
			statement.executeUpdate();
			statement.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}

	
	
	
}


class UserJDBC extends JDBCTemplate
{

	@Override
	protected String getMainSql(int operateType)
	{
		String sql="";
		switch (operateType) {
		case TYPE_CREATE:
			sql="insert into t_user values(?,?,?)";
			break;

		case TYPE_DELETE:
			sql="delete from t_user where id=?";
			break;
		case TYPE_UPDATE:
			sql="update t_user set name=? where id=?";
			break;
		case TYPE_CONDITION:
			sql="select * from t_user where 1=1";
			
			break;
		}
		return sql;
	}

	@Override
	protected void setUpdateSqlValue(int type, PreparedStatement statement, Object obj)
	{
		if (type==TYPE_CREATE)
		{
			//this.set
		}else if (type==TYPE_DELETE)
		{
			//this.setde
		}else if (type==TYPE_UPDATE) {
			//this.setup
		}
		
	}

	@Override
	protected String prepareQuerySql(String sql, Object obj)
	{
		return sql;
		
	}

	@Override
	protected void setQuerySqlValue(PreparedStatement statement, Object obj)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object rs2Object(ResultSet rs)
	{
		UserDTO dto=new UserDTO();
		try
		{
			dto.setCode(rs.getString("code"));
			dto.setName(rs.getString("name"));
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}
	
	private void setCreateValue(PreparedStatement statement,UserDTO dto)
	{
		try
		{
			statement.setString(1, "1");
			statement.setString(2, dto.getCode());
			statement.setString(3, dto.getName());
			statement.setInt(4, dto.getAge());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void setUpdateValue(PreparedStatement statement,UserDTO dto)
	{
		try
		{
			
			statement.setString(1, dto.getCode());
			statement.setString(2, dto.getName());
			statement.setInt(3, dto.getAge());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void setDeleteValue(PreparedStatement statement,UserDTO dto)
	{
		try
		{
			
			
			statement.setInt(1, dto.getId());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class UserDTO{
	String name,code;
	int id,age;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}
