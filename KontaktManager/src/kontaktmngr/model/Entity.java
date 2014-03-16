package kontaktmngr.model;

import javafx.beans.property.StringProperty;

public interface Entity
{
	public ChangeState getChangeState();
	
	public int getId();
	
	public String getDescription();
	public void setDescription(String description);
	public StringProperty descriptionProperty();
}
