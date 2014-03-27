package kontaktmngr.model;

import javafx.beans.property.ObjectProperty;

public interface Relationship extends Entity
{

	public ObjectProperty<Person> person1Property();
	public ObjectProperty<Person> person2Property();

}
