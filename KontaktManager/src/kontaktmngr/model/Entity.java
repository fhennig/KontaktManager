package kontaktmngr.model;

import javafx.beans.property.StringProperty;

public interface Entity
{	
	public int getId();
	
	public StringProperty descriptionProperty();
}
