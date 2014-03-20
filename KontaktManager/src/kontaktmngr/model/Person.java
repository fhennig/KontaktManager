package kontaktmngr.model;

import java.util.Calendar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.StringProperty;

public interface Person extends Entity
{
	public StringProperty titleProperty();

	public StringProperty forenameProperty();

	public StringProperty surnameProperty();

	public StringProperty nicknameProperty();

	public ObjectProperty<Calendar> birthdayProperty();

	public StringProperty genderProperty();
	
	
	public ReadOnlyListProperty<Adress> adressesProperty();
	
	public ReadOnlyListProperty<Phone> phonesProperty();
	
	public ReadOnlyListProperty<Identification> identificationsProperty();
	
	public ReadOnlyListProperty<Category> categoriesProperty();
	
	public ReadOnlyListProperty<Relationship> relationshipsProperty();
}