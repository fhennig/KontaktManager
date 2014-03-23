package kontaktmngr.model;

import java.time.LocalDate;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonDefault extends DefaultEntity implements Person
{
	private ListProperty<Adress> _adresses;
	private ListProperty<Phone> _phones;
	private ListProperty<Identification> _identifications;
	private ListProperty<Category> _categories;
	private ListProperty<Relationship> _relationships;

	private StringProperty _title;
	private StringProperty _forename;
	private StringProperty _surname;
	private StringProperty _nickname;
	private ObjectProperty<LocalDate> _birthday;
	private StringProperty _gender;
	//TODO avatar-id
	
	
	public PersonDefault(int id,
			String title,
			String forename,
			String surname,
			String nickname,
			LocalDate birthday,
			String gender,
			String description)
	{
		super(id, description);
		initBasics(title, forename, surname, nickname, birthday, gender);
	}

	
	
	private void initBasics(String title,
			String forename,
			String surname,
			String nickname,
			LocalDate birthday,
			String gender)
	{
		_title = new SimpleStringProperty(this, "Title", title);
		_forename = new SimpleStringProperty(this, "Forename", forename);
		_surname = new SimpleStringProperty(this, "Surname", surname);
		_nickname = new SimpleStringProperty(this, "Nickname", nickname);
		_birthday = new SimpleObjectProperty<LocalDate>(this, "Birthday", birthday);
		_gender = new SimpleStringProperty(this, "Gender", gender);
	}
	
	public void initLists( List<Adress> adresses, 
			List<Phone> phones,
			List<Identification> identifications, 
			List<Category> categories,
			List<Relationship> relationships)
	{
		_adresses = new SimpleListProperty<>(this, "Adresses", new ObservableListWrapper<>(adresses));
		_phones = new SimpleListProperty<>(this, "Phones", new ObservableListWrapper<>(phones));
		_identifications = new SimpleListProperty<>(this, "Identifications", new ObservableListWrapper<>(identifications));
		_categories = new SimpleListProperty<>(this, "Categories", new ObservableListWrapper<>(categories));
		_relationships = new SimpleListProperty<>(this, "Relationships", new ObservableListWrapper<>(relationships));
	}

	
	
	@Override public StringProperty titleProperty() { return _title; }

	@Override public StringProperty forenameProperty() { return _forename; }

	@Override public StringProperty surnameProperty() { return _surname; }

	@Override public StringProperty nicknameProperty() { return _nickname; }

	@Override public ObjectProperty<LocalDate> birthdayProperty() { return _birthday; }

	@Override public StringProperty genderProperty() { return _gender; }
	
	
	@Override public ReadOnlyListProperty<Adress> adressesProperty() { return _adresses; }
	
	@Override public ReadOnlyListProperty<Phone> phonesProperty() { return _phones; }
	
	@Override public ReadOnlyListProperty<Identification> identificationsProperty() { return _identifications; }
	
	@Override public ReadOnlyListProperty<Category> categoriesProperty() { return _categories; }
	
	@Override public ReadOnlyListProperty<Relationship> relationshipsProperty() { return _relationships; }

	
	@Override
	public String toString()
	{
		return getId() + ": " + _forename + " " + _surname;
	}
}
