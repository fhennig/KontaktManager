package kontaktmngr.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import kontaktmngr.dal.AdressListLoader;
import kontaktmngr.dal.CategoryLoader;
import kontaktmngr.dal.IdentificationListLoader;
import kontaktmngr.dal.PhoneListLoader;

public class AdditionalPersonData
{
	private final int _personId;
	
	
	public AdditionalPersonData(int personId)
	{
		_personId = personId;
	}
	
	
	
	private ListProperty<Adress> _adresses = null;
	private ListProperty<Phone> _phones = null;
	private ListProperty<Identification> _identifications = null;
	private ListProperty<Relationship> _relationships = null;
	

	public ReadOnlyListProperty<Adress> adressesProperty()
	{
		if (_adresses == null)
			_adresses = new SimpleListProperty<>(this, "Adresses", AdressListLoader.getInstance().get(_personId));
		
		return _adresses; 
	}
	
	public ReadOnlyListProperty<Phone> phonesProperty() { 
		if (_phones == null)
			_phones = new SimpleListProperty<>(this, "Phones", PhoneListLoader.getInstance().get(_personId));
		
		return _phones; 
	}
	
	public ReadOnlyListProperty<Identification> identificationsProperty() { 
		if (_identifications == null)
			_identifications = new SimpleListProperty<>(this, "Identifications", IdentificationListLoader.getInstance().get(_personId));
		
		return _identifications; 
	}
	
	/**
	 * Returns the categories of this person by asking the database everytime.
	 * @return
	 */
	public ReadOnlyListProperty<Category> categoriesProperty() { 
		return new SimpleListProperty<>(this, "Categories", CategoryLoader.getInstance().getCategoriesOf(_personId)); 
	}
	
	public ReadOnlyListProperty<Relationship> relationshipsProperty() { return _relationships; } //TODO

}
