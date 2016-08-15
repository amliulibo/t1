package t1;

public class ext1
{
	public static void  main(String args[])
	{
		interface1 inter1=new derived1();
		//inter1.method1();
	}
}

class base{
	public void method2(){
		System.out.println("haha");
	}
}
interface interface1
{
	//public void method1();
	public void method2();
}
class derived1 extends base implements interface1
{



	
}