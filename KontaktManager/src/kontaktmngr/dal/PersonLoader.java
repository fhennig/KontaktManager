package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import kontaktmngr.model.Person;
import kontaktmngr.model.PersonDefault;

public class PersonLoader extends Loader<Person>
{
	protected void load(int id)
	{
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_ALL_BY_TABLE_ID);
			ps.setString(1, SQLConstants.PERSONS_TABLE);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				LocalDate birthday = null;
				if (rs.getDate("birthday") != null)
				{
					Instant instant = Instant.ofEpochMilli(rs.getDate("birthday").getTime());
					birthday = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
				}
				_objects.put(id,
						new PersonDefault(id, rs.getString("title"),
											  rs.getString("forename"),
											  rs.getString("surname"),
											  rs.getString("nickname"),
											  birthday,
											  rs.getString("gender"),
											  rs.getString("description")));
			} else
			{
				throw new IllegalArgumentException("No Person with ID=" + id
						+ " found in Database.");
			}
		}
		catch (SQLException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
