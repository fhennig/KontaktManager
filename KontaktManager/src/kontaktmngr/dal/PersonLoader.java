package kontaktmngr.dal;

import kontaktmngr.model2.Person;


public class PersonLoader
{
	private static PersonLoader _instance;

	
	
	private PersonLoader() { }
	
	public static PersonLoader getInstance()
	{
		if (_instance == null)
			_instance = new PersonLoader();
		
		return _instance;
	}
	
	
	
	public void initName(Person person)
	{
		int persId = person.getId();
		//TODO database stuff;
		String name = "TODO";
		person.initName(name);
	}
}
