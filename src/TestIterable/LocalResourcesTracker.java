package TestIterable;

public interface LocalResourcesTracker extends Iterable<LocalizedResource>{

	boolean remove(LocalizedResource resource);

}
