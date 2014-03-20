package kontaktmngr;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.DatabaseCredentials;
import kontaktmngr.model.Category;

/**
 * This class contains only the main method.
 */
public class KontaktManager
{	
	public static void main(String[] args) throws SQLException
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
				DALManager.init(dbCred);
				connectionEstablished = true;
			} catch (SQLException ignored) { JOptionPane.showMessageDialog(null, "Database connection failed!");}
			
			
			//Test: Kategorienübersicht
			Category c = DALManager.getInstance().getCategoryLoader().loadAll();
			System.out.println(c.descriptionProperty().get());
		}
	}
}
