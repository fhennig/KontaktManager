package kontaktmngr.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import kontaktmngr.dal.Visitor;

public class PersonDefault extends DefaultEntity implements Person
{

	private StringProperty _title;
	private StringProperty _forename;
	private StringProperty _surname;
	private StringProperty _nickname;
	private ObjectProperty<LocalDate> _birthday;
	private StringProperty _gender;
	//TODO avatar-id
	/** Contains the lazy loaded lists */
	private AdditionalPersonData _additionalData;
	
	
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
		_additionalData = new AdditionalPersonData(id);
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
	
	@Override public StringProperty titleProperty() { return _title; }

	@Override public StringProperty forenameProperty() { return _forename; }

	@Override public StringProperty surnameProperty() { return _surname; }

	@Override public StringProperty nicknameProperty() { return _nickname; }

	@Override public ObjectProperty<LocalDate> birthdayProperty() { return _birthday; }

	@Override public StringProperty genderProperty() { return _gender; }
	
	
	@Override public ReadOnlyListProperty<Adress> adressesProperty() { return _additionalData.adressesProperty(); }
	
	@Override public ReadOnlyListProperty<Phone> phonesProperty() { return _additionalData.phonesProperty(); }
	
	@Override public ReadOnlyListProperty<Identification> identificationsProperty() { return _additionalData.identificationsProperty(); }
	
	@Override public ReadOnlyListProperty<Category> categoriesProperty() { return _additionalData.categoriesProperty(); }
	
	@Override public ReadOnlyListProperty<Relationship> relationshipsProperty() { return _additionalData.relationshipsProperty(); }

	
	@Override
	public String toString()
	{
		return getId() + ": " + _forename + " " + _surname;
	}



	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
