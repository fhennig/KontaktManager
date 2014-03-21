package kontaktmngr.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PictureDefault extends DefaultEntity implements Picture{

	private StringProperty _filenameProperty;
	
	public PictureDefault(int id, String filename) {
		super(id);
		_filenameProperty = new SimpleStringProperty(this, "Filename", filename);
	}

	@Override
	public StringProperty filenameProperty() {
		return _filenameProperty;
	}

}
