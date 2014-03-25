package kontaktmngr.model;

import kontaktmngr.dal.Visitor;

public class Relationship extends DefaultEntity
{

	public Relationship(int id, String description)
	{
		super(id, description);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
