package kontaktmngr.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonDefault extends Entity implements Person
{
	private final List<Adress> _adresses = new ArrayList<>();
	private final List<Phone> _phones = new ArrayList<>();
	private final List<Identification> _identifications = new ArrayList<>();
	private final List<Relationship> _relationships = new ArrayList<>();
	private final List<Category> _categories = new ArrayList<>();

	private String _title;
	private String _forename;
	private String _surname;
	private String _nickname;
	private Calendar _birthday;
	private char _gender;

	
	
	public PersonDefault(int id)
	{
		super(id);
		// TODO Auto-generated constructor stubkjklsjdfkl
	}



	
	@Override
	public String getTitle()
	{
		return _title;
	}

	@Override
	public void setTitle(String title)
	{
		_title = title;
	}

	@Override
	public String getForename()
	{
		return _forename;
	}

	@Override
	public void setForename(String forename)
	{
		_forename = forename;
	}

	@Override
	public String getSurname()
	{
		return _surname;
	}

	@Override
	public void setSurname(String surname)
	{
		_surname = surname;
	}

	@Override
	public String getNickname()
	{
		return _nickname;
	}

	@Override
	public void setNickname(String nickname)
	{
		_nickname = nickname;
	}

	@Override
	public Calendar getBirthday()
	{
		return _birthday;
	}

	@Override
	public void setBirthday(Calendar birthday)
	{
		_birthday = birthday;
	}

	@Override
	public char getGender()
	{
		return _gender;
	}

	@Override
	public void setGender(char gender)
	{
		_gender = gender;
	}

	public String toString()
	{
		return getId() + ": " + _forename + " " + _surname;
	}
}
