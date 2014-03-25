package kontaktmngr.model;

import kontaktmngr.dal.Visitor;

public class Phone extends DefaultEntity
{
	private long _number;
	
	
	
	public Phone(int id, long number, String description)
	{
		super(id, description);
		_number = number;
	}

	
	
	public long getNumber()
	{
		return _number;
	}
	
	public void setNumber(long number)
	{
		_number = number;
	}



	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
