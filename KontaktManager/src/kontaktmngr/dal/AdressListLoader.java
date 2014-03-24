package kontaktmngr.dal;

import javafx.collections.ObservableList;
import kontaktmngr.model.Adress;

public class AdressListLoader extends Loader<ObservableList<Adress>>
{
	private static AdressListLoader _instance;
	
	
	
	private AdressListLoader() { }
	
	public static AdressListLoader getInstance()
	{
		if (_instance == null)
			_instance = new AdressListLoader();
		
		return _instance;
	}

	
	
	@Override
	protected void load(int id)
	{
		// TODO Auto-generated method stub
		
	}
}
