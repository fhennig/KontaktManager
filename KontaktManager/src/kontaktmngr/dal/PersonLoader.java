package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kontaktmngr.model.Person;
import kontaktmngr.model.PersonDefault;


public class PersonLoader
{	
	private Map<Integer, PersonDefault> _persons = new HashMap<>();
	
	
	
	
	public Person getPerson(int personId)
	{
		Person p = _persons.get(personId);
		if (p != null)
			return p;
		
		loadPerson(personId);
		p = _persons.get(personId);
		return p;
	}
	
	private void loadPerson(int personId)
	{
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PersonDefault p = new PersonDefault(personId);
		//TODO Load person from db
		//save person to map
		
		//If loading from DB fails, convert SQL exception to unchecked exception
		throw new IllegalArgumentException("No Person with ID=" + personId + " found in Database.");
	}
	
	public void loadLists(int personId)
	{
		//TODO load lists using other Loaders for Phone, Identifications etc.
		//_persons.get(personId).initLists(adresses, phones, identifications, categories, relationships);
	}
}
