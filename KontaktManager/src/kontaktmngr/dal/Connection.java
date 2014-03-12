package kontaktmngr.dal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kontaktmngr.model.Person;

public class Connection
{
	private static Connection _instance;
	private static String _host;
	private static String _user;
	private static String _password;
	
	public static Connection getInstance()
	{
		if (_instance == null)
			_instance = new Connection();
		
		return _instance;
	}
	
	private java.sql.Connection connection;
	
	private Connection()
	{
		//Einfachheitshalber...
		_host = JOptionPane.showInputDialog("Server-IP");
		_user = JOptionPane.showInputDialog("Username");
		_password = JOptionPane.showInputDialog("Password");
	}
	
	private void open() throws SQLException
	{
		if (connection == null || connection.isClosed())
			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + _host + ":5432/Kontaktmngr",
					_user, _password);
	}
	
	private List<Person> getPersonsFirstData() throws SQLException
	{
		open();
		ResultSet rs = connection.createStatement().executeQuery(
				"select id, forename, surname from persons order by forename;");
		List<Person> result = new ArrayList<Person>();
		while (rs.next()) {
			Person person = new Person(rs.getInt(1));
			person.set_forename(rs.getString(2));
			person.set_surname(rs.getString(3));
			result.add(person);
		}
		connection.close();
		return result;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection c = Connection.getInstance();
		List<Person> persons = c.getPersonsFirstData();
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
}
