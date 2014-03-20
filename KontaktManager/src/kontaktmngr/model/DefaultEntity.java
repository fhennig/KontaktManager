package kontaktmngr.model;

import javafx.beans.property.StringProperty;

public class DefaultEntity implements Entity
{
	private final int _id;
	private StringProperty _description;
	
	
	
	public DefaultEntity(int id)
	{
		_id = id;
	}


	
	@Override public int getId() { return _id; }

	@Override public StringProperty descriptionProperty() { return _description; }
}
