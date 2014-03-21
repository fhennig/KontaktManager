package kontaktmngr.model;

import java.util.List;

import com.sun.javafx.collections.ObservableListWrapper;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryDefault extends DefaultEntity implements Category{

	private StringProperty _title;
	private ListProperty<Category> children;
	private ListProperty<Person> members;
	
	public CategoryDefault(int id, String title, String description) {
		super(id, description);
		_title = new SimpleStringProperty(this, "Title", title);
	}
	
	public void initChildren(List<Category> children){
		children = new SimpleListProperty<Category>(this, "Children", new ObservableListWrapper<>(children));
	}
	
	public void initMembers(List<Person> members){
		members = new SimpleListProperty<Person>(this, "Members", new ObservableListWrapper<>(members));
	}

	@Override
	public StringProperty titleProperty() {
		return _title;
	}

	@Override
	public ReadOnlyListProperty<Category> childrenProperty() {
		return children;
	}

	@Override
	public ReadOnlyListProperty<Person> membersProperty() {
		return members;
	}

	
	
}
