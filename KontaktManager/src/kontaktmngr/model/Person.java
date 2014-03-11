package kontaktmngr.model;

import java.util.ArrayList;
import java.util.List;

public class Person extends Entity
{
	private final List<Adress> _adresses = new ArrayList<>();
	private final List<Phone> _phones = new ArrayList<>();
	private final List<Identification> _identifications = new ArrayList<>();
	private final List<Person> _relationships = new ArrayList<>();
	//List Category
	//Person fields
	
	public Person(int id)
	{
		super(id);
		// TODO Auto-generated constructor stub
	}
}
