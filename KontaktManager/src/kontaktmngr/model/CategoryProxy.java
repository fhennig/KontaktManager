package kontaktmngr.model;

import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.StringProperty;
import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.Visitor;

public class CategoryProxy implements Category{

	private final int _id;
	private Category _originalCategory;
	private boolean _childrenInitialized;
	private boolean _membersInitialized;
	
	public CategoryProxy(int id){
		_id = id;
	}
	
	private Category getOriginalCategory(){
		if (_originalCategory == null)
			_originalCategory = DALManager.getInstance().getCategoryLoader().get(_id);
		
		return _originalCategory;
	}
	
	private void validateChildrenAreInitialized(){
		if (_childrenInitialized)
			return;
		
		if (_originalCategory.childrenProperty() == null) //check for any list property if it is null
		{
			DALManager.getInstance().getCategoryLoader().loadChildren(_originalCategory.getId());
		}
		_childrenInitialized = true;
	}
	
	private void validateMembersAreInitialized(){
		if (_membersInitialized)
			return;
		
		if (_originalCategory.childrenProperty() == null) //check for any list property if it is null
		{
			DALManager.getInstance().getCategoryLoader().loadMembers(_originalCategory.getId());
		}
		_membersInitialized = true;
	}
	
	@Override
	public int getId() {
		return _id;
	}

	@Override
	public StringProperty descriptionProperty() {
		return getOriginalCategory().descriptionProperty();
	}

	@Override
	public StringProperty titleProperty() {
		return getOriginalCategory().titleProperty();
	}

	@Override
	public ReadOnlyListProperty<Category> childrenProperty() {
		validateChildrenAreInitialized();
		return getOriginalCategory().childrenProperty();
	}

	@Override
	public ReadOnlyListProperty<Person> membersProperty() {
		validateMembersAreInitialized();
		return getOriginalCategory().membersProperty();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

}
