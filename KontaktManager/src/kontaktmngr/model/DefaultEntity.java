package kontaktmngr.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class DefaultEntity implements Entity
{
	private final int _id;
	private StringProperty _description;
	
	
	
	public DefaultEntity(int id, String description)
	{
		_id = id;
		_description = new SimpleStringProperty(this, "Description", description);
	}


	
	@Override public int getId() { return _id; }

	@Override public StringProperty descriptionProperty() { return _description; }
}
