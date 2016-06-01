import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeTest {
public static void main(String srgs[]) throws ParseException{
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//	System.out.println("当前系统时间：" + sdf.format("20140827081702"));
//	System.out.println("当前系统时间：" + System.currentTimeMillis());
	   String  opentime="2014-12-22 15:44:18.336155";
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟  
	   Date date = (Date) sdf.parse(opentime); 
	   SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String a=sf.format(date);
	    System.out.println(a);
/*	String  opentime="20140827081702";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//小写的mm表示的是分钟 
    Date lo = sdf.parse(opentime); 
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String a=sf.format(lo);
    System.out.println(a);*/
	/*    System.out.println(System.currentTimeMillis());
	    Date nowTime = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String retStrFormatNowDate = sdFormatter.format(nowTime);
	    System.out.println(retStrFormatNowDate);*/
}
}
