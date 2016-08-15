package designPattern.strategy;

/**
 * 给客户报价示例
 * @author llb
 *
 */
public class sample
{

	public static void main(String[] args)
	{

		//1:创建一个价格策略（大客户）
		PriceStrategy strategy=new LargeCustomerPriceStrategy();
		//2:创建上下文
		Price ctx=new Price(strategy);
		//3:报价
		double quote= ctx.quote(1000);
		System.out.println("向客户报价："+quote);
	}

}

interface PriceStrategy
{
	/**
	 * 计算应报价格
	 * @param goodsPrice 商品销售原价
	 * @return 给客户报的价格
	 */
	public double calcPrice(double goodsPrice);
}
class NomalCustomerPriceStrategy implements PriceStrategy
{

	@Override
	public double calcPrice(double goodsPrice)
	{
		System.out.println("对于新客户或普通客户，没有折扣");
		return goodsPrice;
	}
	
}
class OldCustomerPriceStrategy implements PriceStrategy
{

	@Override
	public double calcPrice(double goodsPrice)
	{
		System.out.println("对于老客户，统一折扣5%");
		return goodsPrice*(1-0.05);
	}
	
}
class LargeCustomerPriceStrategy implements PriceStrategy
{

	@Override
	public double calcPrice(double goodsPrice)
	{
		System.out.println("对于大客户，统一折扣10%");
		return goodsPrice*(1-0.1);
	}
	
}
/**
 * 上下文的实现， 即价格类
 * 价格管理，主要完成计算向客户所报价格的功能
 * @author llb
 *
 */
class Price
{
	private PriceStrategy strategy =null;
	public Price(PriceStrategy aStrategy)
	{
		this.strategy=aStrategy;
	}
	/**
	 * 报价，计算对客户的报价
	 * @param goodsPrice
	 * @return
	 */
	public double quote(double goodsPrice)
	{
		return strategy.calcPrice(goodsPrice);
	}
}