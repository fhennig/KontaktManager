package kontaktmngr.model;

import java.util.Calendar;

public interface Person
{

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract String getForename();

	public abstract void setForename(String forename);

	public abstract String getSurname();

	public abstract void setSurname(String surname);

	public abstract String getNickname();

	public abstract void setNickname(String nickname);

	public abstract Calendar getBirthday();

	public abstract void setBirthday(Calendar birthday);

	public abstract char getGender();

	public abstract void setGender(char gender);

}