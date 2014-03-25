package kontaktmngr.model;

import javafx.beans.property.StringProperty;
import kontaktmngr.dal.DALManager;
import kontaktmngr.dal.Visitor;

public class PictureProxy implements Picture{

	private final int _pictureId;
	private Picture _originalPicture;
	
	public PictureProxy(int pictureId){
		_pictureId = pictureId;
	}

	private Picture getOriginalPerson()
	{
		if (_originalPicture == null)
			_originalPicture = DALManager.getInstance().getPictureLoader().getPicture(_pictureId);
		
		return _originalPicture;
	}
	
	@Override
	public int getId() {
		return _pictureId;
	}

	@Override
	public StringProperty descriptionProperty() {
		return getOriginalPerson().descriptionProperty();
	}

	@Override
	public StringProperty filenameProperty() {
		return getOriginalPerson().filenameProperty();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}
