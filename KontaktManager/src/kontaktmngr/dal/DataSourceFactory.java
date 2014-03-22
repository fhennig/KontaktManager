package kontaktmngr.dal;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceFactory
{
	/**
	 * Factory method to create a DataSource that can be used to get an open connection.
	 * @param dbCred  the credentials to use for a database connection
	 * @throws SQLException  if the given credentials are not valid
	 * @throws PropertyVetoException  if the DriverClass could not be loaded
	 */
	public static DataSource getDataSource(DatabaseCredentials dbCred) throws SQLException, PropertyVetoException
	{
		//Test the given credentials
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://" + dbCred.getHost() + ":5432/Kontaktmngr",
				dbCred.getUser(), dbCred.getPassword());
		connection.close();
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl("jdbc:postgresql://" + dbCred.getHost() + ":5432/Kontaktmngr");
		cpds.setUser(dbCred.getUser());                                  
		cpds.setPassword(dbCred.getPassword()); 
		return cpds;
	}
}
