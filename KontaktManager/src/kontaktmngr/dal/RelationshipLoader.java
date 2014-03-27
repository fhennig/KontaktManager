package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.ObservableList;
import kontaktmngr.model.Relationship;
import kontaktmngr.model.RelationshipDefault;

public class RelationshipLoader extends Loader<Relationship> {

	private static RelationshipLoader _instance;

	private RelationshipLoader() {
	}

	public static RelationshipLoader getInstance() {
		if (_instance == null)
			_instance = new RelationshipLoader();

		return _instance;
	}

	@Override
	protected void load(int id) {
		try {
			Connection connection = DALManager.getInstance()
					.getOpenConnnection();
			PreparedStatement ps = connection
					.prepareStatement(SQLConstants.SELECT_ALL_BY_TABLE_ID);
			ps.setString(1, SQLConstants.RELATIONSHIP_TABLE);
			ps.setInt(2, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				RelationshipDefault relationship = new RelationshipDefault(id,
						rs.getString("description"), DALManager.getInstance()
								.getPersonLoader().get(rs.getInt("person1")),
						DALManager.getInstance().getPersonLoader()
								.get(rs.getInt("person2")));
				_objects.put(id, relationship);
			} else {
				throw new IllegalArgumentException("No Relationship with ID="
						+ id + " found in Database.");
			}
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public ObservableList<Relationship> getRelationshipsOf(int personId) {
		try {
			Connection connection = DALManager.getInstance().getOpenConnnection();
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_RELATIONSHIPIDID_OF_PERSON_BY_ID);
			ps.setInt(1, personId);
			
			ResultSet rs = ps.executeQuery();
			List<Relationship> relationships = new ArrayList<Relationship>();
			
			while(rs.next()){
				relationships.add(get(rs.getInt(1)));
			}
			return new ObservableListWrapper<Relationship>(relationships);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

}
