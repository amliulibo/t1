package designPattern.factoryMethod;

/**
 * 工厂方法：把具体的实现延时到子类
 * @author llb
 *
 */
public class client
{

	public static void main(String[] args)
	{

		ExportOperate exportOperate=new ExportTxtFileOperate();
		exportOperate.export("12345");

	}

}
interface IExportFile
{
boolean export(String data);	
}
class ExportTxtFile implements IExportFile
{

	@Override
	public boolean export(String data)
	{
		System.out.println("导出数据"+data+"到txt文件");
		return true;
	}
	
}
class ExportDB implements IExportFile
{
	@Override
	public boolean export(String data)
	{
		System.out.println("导出数据"+data+"到数据库文件");
		return true;
	}
}
abstract class ExportOperate
{
	protected  abstract IExportFile factoryMethod();
	
	public boolean export(String data)
	{
		
		return factoryMethod().export(data);
		
	}
}
class ExportTxtFileOperate extends ExportOperate
{

	@Override
	protected IExportFile factoryMethod()
	{
		return new ExportTxtFile();
	}
	
}
class ExportDBFileOperate extends ExportOperate
{

	@Override
	protected IExportFile factoryMethod()
	{
		return new ExportDB();
	}
	
}
