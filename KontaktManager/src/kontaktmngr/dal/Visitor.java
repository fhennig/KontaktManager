package kontaktmngr.dal;

import kontaktmngr.model.Person;

public interface Visitor {
	
	public void visit(Person person);
	
}
