package kontaktmngr.model;

public class Adress extends DefaultEntity
{
	private String _street;
	private int _housenumber;
	private int _postcode;
	private String _city;
	private String _country;

	
	
	public Adress(int id)
	{
		super(id);
	}



	public String getStreet()
	{
		return _street;
	}

	public void setStreet(String street)
	{
		_street = street;
	}

	public int getHousenumber()
	{
		return _housenumber;
	}

	public void setHousenumber(int housenumber)
	{
		_housenumber = housenumber;
	}

	public int getPostcode()
	{
		return _postcode;
	}

	public void setPostcode(int postcode)
	{
		_postcode = postcode;
	}

	public String getCity()
	{
		return _city;
	}

	public void setCity(String city)
	{
		_city = city;
	}

	public String getCountry()
	{
		return _country;
	}

	public void setCountry(String country)
	{
		_country = country;
	}
}
