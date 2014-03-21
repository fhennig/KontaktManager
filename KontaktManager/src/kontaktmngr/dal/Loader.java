package kontaktmngr.dal;

import java.util.HashMap;
import java.util.Map;

import kontaktmngr.model.Person;
import kontaktmngr.model.PersonDefault;

public abstract class Loader<E> {
	
	protected Map<Integer, E> _objects = new HashMap<>();
	
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
