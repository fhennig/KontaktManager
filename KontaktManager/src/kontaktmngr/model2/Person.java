package kontaktmngr.model2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person
{
	private final int _id;
	StringProperty _name;
	
	
	
	public Person(int id)
	{
		_id = id;
	}
	
	
	
	public void initName(String name) //Does not change the ChangeState
	{
		_name = new SimpleStringProperty(this, "Name", name);
	}
	
	public int getId()
	{
		return _id;
	}
	
	public String getName()
	{
		if (_name == null)
		{
			PersonLoader.getInstance().initName(this);
		}
		return _name.get();
	}
	
	public void setName(String name)
	{
		_name.set(name);
		//ChangeState.set(State.CHANGED);
	}
}
