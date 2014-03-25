package kontaktmngr.dal;

public final class SQLConstants {

	// Tabellennamen
	public static final String PERSONS_TABLE = "persons";
	public static final String CATEGORIES_TABLE = "categories";
	public static final String MAPPINGS_TABLE = "mappings";
	public static final String ADDRESSES_TABLE = "adresses";
	public static final String PHONES_TABLE = "phones";
	public static final String IDENTIFICATION_TABLE = "identifications";

	// Allgemeine SELECT Anfragen
	public static final String SELECT_ALL_BY_TABLE_ID = "select * from ? where id = ? ;";
	public static final String SELECT_BY_COLUMNS_TABLE_ID = "select ? from ? where id = ? ;";
	public static final String SELECT_ALL_WHERE_ISPERSONID_BY_TABLE_ID = "select * from ? where person = ? ;";
	
	// INSERT INTO Anfragen
	public static final String INSERT_PERSON_BY_VALUES = "insert into " + PERSONS_TABLE + " (gender, title, forename, surname, nickname, birthday, description) values (?, ?, ?, ?, ?, ?, ?) returning id;";
	
	// UPDATE Anfragen
	public static final String UPDATE_PERSON_BY_VALUES_ID = "update " + PERSONS_TABLE + " set gender = ?, title = ?, forename = ?, surname = ?, nickname = ?, birthday = ?, description = ? where id = ? ;";
	
	// Categories
	public static final String SELECT_ROOT_FROM_CATEGORIES_BY_COLUMNS = "select ? from "
			+ CATEGORIES_TABLE + " where lft = 1;";
	public static final String SELECT_CHILDREN_FROM_CATEGORIES_BY_cCOLUMNS_ID = "select ? "
			+ "from "
			+ CATEGORIES_TABLE
			+ " f, "
			+ CATEGORIES_TABLE
			+ " c"
			+ "where f.id = ?"
			+ "and c.lft > f.lft "
			+ "and c.rgt < f.rgt"
			+ "and not exists("
			+ "select * "
			+ "from "
			+ CATEGORIES_TABLE
			+ " d"
			+ "where c.lft > d.lft "
			+ "and c.rgt < d.rgt"
			+ "and d.lft > f.lft " + "and d.rgt < f.rgt);";
	public static final String SELECT_PERSONID_OF_CATEGORY_BY_ID = "select p.id from "
			+ CATEGORIES_TABLE
			+ " c, "
			+ PERSONS_TABLE
			+ " p, "
			+ MAPPINGS_TABLE
			+ " m"
			+ "where m.person = p.id and m.category = c.id and c.id = ? ;";
}
