package designPattern.templateMethod;

/*
 * 模板方法模式的功能在于固定算法骨架，而让具体算法实现可扩展
 * 
 * */
public class client
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
/**
 * 一个完整的模板定义示例
 * @author llb
 *
 */
abstract class AbstractTemplate
{
	//工厂方法创建摸个对象,在算法实现中可能需要
	protected abstract Object createOneObject();
	
	//模板方法，定义算法骨架
	public final void templateMethod()
	{
		//第一步
		this.operation1();
		//第二步
		this.operation2();
		//第三步
		this.doPrimitiveOperation1();
		//第四步
		this.doPrimitiveOperation2();
		//第五步
		this.hookOperation1();
		
	}
	//具体操作1，算法中的步骤，固定实现，且子类不需要访问
	private void operation1(){}
	//具体操作2，算法中的步骤，固定实现，子类可能需要访问
	//但不允许覆盖
	protected final void operation2(){}
	//为子类提供公共功能
	protected void commonOperation(){}
	//原语操作1，算法中的必要步骤，父类无法确定如何真正实现，需要子类实现
	protected abstract void doPrimitiveOperation1();
	protected abstract void doPrimitiveOperation2();
	//钩子操作，算法中的步骤，提供默认实现，由子类选择并具体实现
	protected void hookOperation1(){}
	
	
	
}
