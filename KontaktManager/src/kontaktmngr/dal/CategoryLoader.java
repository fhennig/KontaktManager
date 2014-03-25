package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.collections.ObservableList;
import kontaktmngr.model.Category;
import kontaktmngr.model.CategoryDefault;
import kontaktmngr.model.Person;
import kontaktmngr.model.PersonProxy;

public class CategoryLoader extends Loader<Category>{

	private static CategoryLoader _instance;
	
	private CategoryLoader(){ };
	
	public static CategoryLoader getInstance() {
		if (_instance == null)
			_instance = new CategoryLoader();

		return _instance;
	}
	
	@Override
	protected void load(int id) {
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_BY_COLUMNS_TABLE_ID);
			ps.setString(1, "id, title, description");
			ps.setString(2, SQLConstants.CATEGORIES_TABLE);
			ps.setInt(3, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				CategoryDefault category = new CategoryDefault(id, rs.getString(2), rs.getString(3));
				_objects.put(id, category);
			} else {
				throw new IllegalArgumentException("No Category with ID=" + id + " found in Database.");
			}
		} catch (SQLException e)
		{
			throw new IllegalStateException(e);
		}
	}
	

	public ObservableList<Category> getCategoriesOf(int personId){
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_CATEGORYID_OF_PERSON_BY_ID);
			ps.setInt(1, personId);
			ResultSet rs = ps.executeQuery();
			List<Category> categories = new ArrayList<Category>();
			
			while(rs.next()){
				categories.add(get(rs.getInt(1)));
			}
			return new ObservableListWrapper<Category>(categories);
		} catch (SQLException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	/**
	 * Loads all categories. Returns null, if there no category. The root-category is normally not a really category.
	 * @return
	 * @throws SQLException
	 */
	public Category loadAll()
	{
		try {
			Connection connection = DALManager.getInstance().getOpenConnnection();
			
			//Loads root
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_ROOT_FROM_CATEGORIES_BY_COLUMNS);
			ps.setString(1, "id, title, description");
			ResultSet rs = ps.executeQuery();
			CategoryDefault root = null;
			if(rs.next()){
				root = new CategoryDefault(rs.getInt(1), rs.getString(2), rs.getString(3));
				_objects.putIfAbsent(root.getId(), root);
				//Loads root's children.
				loadChildren(root.getId());
			}
			connection.close();
			return root;
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public void loadChildren(int id)
	{
		try {
			Connection connection = DALManager.getInstance().getOpenConnnection();
			
			ArrayList<Category> children = new ArrayList<Category>();
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_CHILDREN_FROM_CATEGORIES_BY_cCOLUMNS_ID);
			ps.setString(1, "c.id, c.title, c.description");
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CategoryDefault child = new CategoryDefault(rs.getInt(1), rs.getString(2), rs.getString(3));
				_objects.putIfAbsent(child.getId(), child);
				loadChildren(child.getId());
				children.add(child);
			}
			if(children.isEmpty())
				return;
			((CategoryDefault) _objects.get(id)).initChildren(children);
		} catch (SQLException e){
			throw new IllegalStateException(e);
		}
	}

	public void loadMembers(int id){
		try {
			Connection connection = DALManager.getInstance().getOpenConnnection();
			
			ArrayList<Person> members = new ArrayList<Person>();
			PreparedStatement ps = connection.prepareStatement(SQLConstants.SELECT_PERSONID_OF_CATEGORY_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Person member = new PersonProxy(rs.getInt(1));
				members.add(member);
			}
			if(members.isEmpty())
				return;
			((CategoryDefault) _objects.get(id)).initMembers(members);
		} catch (SQLException e){
			throw new IllegalStateException();
		}
		
	}
}
