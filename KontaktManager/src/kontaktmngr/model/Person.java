package kontaktmngr.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person extends Entity
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

	public Person(int id)
	{
		super(id);
		// TODO Auto-generated constructor stubkjklsjdfkl
	}

	public String getTitle()
	{
		return _title;
	}

	public void setTitle(String title)
	{
		_title = title;
	}

	public String getForename()
	{
		return _forename;
	}

	public void setForename(String forename)
	{
		_forename = forename;
	}

	public String getSurname()
	{
		return _surname;
	}

	public void setSurname(String surname)
	{
		_surname = surname;
	}

	public String getNickname()
	{
		return _nickname;
	}

	public void setNickname(String nickname)
	{
		_nickname = nickname;
	}

	public Calendar getBirthday()
	{
		return _birthday;
	}

	public void setBirthday(Calendar birthday)
	{
		_birthday = birthday;
	}

	public char getGender()
	{
		return _gender;
	}

	public void setGender(char gender)
	{
		_gender = gender;
	}

	public String toString()
	{
		return getId() + ": " + _forename + " " + _surname;
	}
}
