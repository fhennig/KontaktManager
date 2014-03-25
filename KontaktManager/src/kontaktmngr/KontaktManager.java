package kontaktmngr;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.Address;
import ezvcard.property.Telephone;
import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.DatabaseCredentials;
import kontaktmngr.dal.SaveVisitor;
import kontaktmngr.model.Category;
import kontaktmngr.model.Person;
import kontaktmngr.model.PersonDefault;

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
			}
			catch (SQLException ignored)    { JOptionPane.showMessageDialog(null, "Database connection failed!");}
			catch (PropertyVetoException e) { JOptionPane.showMessageDialog(null, "Database driver could not be loaded!"); }
		}
		
		
//		//Test: Kategorienübersicht
//		Category c = DALManager.getInstance().getCategoryLoader().loadAll();
//		System.out.println(c.descriptionProperty().get());
		
		//Test: SaveVisitor: Person
		Person p = new PersonDefault(-1, "Prof. Dr.", "Max", "Mustermann", "Maxi", LocalDate.of(1970, 1, 1), "w", null);
		p.accept(SaveVisitor.getInstance()); // Wahrscheinlich mache ich wieder alles falsch...
	}
}
