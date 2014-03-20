package kontaktmngr.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kontaktmngr.model.Category;

public class CategoryLoader {

	/**
	 * Loads all categories. Returns null, if there no category. The root-category is normally not a really category.
	 * @return
	 * @throws SQLException
	 */
	public Category loadAll() throws SQLException
	{
		DALManager dal = DALManager.getInstance();
		Connection connection = dal.getOpenConnnection();
		
		//Loads root
		ResultSet rs = connection.createStatement().executeQuery(
				"select id, title, description from categories where lft = 1;");
		Category root = null;
		if(rs.next()){
			root = new Category(rs.getInt(1), rs.getString(2));
			root.descriptionProperty().set(rs.getString(3));
			//Loads root's children.
			loadChildren(root, connection);
		}
		connection.close();
		return root;
	}
	
	public void loadChildren(Category category) throws SQLException
	{
		DALManager dal = DALManager.getInstance();
		Connection connection = dal.getOpenConnnection();
		loadChildren(category, connection);
		connection.close();
	}

	private void loadChildren(Category category, Connection connection) throws SQLException
	{
		ArrayList<Category> children = new ArrayList<Category>();
		ResultSet rs = connection.createStatement().executeQuery(
				"select c.id, c.title, c.description "
						+ "from categories f, categories c" + "where f.id = " + category.getId()
						+ "and c.lft > f.lft " + "and c.rgt < f.rgt"
						+ "and not exists(" + "select * " + "from categories d"
						+ "where c.lft > d.lft " + "and c.rgt < d.rgt"
						+ "and d.lft > f.lft " + "and d.rgt < f.rgt);");
		while(rs.next()){
			Category child = new Category(rs.getInt(1), rs.getString(2));
			child.descriptionProperty().set(rs.getString(3));
			loadChildren(child);
			children.add(child);
		}
		if(children.isEmpty())
			return;
		category.setChildren(children);
	}
	
}
