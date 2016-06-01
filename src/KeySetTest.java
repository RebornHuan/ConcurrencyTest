import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KeySetTest {
	public static void main(String[] args) {
		HashMap hashMap = new HashMap();
		hashMap.put("a", "zhang");
		hashMap.put("b", "zhang");
		hashMap.put("s", "zhng");
		Set set = hashMap.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String s1 = (String) iterator.next();
			String s2 = (String) hashMap.get(s1);
			System.out.println(s1 + ":" + s2);
		}

		List<String> appIds = new ArrayList<String>(hashMap.keySet());
		System.out.println(appIds.size());
		System.out.println(appIds.get(0));
		System.out.println(appIds.get(1));
		System.out.println(appIds.get(2));
		System.out.println(hashMap.keySet());

	}

}
