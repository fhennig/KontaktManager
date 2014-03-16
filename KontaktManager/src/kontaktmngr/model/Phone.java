package kontaktmngr.model;

public class Phone extends DefaultEntity
{
	private long _number;
	
	
	
	public Phone(int id, long number)
	{
		super(id);
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
}
