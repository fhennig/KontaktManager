package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import kontaktmngr.model.Person;
import kontaktmngr.model.PersonDefault;


public class PersonLoader extends Loader<Person>
{	
	protected void load(int id)
	{
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			ResultSet rs = connection.createStatement().executeQuery("select * from persons where id = " + id + ";");
			if(rs.next()){
				Calendar birthday = null;
				if(rs.getDate("birthday") != null){
					birthday = Calendar.getInstance();
					birthday.setTime(rs.getDate("birthday"));
				}
				_objects.put(id, new PersonDefault(id, rs.getString("title"), rs.getString("forename"), rs.getString("surname"), rs.getString("nickname"), birthday, rs.getString("gender")));
			} else {
				throw new IllegalArgumentException("No Person with ID=" + id + " found in Database.");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadLists(int personId)
	{
		//TODO load lists using other Loaders for Phone, Identifications etc.
		//_persons.get(personId).initLists(adresses, phones, identifications, categories, relationships);
	}
}
