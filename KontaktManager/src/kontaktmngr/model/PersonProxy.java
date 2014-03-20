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
	private boolean _initializationValidated = false;
	
	
	
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
	
	/**
	 * This method is to be called if a ListProperty is requested.
	 * It checks if the list properties are uninitialized and if that is the case,
	 * it initializes them.
	 */
	private void validateListsAreInitialized()
	{
		if (_initializationValidated)
			return;
		
		if (_originalPerson.adressesProperty() == null) //check for any list property if it is null
		{
			DALManager.getInstance().getPersonLoader().loadLists(_personId);
			_initializationValidated = true;
		}
	}
	
	@Override
	public int getId()
	{
		return _personId;
	}

	@Override
	public StringProperty descriptionProperty()
	{
		return getOriginalPerson().descriptionProperty();
	}

	@Override
	public StringProperty titleProperty()
	{
		return getOriginalPerson().titleProperty();
	}

	@Override
	public StringProperty forenameProperty()
	{
		return getOriginalPerson().forenameProperty();
	}

	@Override
	public StringProperty surnameProperty()
	{
		return getOriginalPerson().surnameProperty();
	}

	@Override
	public StringProperty nicknameProperty()
	{
		return getOriginalPerson().nicknameProperty();
	}

	@Override
	public ObjectProperty<Calendar> birthdayProperty()
	{
		return getOriginalPerson().birthdayProperty();
	}

	@Override
	public StringProperty genderProperty()
	{
		return getOriginalPerson().genderProperty();
	}

	@Override
	public ReadOnlyListProperty<Adress> adressesProperty()
	{
		validateListsAreInitialized();
		return getOriginalPerson().adressesProperty();
		
	}

	@Override
	public ReadOnlyListProperty<Phone> phonesProperty()
	{
		validateListsAreInitialized();
		return getOriginalPerson().phonesProperty();
	}

	@Override
	public ReadOnlyListProperty<Identification> identificationsProperty()
	{
		validateListsAreInitialized();
		return getOriginalPerson().identificationsProperty();
	}

	@Override
	public ReadOnlyListProperty<Category> categoriesProperty()
	{
		validateListsAreInitialized();
		return getOriginalPerson().categoriesProperty();
	}

	@Override
	public ReadOnlyListProperty<Relationship> relationshipsProperty()
	{
		validateListsAreInitialized();
		return getOriginalPerson().relationshipsProperty();
	}
	
	@Override
	public String toString()
	{
		return "PersonProxy for: " + getOriginalPerson().toString();
	}
}
