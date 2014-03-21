package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kontaktmngr.model.Category;
import kontaktmngr.model.CategoryDefault;
import kontaktmngr.model.Person;
import kontaktmngr.model.PersonProxy;

public class CategoryLoader extends Loader<Category, CategoryDefault>{

	@Override
	protected void load(int id) {
		try
		{
			Connection connection = DALManager.getInstance().getOpenConnnection();
			ResultSet rs = connection.createStatement().executeQuery("select id, title, description from categories where id = " + id + ";");
			if(rs.next()){
				CategoryDefault category = new CategoryDefault(id, rs.getString(2), rs.getString(3));
				_objects.put(id, category);
			} else {
				throw new IllegalArgumentException("No Category with ID=" + id + " found in Database.");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads all categories. Returns null, if there no category. The root-category is normally not a really category.
	 * @return
	 * @throws SQLException
	 */
	public Category loadAll() throws SQLException
	{
		Connection connection = DALManager.getInstance().getOpenConnnection();
		
		//Loads root
		ResultSet rs = connection.createStatement().executeQuery(
				"select id, title, description from categories where lft = 1;");
		CategoryDefault root = null;
		if(rs.next()){
			root = new CategoryDefault(rs.getInt(1), rs.getString(2), rs.getString(3));
			_objects.putIfAbsent(root.getId(), root);
			//Loads root's children.
			loadChildren(root.getId());
		}
		connection.close();
		return root;
	}

	public void loadChildren(int id) throws SQLException
	{
		Connection connection = DALManager.getInstance().getOpenConnnection();
		
		ArrayList<Category> children = new ArrayList<Category>();
		ResultSet rs = connection.createStatement().executeQuery(
				"select c.id, c.title, c.description "
						+ "from categories f, categories c" + "where f.id = " + id
						+ "and c.lft > f.lft " + "and c.rgt < f.rgt"
						+ "and not exists(" + "select * " + "from categories d"
						+ "where c.lft > d.lft " + "and c.rgt < d.rgt"
						+ "and d.lft > f.lft " + "and d.rgt < f.rgt);");
		while(rs.next()){
			CategoryDefault child = new CategoryDefault(rs.getInt(1), rs.getString(2), rs.getString(3));
			_objects.putIfAbsent(child.getId(), child);
			loadChildren(child.getId());
			children.add(child);
		}
		if(children.isEmpty())
			return;
		_objects.get(id).initChildren(children);
	}

	public void loadMembers(int id) throws SQLException {
		Connection connection = DALManager.getInstance().getOpenConnnection();
		
		ArrayList<Person> members = new ArrayList<Person>();
		ResultSet rs = connection.createStatement().executeQuery(
				"select p.id from categories c, persons p mappings m"+
				"where m.person = p.id and m.category = c.id");
		while(rs.next()){
			Person member = new PersonProxy(rs.getInt(1));
			members.add(member);
		}
		if(members.isEmpty())
			return;
		_objects.get(id).initMembers(members);
		
	}
}
