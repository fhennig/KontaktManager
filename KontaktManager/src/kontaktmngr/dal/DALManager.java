package kontaktmngr.dal;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * This class is a singleton, but it does not use lazy initialization,
 * it needs to be initialized via the static init(..) method.
 *
 */
public class DALManager
{
	private static DALManager _instance = null;
	
	private final DataSource _dataSource;
	private final PersonLoader _personLoader = new PersonLoader();
	private final CategoryLoader _categoryLoader = new CategoryLoader();
	private final PictureLoader _pictureLoader = new PictureLoader();
	
	
	
	private DALManager(DataSource ds) { _dataSource = ds; }
	
	/**
	 * Initializes the DALManager singleton
	 * @param dbCred  the credentials that should be used to connect to the database
	 * @throws SQLException  if the credentials are not valid
	 * @throws PropertyVetoException  if the database driver could not be loaded
	 */
	public static void init(DatabaseCredentials dbCred) throws SQLException, PropertyVetoException
	{
		if (_instance != null)
			return; //already initialized
		
		DataSource ds = DataSourceFactory.getDataSource(dbCred); //Exceptions thrown here
		
		_instance = new DALManager(ds);
	}
	
	public static DALManager getInstance()
	{
		if (_instance == null)
			throw new NullPointerException("DALManager was not initialized!");
		
		return _instance;
	}
	

	
	/** Returns an open connection. */
	public Connection getOpenConnnection() throws SQLException
	{
		return _dataSource.getConnection();
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
