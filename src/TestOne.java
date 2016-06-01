
public class TestOne {
	public static void main(String[] args) {
/*		Integer a = new Integer(1);
		Integer b = new Integer(1);
		int c=1;
		Integer e = 1;
		Integer f=Integer.valueOf(1);
		Integer g=Integer.valueOf(1);
		Float h=Float.valueOf((float) 1.2);
		Float i=Float.valueOf((float) 1.2);
		String j=String.valueOf(1.2);
		String k=String.valueOf(1.2);
		Float h2=(float) 1.2;
		Float i2=(float) 1.2;
		String j2="wanghuan";
		String k2="wanghuan";
		System.out.println("a==b:"+(a==b));
		System.out.println("a==c:"+(a==c));
		System.out.println("a==e:"+(a==e));
		System.out.println("c==e:"+(c==e));
		System.out.println("f==g:"+(f==g));
		System.out.println("h==i:"+(h==i));
		System.out.println("h2==i2:"+(h2==i2));
		System.out.println("j==k:"+(j==k));
		System.out.println("j2==k2:"+(j2==k2));*/
        System.out.println(System.currentTimeMillis());
        String pathStr="/root/usr/etc/tmpaa";
        System.out.println(pathStr);
        if (pathStr.startsWith("/")) {
        	pathStr = pathStr.substring(1);
        	}
        System.out.println(pathStr);
        }
}
