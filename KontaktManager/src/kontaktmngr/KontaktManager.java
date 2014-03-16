package kontaktmngr;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.DatabaseCredentials;

/**
 * This class contains only the main method.
 */
public class KontaktManager
{
	private static DALManager _dalManager;

	public static DALManager getDALManager()
	{
		return _dalManager;
	}
	
	public static void main(String[] args)
	{
		boolean connectionEstablished = false;
		
		while (!connectionEstablished)
		{
			String host = JOptionPane.showInputDialog("Server-IP");
			String user = JOptionPane.showInputDialog("Username");
			String password = JOptionPane.showInputDialog("Password");

			DatabaseCredentials dbCred = new DatabaseCredentials(host, user,
					password);

			try
			{
				_dalManager = new DALManager(dbCred);
				connectionEstablished = true;
			} catch (SQLException ignored) { JOptionPane.showMessageDialog(null, "Database connection failed!");}
		}
		// List<Person> persons = new ArrayList<>();
		// try
		// {
		// persons = c.getPersonsFirstData();
		// } catch (SQLException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// for (Person person : persons) {
		// System.out.println(person);
		// }
	}
}
