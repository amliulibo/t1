package designPattern.strategy;

import java.io.ObjectInputValidation;

/**
 * 定义一系列算法，把他们一个个封装起来，并且使他们可以星湖替换
 * 策略模式的重心不是如何来实现算法，而是如何组织、调用这些算法，
 * 从而让程序结构更灵活，具有更好的维护性和扩展项
 * @author llb
 *
 */
public class client
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
interface Strategy{
	
	//摸个算法的接口，可以有传入参数，也可以有返回值
	void algorithmInterface();
	
}
class ConcreteStrategyA implements Strategy
{

	@Override
	public void algorithmInterface()
	{
		// 具体的算法实现
		
	}
	
}
class ConcreteStrategyB implements Strategy
{

	@Override
	public void algorithmInterface()
	{
		// 具体的算法实现
		
	}
	
}
class ConcreteStrategyC implements Strategy
{

	@Override
	public void algorithmInterface()
	{
		// 具体的算法实现
		
	}
	
}
class Context
{
		private Strategy strategy;
		public Context(Strategy aStrategy)
		{
			strategy=aStrategy;
		}
		public void contextInterface()
		{
			strategy.algorithmInterface();
		}
}
