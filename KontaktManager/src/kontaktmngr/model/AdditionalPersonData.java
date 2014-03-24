package kontaktmngr.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import kontaktmngr.dal.AdressListLoader;

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
	private ListProperty<Category> _categories = null;
	private ListProperty<Relationship> _relationships = null;
	

	public ReadOnlyListProperty<Adress> adressesProperty()
	{
		if (_adresses == null)
			_adresses = new SimpleListProperty<>(this, "Adresses", AdressListLoader.getInstance().get(_personId));
		
		return _adresses; 
	}
	
	public ReadOnlyListProperty<Phone> phonesProperty() { return _phones; } //TODO
	
	public ReadOnlyListProperty<Identification> identificationsProperty() { return _identifications; } //TODO
	
	public ReadOnlyListProperty<Category> categoriesProperty() { return _categories; } //TODO
	
	public ReadOnlyListProperty<Relationship> relationshipsProperty() { return _relationships; } //TODO

}
