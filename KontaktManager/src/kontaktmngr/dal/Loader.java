package kontaktmngr.dal;

import java.util.HashMap;
import java.util.Map;

public abstract class Loader<E, S extends E> {
	
	protected Map<Integer, S> _objects = new HashMap<>();
	
	public E get(int id)
	{
		E o = _objects.get(id);
		if (o != null)
			return o;
		
		load(id);
		o = _objects.get(id);
		return o;
	}

	protected abstract void load(int id);
	
}
