package polymorphism;

public class Multi {
	public static void main(String[] args)
	{
		/*SubMulti2 subMulti2=new SubMulti2();
		subMulti2.getVal1();
		subMulti2.getSuperVal1();*/
		
		SuperMulti superMulti=new SubMulti2();
		superMulti.getVal1();//c
		superMulti.getSuperVal1();//b
		System.out.print(superMulti.val1);//a
		
		SubMulti1 multi1=new SubMulti2();
		System.out.print(multi1.val1);//b
		
		
	}
	
}

class SuperMulti{
	public String val1="a";
	public void getVal1(){
		System.out.print(val1);
	}
	public void getSuperVal1()
	{
		getVal1();
		
	}
}
class SubMulti1 extends SuperMulti{
	public String val1="b";
	
}
class SubMulti2 extends SubMulti1{
	private String val1="c";
	public void getVal1(){
		
		System.out.print(val1);
	}
	public void getSuperVal1()
	{
		super.getVal1();
		
	}
}