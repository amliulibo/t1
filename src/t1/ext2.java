package t1;

import java.text.MessageFormat;

public class ext2
{
	public static void  main(String args[])
	{
			Class1 c1=new Class1("L1",10);
			c1.printValue();
			changeValue(c1);
			c1.printValue();
			DtoOut dtoOut=new DtoOut(c1);
			changeValue2(dtoOut);
			Class1 c2=(Class1)dtoOut.object;
			c2.printValue();
	}
	
	public static void changeValue(Class1 class1)
	{
		class1.name="llb";
		class1.age=10;
	}
	public static void changeValue1(Class1 class1)
	{
		class1=new Class1("L2", 20);
	}
	public static void changeValue2(DtoOut class1)
	{
		class1.object=new Class1("L3", 30);
	}
}
class DtoOut
{
	Object object;
	public DtoOut(Object object)
	{
		this.object=object;
	}
	
}
class Class1
{
	public String name;
	public int age;
	
	public Class1(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public Class1(){}
	public void printValue()
	{
		String sql=MessageFormat.format("name={0},age={1}", name,age);
		System.out.println(sql);
	}
	
}