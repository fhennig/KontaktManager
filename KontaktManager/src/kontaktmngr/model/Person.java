package kontaktmngr.model;

import java.util.Calendar;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public interface Person extends Entity
{
	public String getTitle();
	public void setTitle(String title);
	public StringProperty titleProperty();

	public String getForename();
	public void setForename(String forename);
	public StringProperty forenameProperty();

	public String getSurname();
	public void setSurname(String surname);
	public StringProperty surnameProperty();

	public String getNickname();
	public void setNickname(String nickname);
	public StringProperty nicknameProperty();

	public Calendar getBirthday();
	public void setBirthday(Calendar birthday);
	public ObjectProperty<Calendar> birthdayProperty();

	public String getGender();
	public void setGender(String gender);
	public StringProperty genderProperty();
}