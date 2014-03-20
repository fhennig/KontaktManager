package kontaktmngr.model;

import java.util.Calendar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.StringProperty;
import kontaktmngr.dal.DALManager;

public class PersonProxy implements Person
{
	private Person _originalPerson = null;
	private final int _personId;
	
	
	
	public PersonProxy(int personId)
	{
		_personId = personId;
	}
	
	private Person getOriginalPerson()
	{
		if (_originalPerson == null)
			_originalPerson = DALManager.getInstance().getPersonLoader().getPerson(_personId);
		
		return _originalPerson;
	}
	
	@Override
	public int getId()
	{
		return _personId;
	}

	@Override
	public StringProperty descriptionProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringProperty titleProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringProperty forenameProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringProperty surnameProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringProperty nicknameProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectProperty<Calendar> birthdayProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringProperty genderProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadOnlyListProperty<Adress> adressesProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadOnlyListProperty<Phone> phonesProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadOnlyListProperty<Identification> identificationsProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadOnlyListProperty<Category> categoriesProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadOnlyListProperty<Relationship> relationshipsProperty()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
