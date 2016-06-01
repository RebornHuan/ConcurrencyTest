package TestIterable;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class IterableTestTwo {
	private SortedMap<String, Long> privateRsrc = new TreeMap<String, Long>();

	IterableTestTwo() {
		privateRsrc.put("1", 1l);
		privateRsrc.put("3", 2l);
		privateRsrc.put("2", 3l);
		privateRsrc.put("4", 4l);
		privateRsrc.put("7", 5l);
		privateRsrc.put("6", 6l);
		privateRsrc.put("5", 7l);
		privateRsrc.put("8", 8l);
		privateRsrc.put("9", 9l);

	}

	public static void main(String args[]) {
		IterableTestTwo tmp = new IterableTestTwo();
		for (Long a : tmp.getPrivateRsrc().values()) {
			a = 10l;

		}
		for(Iterator<Entry<String, Long>> i =
				tmp.getPrivateRsrc().entrySet().iterator();i.hasNext();){
			Entry<String, Long> rsrc = i.next();
//			rsrc.setValue(888888l);
			Long aaa=rsrc.getValue();
			System.out.println(aaa);

		}
	}

	public SortedMap<String, Long> getPrivateRsrc() {
		return privateRsrc;
	}

	public void setPrivateRsrc(SortedMap<String, Long> privateRsrc) {
		this.privateRsrc = privateRsrc;
	}

}
