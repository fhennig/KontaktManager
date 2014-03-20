package kontaktmngr.model;

import javafx.beans.property.StringProperty;

public interface Entity
{	
	//TODO needs a changetracker
	//TODO needs a "changed" event
	public int getId();
	
	public StringProperty descriptionProperty();
}
