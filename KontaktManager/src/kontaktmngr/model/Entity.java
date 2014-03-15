package kontaktmngr.model;

public class Entity
{
	private final int _id;
	private String _description;
	private ChangeState _state; //TODO
	
	
	public Entity(int id)
	{
		_id = id;
	}
	
	
	
	public int getId()
	{
		return _id;
	}
	
	public String getDescription()
	{
		return _description;
	}
	
	public void setDescription(String description)
	{
		_description = description;
	}
}
