package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kontaktmngr.model.PersonDefault;

public class DALManager
{
	private String _host;
	private String _user;
	private String _password;
	private DatabaseCredentials _dbCred;
	
	public DALManager(DatabaseCredentials dbCred) throws SQLException
	{
		_dbCred = dbCred;
		
		getOpenConnnection().close(); //Test the credentials
	}
	
	/**
	 * Returns an open connection. The connection should be closed after usage.
	 */
	private Connection getOpenConnnection() throws SQLException
	{
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://" + _dbCred.getHost() + ":5432/Kontaktmngr",
					_dbCred.getUser(), _dbCred.getPassword());
			return connection;
	}
	
//	public List<Person> getPersonsFirstData() throws SQLException
//	{
//		open();
//		ResultSet rs = connection.createStatement().executeQuery(
//				"select id, forename, surname from persons order by forename;");
//		List<Person> result = new ArrayList<Person>();
//		while (rs.next()) {
//			Person person = new Person(rs.getInt(1));
//			person.setForename(rs.getString(2));
//			person.setSurname(rs.getString(3));
//			result.add(person);
//		}
//		connection.close();
//		return result;
//	}	
}
