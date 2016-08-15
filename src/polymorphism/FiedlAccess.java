package polymorphism;

public class FiedlAccess {
	public static void main(String[] args)
	{
		Super sup=new Sub();
		System.out.println(sup.field+","+sup.getField());
		Sub sub=new Sub();
		System.out.println(sub.field+","+sub.getField()+","+sub.getSuperField());
		
	}
}

class Super
{
public int field=0;
public int getField(){return field;}
}
class Sub extends Super
{
	public int field=1;
	public int getField(){return field;}
	public int getSuperField()
	{
		return super.getField();
	}
}