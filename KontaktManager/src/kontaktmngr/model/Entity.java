package kontaktmngr.model;

import javafx.beans.property.StringProperty;
import kontaktmngr.dal.Visitor;

public interface Entity
{	
	//TODO needs a changetracker
	//TODO needs a "changed" event
	public int getId();
	
	public StringProperty descriptionProperty();
	public void accept(Visitor visitor);
}
