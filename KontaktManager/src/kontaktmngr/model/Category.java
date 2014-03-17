package kontaktmngr.model;

import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Category extends DefaultEntity
{
	private ListProperty<Category> _children;
	
	private StringProperty _title;
	private StringProperty _description;

	public Category(int id, String title)
	{
		super(id);
		_title = new SimpleStringProperty(this, "Title", title);
	}

	public void setChildren(List<Category> categories)
	{
		_children = new SimpleListProperty<>(this, "Children", new ObservableListWrapper<>(categories));;
	}
	
}
