package kontaktmngr.model;

import kontaktmngr.dal.Visitor;

public class Meeting extends DefaultEntity
{

	public Meeting(int id, String description)
	{
		super(id, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
