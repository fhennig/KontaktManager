package kontaktmngr.model;

import javafx.beans.property.StringProperty;

public class DefaultEntity implements Entity
{
	private final int _id;
	private StringProperty _description;
	private ChangeState _state; //TODO
	
	
	
	public DefaultEntity(int id)
	{
		_id = id;
	}



	@Override public ChangeState getChangeState() { return _state; }

	@Override public int getId() { return _id; }

	@Override public String getDescription() { return _description.get(); }
	@Override public void setDescription(String description) { _description.set(description); }
	@Override public StringProperty descriptionProperty() { return _description; }
}
