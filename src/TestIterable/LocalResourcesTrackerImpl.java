package TestIterable;

import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

public class LocalResourcesTrackerImpl implements LocalResourcesTracker{
	 private final ConcurrentMap<LocalResourceRequest,LocalizedResource> localrsrc;
	  @Override
	  public Iterator<LocalizedResource> iterator() {
	    return localrsrc.values().iterator();
	  }
	  LocalResourcesTrackerImpl(ConcurrentMap<LocalResourceRequest,LocalizedResource> localrsrc) {
		    this.localrsrc = localrsrc;
		  }
	@Override
	public boolean remove(LocalizedResource rem) {
	
	      localrsrc.remove(rem);
	      return true;
	  }

}
