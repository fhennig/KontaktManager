package kontaktmngr.dal;

public class Connection
{
	private static Connection _instance;
	
	public static Connection getInstance()
	{
		if (_instance == null)
			_instance = new Connection();
		
		return _instance;
	}
}
