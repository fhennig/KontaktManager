package kontaktmngr.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.StringProperty;

import javax.swing.JOptionPane;

import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.DatabaseCredentials;

public interface Picture extends Entity {
	
	public StringProperty filenameProperty();
	// picture data - there is no ImageProperty in javafx.
	 
//	//Test..
//	public static void main(String[] args) throws SQLException, IOException {
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
//			} catch (SQLException ignored) { JOptionPane.showMessageDialog(null, "Database connection failed!");}
//			
//		}
//		
//		File file = new File("C:\\Users\\Chaoran\\Desktop\\user_image.png");
//		Connection conn = DALManager.getInstance().getOpenConnnection();
//		
//		PreparedStatement ps =conn.prepareStatement("insert into pictures(id, person, picture, description) values (default, 6, ?, 'Super schön!') returning id");
//		FileInputStream in = new FileInputStream(file);
//		ps.setBinaryStream(1, in, file.length());
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		System.out.println(rs.getInt(1)); //id des Bildes.
//		
//		//Bild laden.
//		rs = conn.createStatement().executeQuery("select id, picture from pictures;");
//		while(rs.next()){
//			byte[] buff = rs.getBytes(2);
//			//b.getBinaryStream();
//			FileOutputStream out = new FileOutputStream("C:\\Users\\Chaoran\\Desktop\\tmp\\" + rs.getInt(1) + ".jpg");
//			out.write(buff);
//			out.close();
//		}
//		
//		conn.close();
//	}
	
}
