package kontaktmngr.dal;

import java.util.HashMap;
import java.util.Map;

/**
 * Generic superclass for Loaders.
 * Created to avoid code duplication
 */
public abstract class Loader<T> {
	
	protected Map<Integer, T> _objects = new HashMap<>();
	
	public T get(int id)
	{
		T o = _objects.get(id);
		if (o != null)
			return o;
		
		load(id);
		o = _objects.get(id);
		return o;
	}

	/**
	 * This method should load the object specified by the id
	 * and put it into the map.
	 */
	protected abstract void load(int id);
}
