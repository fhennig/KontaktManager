package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtCompleted;

import kontaktmngr.model.Person;
import kontaktmngr.model.PersonDefault;


public class PersonLoader extends Loader<Person, PersonDefault>
{	
	protected void load(int id)
	{
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			ResultSet rs = connection.createStatement().executeQuery("select * from persons where id = " + id + ";");
			if(rs.next()){
				
				LocalDate birthday = null;
				if(rs.getDate("birthday") != null){
					Instant instant = Instant.ofEpochMilli(rs.getDate("birthday").getTime());
					birthday = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
				}
				_objects.put(id, new PersonDefault(id, rs.getString("title"), rs.getString("forename"), rs.getString("surname"), rs.getString("nickname"), birthday, rs.getString("gender"), rs.getString("description")));
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
