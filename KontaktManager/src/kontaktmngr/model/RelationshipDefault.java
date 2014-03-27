package kontaktmngr.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import kontaktmngr.dal.Visitor;

public class RelationshipDefault extends DefaultEntity implements Relationship {

	private ObjectProperty<Person> _person1;
	private ObjectProperty<Person> _person2;
	
	public RelationshipDefault(int id, String description, Person person1, Person person2) {
		super(id, description);
		_person1 = new SimpleObjectProperty<Person>(this, "Person1", person1);
		_person2 = new SimpleObjectProperty<Person>(this, "Person2", person2);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObjectProperty<Person> person1Property() {
		return _person1;
	}

	@Override
	public ObjectProperty<Person> person2Property() {
		// TODO Auto-generated method stub
		return _person2;
	}

	
	
}
