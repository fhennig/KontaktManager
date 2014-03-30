package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.ObservableList;
import kontaktmngr.model.Phone;

public class PhoneListLoader extends Loader<ObservableList<Phone>> {
	private static PhoneListLoader _instance;

	private PhoneListLoader() {
	}

	public static PhoneListLoader getInstance() {
		if (_instance == null)
			_instance = new PhoneListLoader();

		return _instance;
	}

	@Override
	protected void load(int id) {
		try {
			Connection connection = DALManager.getInstance()
					.getOpenConnnection();
			PreparedStatement ps = connection
					.prepareStatement(SQLConstants.select_all_where_ispersonid_by_id(SQLConstants.PHONES_TABLE));
			ps.setInt(2, id);

			List<Phone> phones = new ArrayList<Phone>();
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phone p = new Phone(rs.getInt("id"), rs.getLong("number"), rs.getString("description"));
				phones.add(p);
			}
			
			_objects.put(id, new ObservableListWrapper<>(phones));

		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}
