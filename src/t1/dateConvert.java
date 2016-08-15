package t1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateConvert
{
	public static void  main(String args[])
	{
		 //"2008-08-08 12:10:12"
		//"yyyy-MM-dd HH:mm:ss"
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		try
		{
			Date date = sdf.parse( "20160808191812");
			
			 sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );

	        String str = sdf.format(date);
	        
			System.out.println(str);
			
			System.out.println(str);
			
			
			
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
