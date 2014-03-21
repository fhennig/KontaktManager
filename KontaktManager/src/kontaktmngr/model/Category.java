package kontaktmngr.model;

import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.StringProperty;

public interface Category extends Entity
{
	public StringProperty titleProperty();
	public ReadOnlyListProperty<Category> childrenProperty();
	public ReadOnlyListProperty<Person> membersProperty();
}
