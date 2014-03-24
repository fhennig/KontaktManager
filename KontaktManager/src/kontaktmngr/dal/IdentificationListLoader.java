package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.ObservableList;
import kontaktmngr.model.Adress;
import kontaktmngr.model.Identification;

public class IdentificationListLoader extends
		Loader<ObservableList<Identification>> {
	private static IdentificationListLoader _instance;

	private IdentificationListLoader() {
	}

	public static IdentificationListLoader getInstance() {
		if (_instance == null)
			_instance = new IdentificationListLoader();

		return _instance;
	}

	@Override
	protected void load(int id) {
		try {
			Connection connection = DALManager.getInstance()
					.getOpenConnnection();
			PreparedStatement ps = connection
					.prepareStatement(SQLConstants.SELECT_ALL_WHERE_ISPERSONID_BY_TABLE_ID);
			ps.setString(1, SQLConstants.IDENTIFICATION_TABLE);
			ps.setInt(2, id);

			List<Identification> identifications = new ArrayList<Identification>();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Identification i = new Identification(rs.getInt("id"),
						rs.getString("type"), rs.getString("identification"),
						rs.getString("description"));
				identifications.add(i);
			}

			_objects.put(id, new ObservableListWrapper<>(identifications));

		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}
