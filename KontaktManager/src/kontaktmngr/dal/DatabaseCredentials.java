package kontaktmngr.dal;

public class DatabaseCredentials
{
	private String _host;
	private String _user;
	private String _password;
	
	
	
	public DatabaseCredentials(String host, String user, String password)
	{
		_host = host;
		_user = user;
		_password = password;
	}



	public String getHost()
	{
		return _host;
	}

	public String getUser()
	{
		return _user;
	}

	public String getPassword()
	{
		return _password;
	}
}
