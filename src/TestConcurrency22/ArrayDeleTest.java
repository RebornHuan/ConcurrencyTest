package TestConcurrency22;
import java.util.ArrayList;
import java.util.List;


public class ArrayDeleTest {
	public static void main(String[] args) {
		/**DEMON ONE*/
/*		List<String> tmp = new ArrayList<String>();
		        tmp.add("1");
		        tmp.add("2");
		        tmp.add(null);
		        tmp.add(null);
		        System.out.println(tmp.size());
		for (int i=0;i<tmp.size();i++) {
		            System.out.println("---"+tmp.get(i));
		            if (null == tmp.get(i)) {
		                tmp.remove(i);
		            }
		        }
		        System.out.println(tmp.size());*/
		/** two*/
		List<String> tmp = new ArrayList<String>();
        tmp.add(null);
        tmp.add(null);
        tmp.add("1");
        tmp.add("2");
        System.out.println(tmp.size());
        for (int i=tmp.size()-1;i>=0;i--) {
            System.out.println("------"+tmp.get(i));
            if (null == tmp.get(i)) {
                tmp.remove(i);
            }
        }
        System.out.println(tmp.size());
    }  
		    

}
