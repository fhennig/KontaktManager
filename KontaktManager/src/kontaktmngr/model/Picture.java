package kontaktmngr.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.DatabaseCredentials;

public class Picture {
	
	//Test..
	public static void main(String[] args) throws SQLException, FileNotFoundException {
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
			
		}
		
		File file = new File("C:\\Users\\Chaoran\\Desktop\\user_image.png");
		Connection conn = DALManager.getInstance().getOpenConnnection();
		
		PreparedStatement ps =conn.prepareStatement("insert into pictures(id, person, picture, description) values (default, 6, ?, 'Super schön!') returning id");
		FileInputStream in = new FileInputStream(file);
		ps.setBinaryStream(1, in, file.length());
		ResultSet rs = ps.executeQuery();
		rs.next();
		System.out.println(rs.getInt(1));
		conn.close();
	}
	
}
