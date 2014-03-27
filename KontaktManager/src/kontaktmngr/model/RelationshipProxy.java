package kontaktmngr.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import kontaktmngr.dal.RelationshipLoader;
import kontaktmngr.dal.Visitor;

public class RelationshipProxy implements Relationship{

	private final int _id;
	private Relationship _originalRelationship;
	
	public RelationshipProxy(int id) {
		_id = id;
	}
	
	private Relationship getOriginalRelationship(){
		if(_originalRelationship == null)
			_originalRelationship = RelationshipLoader.getInstance().get(_id);
		
		return _originalRelationship;
	}
	
	@Override
	public int getId() {
		return _id;
	}

	@Override
	public StringProperty descriptionProperty() {
		return getOriginalRelationship().descriptionProperty();
	}

	@Override
	public ObjectProperty<Person> person1Property() {
		return getOriginalRelationship().person1Property();
	}

	@Override
	public ObjectProperty<Person> person2Property() {
		return getOriginalRelationship().person2Property();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
	}
	
}
