package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is a singleton, but it does not use lazy initialization,
 * it needs to be initialized via the static init(..) method.
 *
 */
public class DALManager
{
	private static DALManager _instance = null;
	
	private final DatabaseCredentials _dbCred;
	private final PersonLoader _personLoader = new PersonLoader();
	private final CategoryLoader _categoryLoader = new CategoryLoader();
	private final PictureLoader _pictureLoader = new PictureLoader();
	
	
	private DALManager(DatabaseCredentials dbCred) { _dbCred = dbCred; }
	
	public static void init(DatabaseCredentials dbCred) throws SQLException
	{
		if (_instance != null)
			return; //already initialized
		
		//Test if credentials are valid; throws SQLException
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://" + dbCred.getHost() + ":5432/Kontaktmngr",
				dbCred.getUser(), dbCred.getPassword());
		connection.close();
		
		_instance = new DALManager(dbCred);
	}
	
	public static DALManager getInstance()
	{
		if (_instance == null)
			throw new NullPointerException("DALManager was not initialized!");
		
		return _instance;
	}
	

	
	/** Returns an open connection. The connection should be closed after usage. */
	public Connection getOpenConnnection() throws SQLException
	{
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://" + _dbCred.getHost() + ":5432/Kontaktmngr",
					_dbCred.getUser(), _dbCred.getPassword());
			return connection;
	}
	
	public PersonLoader getPersonLoader()
	{
		return _personLoader;
	}
	
	public CategoryLoader getCategoryLoader()
	{
		return _categoryLoader;
	}

	public PictureLoader getPictureLoader() {
		return _pictureLoader;
	}	
}
