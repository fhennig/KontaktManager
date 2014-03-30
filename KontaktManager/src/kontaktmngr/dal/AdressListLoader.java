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

public class AdressListLoader extends Loader<ObservableList<Adress>> {
	private static AdressListLoader _instance;

	private AdressListLoader() {
	}

	public static AdressListLoader getInstance() {
		if (_instance == null)
			_instance = new AdressListLoader();

		return _instance;
	}

	@Override
	protected void load(int id) {
		try {
			Connection connection = DALManager.getInstance()
					.getOpenConnnection();
			PreparedStatement ps = connection
					.prepareStatement(SQLConstants.select_all_where_ispersonid_by_id(SQLConstants.ADDRESSES_TABLE));
			ps.setInt(1, id);

			List<Adress> addresses = new ArrayList<Adress>();
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Adress a = new Adress(rs.getInt("id"),
						rs.getString("description"), rs.getString("street"),
						rs.getInt("housenumber"), rs.getInt("postcode"),
						rs.getString("city"), rs.getString("country"));
				addresses.add(a);
			}
			
			_objects.put(id, new ObservableListWrapper<>(addresses));

		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}
