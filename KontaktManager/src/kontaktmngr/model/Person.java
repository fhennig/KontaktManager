package kontaktmngr.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person extends Entity
{
	private final List<Adress> _adresses = new ArrayList<>();
	private final List<Phone> _phones = new ArrayList<>();
	private final List<Identification> _identifications = new ArrayList<>();
	private final List<Person> _relationships = new ArrayList<>();
	//List Category
	//Person fields
	//gender: char oder boolean?
	private String _title;
	private String _forename;
	private String _surname;
	private String _nickname;
	private Calendar _birthday;
	
	public Person(int id)
	{
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String get_title() {
		return _title;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	public String get_forename() {
		return _forename;
	}

	public void set_forename(String _forename) {
		this._forename = _forename;
	}

	public String get_surname() {
		return _surname;
	}

	public void set_surname(String _surname) {
		this._surname = _surname;
	}

	public String get_nickname() {
		return _nickname;
	}

	public void set_nickname(String _nickname) {
		this._nickname = _nickname;
	}

	public Calendar get_birthday() {
		return _birthday;
	}

	public void set_birthday(Calendar _birthday) {
		this._birthday = _birthday;
	}
	
	public String toString()
	{
		return getId() + ": " + _forename + " " + _surname;
	}
}
