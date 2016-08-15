package t1;

public class Father {

	private void method1(){
		System.out.println("father.method1");
	}
	public static void main(String[] args) {
		
		Father father =new Father();
		father.method1();
	}

}


 class Son extends Father
{
	public void method1(){
		System.out.println("son.method1");
	}
}


