package kontaktmngr;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kontaktmngr.dal.Connection;
import kontaktmngr.model.Person;

/**
 * This class contains only the main method.
 */
public class KontaktManager
{
	public static void main(String[] args)
	{
		Connection c = Connection.getInstance();
		List<Person> persons = new ArrayList<>();
		try
		{
			persons = c.getPersonsFirstData();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}
