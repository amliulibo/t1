package designPattern;

/**
 * 静态方法（简单方法）
 * @author llb
 *
 */
 class client
{

	static IApi api=null;
	
	public static void main(String[] args)
	{
		api=staticFactory.GetSampleApi();
		api.method1();

	}

}
public class staticFactory
{
	public static IApi GetSampleApi()
	{
		return new apiImpl();
	}
}


interface IApi
{
	void method1();
}
class apiImpl implements IApi
{

	@Override
	public void method1()
	{
		// TODO Auto-generated method stub
		
	}
	
}
