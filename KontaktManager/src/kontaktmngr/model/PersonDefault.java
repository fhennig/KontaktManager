package kontaktmngr.model;

import java.util.Calendar;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
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
	private ListProperty<Relationship> _friends;

	private StringProperty _title;
	private StringProperty _forename;
	private StringProperty _surname;
	private StringProperty _nickname;
	private ObjectProperty<Calendar> _birthday;
	private StringProperty _gender;

	
	
	public PersonDefault(int id)
	{
		super(id);
	}

	
	
	public void initBasics(String title,
			String forename,
			String surname,
			String nickname,
			Calendar birthday,
			String gender)
	{
		_title = new SimpleStringProperty(this, "Title", title);
		_forename = new SimpleStringProperty(this, "Forename", forename);
		_surname = new SimpleStringProperty(this, "Surname", surname);
		_nickname = new SimpleStringProperty(this, "Nickname", nickname);
		_birthday = new SimpleObjectProperty<Calendar>(this, "Birthday", birthday);
		_gender = new SimpleStringProperty(this, "Gender", gender);
	}
	
	public void initFurther( List<Adress> adresses, 
			List<Phone> phones,
			List<Identification> identifications, 
			List<Category> categories,
			List<Person> friends)
	{
		_adresses = new SimpleListProperty<>(this, "Adresses", new ObservableListWrapper<>(adresses));
		_phones = new SimpleListProperty<>(this, "Phones", new ObservableListWrapper<>(phones));
		_identifications = new SimpleListProperty<>(this, "Identifications", new ObservableListWrapper<>(identifications));
		initFriends(friends);
	}
	
	private void initFriends(List<Person> persons)
	{
		
	}

	
	
	@Override public String getTitle() { return _title.get(); }
	@Override public void setTitle(String title) { _title.set(title); }
	@Override public StringProperty titleProperty() { return _title; }

	@Override public String getForename() { return _forename.get(); }
	@Override public void setForename(String forename) { _forename.set(forename); }
	@Override public StringProperty forenameProperty() { return _forename; }

	@Override public String getSurname() { return _surname.get(); }
	@Override public void setSurname(String surname) { _surname.set(surname); }
	@Override public StringProperty surnameProperty() { return _surname; }

	@Override public String getNickname() { return _nickname.get(); }
	@Override public void setNickname(String nickname) { _nickname.set(nickname); }
	@Override public StringProperty nicknameProperty() { return _nickname; }

	@Override public Calendar getBirthday() { return _birthday.get(); }
	@Override public void setBirthday(Calendar birthday) { _birthday.set(birthday); }
	@Override public ObjectProperty<Calendar> birthdayProperty() { return _birthday; }

	@Override public String getGender() { return _gender.get(); }
	@Override public void setGender(String gender) { _gender.set(gender); }
	@Override public StringProperty genderProperty() { return _gender; }

	
	
	public String toString()
	{
		return getId() + ": " + _forename + " " + _surname;
	}
}
