package TestIterable;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

public class IterableTestOne {
	  private long delSize;
	  private long currentSize;
	  private final SortedMap<LocalizedResource,LocalResourcesTracker> retain=null;
	  
	  
	  public void addResources(LocalResourcesTracker newTracker) {
		    for (LocalizedResource resource : newTracker) {
		      currentSize += resource.getSize();
		      retain.put(resource, newTracker);
		    }
		    for (Iterator<Map.Entry<LocalizedResource,LocalResourcesTracker>> i =
		           retain.entrySet().iterator();i.hasNext();) {
		      Map.Entry<LocalizedResource,LocalResourcesTracker> rsrc = i.next();
		      LocalizedResource resource = rsrc.getKey();
		      LocalResourcesTracker tracker = rsrc.getValue();
		      if (tracker.remove(resource)) {
		        delSize += resource.getSize();
		        i.remove();
		      }
		    }
		  }
	  public static void main(String args[]){
		  LocalResourcesTracker tmp=null;
		  IterableTestOne a=new IterableTestOne();
		  a.addResources(tmp);
		  
	  }

}
