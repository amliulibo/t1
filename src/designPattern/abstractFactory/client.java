package designPattern.abstractFactory;

/**
 * 抽象工厂要解决的问题是：要创建一系列的产品对象，而且这一系列对象是构建新的对象所需要的组成部分
 * ，也就是说这一系列被创建的对象相互之间是有约束的。
 * @author llb
 *
 */
public class client
{

	public static void main(String[] args)
	{
		DAOFactory factory=new RdbDAOFactory();
		IOrderMainDAO mainDAO=factory.CreateOrderMainDAO();
		IOrderDetailDAO detailDAO=factory.CreateOrderDetailDAO();
		//调用DAO完成数据存储
		mainDAO.saveOrderMain();
		detailDAO.saveOrderDetail();

	}

}
abstract class  DAOFactory
{
	public abstract IOrderMainDAO CreateOrderMainDAO();
	public abstract IOrderDetailDAO CreateOrderDetailDAO();
}
 interface IOrderMainDAO
{
	public void saveOrderMain();
}
 interface IOrderDetailDAO
{
	public void saveOrderDetail();
}
 class RdbMainDAOImpl implements IOrderMainDAO
 {

	@Override
	public void saveOrderMain()
	{
		System.out.println("RdbMainDAOImpl");
		
	}
	 
 }
 class RdbDetailDAOImpl implements IOrderDetailDAO
 {

	@Override
	public void saveOrderDetail()
	{
		System.out.println("RdbDetailDAOImpl");
		
	}
	 
 }
 class XmlMainDAOImpl implements IOrderMainDAO
 {

	@Override
	public void saveOrderMain()
	{
		System.out.println("XmlMainDAOImpl");
		
	}
	 
 }
 class XmlDetailDAOImpl implements IOrderDetailDAO
 {

	@Override
	public void saveOrderDetail()
	{
		System.out.println("XmlDetailDAOImpl");
		
	}
	 
 }
 
 class RdbDAOFactory extends DAOFactory
 {

	@Override
	public IOrderMainDAO CreateOrderMainDAO()
	{
		// TODO Auto-generated method stub
		return new RdbMainDAOImpl();
	}

	@Override
	public IOrderDetailDAO CreateOrderDetailDAO()
	{
		// TODO Auto-generated method stub
		return new RdbDetailDAOImpl();
	}
	 
	 
 }
 class XmlDAOFactory extends DAOFactory
 {

	@Override
	public IOrderMainDAO CreateOrderMainDAO()
	{
		// TODO Auto-generated method stub
		return new XmlMainDAOImpl();
	}

	@Override
	public IOrderDetailDAO CreateOrderDetailDAO()
	{
		// TODO Auto-generated method stub
		return new XmlDetailDAOImpl();
	}
	 
 }
 
