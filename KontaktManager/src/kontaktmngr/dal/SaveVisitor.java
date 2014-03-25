package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneOffset;

import kontaktmngr.model.Person;

public class SaveVisitor implements Visitor {

	private static SaveVisitor _instance;

	private SaveVisitor() {
	}

	public static SaveVisitor getInstance() {
		if (_instance == null)
			_instance = new SaveVisitor();

		return _instance;
	}
	
	@Override
	public void visit(Person person) {
		try{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			if(person.getId()<0){
				PreparedStatement ps = connection.prepareStatement(SQLConstants.INSERT_PERSON_BY_VALUES);
				ps.setString(1, person.genderProperty().get());
				ps.setString(2, person.titleProperty().get());
				ps.setString(3, person.forenameProperty().get());
				ps.setString(4, person.surnameProperty().get());
				ps.setString(5, person.nicknameProperty().get());
				ps.setDate(6, new Date(person.birthdayProperty().get().atTime(0, 0, 0, 0).toInstant(ZoneOffset.UTC).getEpochSecond()));
				ps.setString(7, person.descriptionProperty().get());
				ResultSet rs = ps.executeQuery();
				rs.next();
				int id = rs.getInt(1);
				//TODO change the id of person.
			} else {
				PreparedStatement ps = connection.prepareStatement(SQLConstants.UPDATE_PERSON_BY_VALUES_ID);
				ps.setString(1, person.genderProperty().get());
				ps.setString(2, person.titleProperty().get());
				ps.setString(3, person.forenameProperty().get());
				ps.setString(4, person.surnameProperty().get());
				ps.setString(5, person.nicknameProperty().get());
				ps.setDate(6, new Date(person.birthdayProperty().get().atTime(0, 0, 0, 0).toInstant(ZoneOffset.UTC).getEpochSecond()));
				ps.setString(7, person.descriptionProperty().get());
				ps.setInt(8, person.getId());
				ps.execute();
				// TODO Falsche Benutzereingaben, die nicht verhindert wurden?
			}
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

}
