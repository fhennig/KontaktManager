package kontaktmngr;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.Address;
import ezvcard.property.Telephone;
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
		try {			
			VCard vcard = Ezvcard.parse(new File("C:\\Users\\Chaoran\\Desktop\\person.vcf")).first();
			if(vcard.getAddresses() != null){
				for (Address a : vcard.getAddresses()) {
					System.out.println(a.getStreetAddress());
				}
			}

			for (Telephone t : vcard.getTelephoneNumbers()) {
				System.out.println(t.getText());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		boolean connectionEstablished = false;
//		
//		while (!connectionEstablished)
//		{
//			String host = JOptionPane.showInputDialog("Server-IP");
//			String user = JOptionPane.showInputDialog("Username");
//			String password = JOptionPane.showInputDialog("Password");
//
//			DatabaseCredentials dbCred = new DatabaseCredentials(host, user,
//					password);
//
//			try
//			{
//				DALManager.init(dbCred);
//				connectionEstablished = true;
//			}
//			catch (SQLException ignored)    { JOptionPane.showMessageDialog(null, "Database connection failed!");}
//			catch (PropertyVetoException e) { JOptionPane.showMessageDialog(null, "Database driver could not be loaded!"); }
//		}
//		
//		
//		//Test: Kategorienübersicht
//		Category c = DALManager.getInstance().getCategoryLoader().loadAll();
//		System.out.println(c.descriptionProperty().get());
	}
}
