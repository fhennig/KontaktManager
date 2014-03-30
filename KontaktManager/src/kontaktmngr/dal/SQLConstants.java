package kontaktmngr.dal;

public final class SQLConstants {

	// Tabellennamen
	public static final String PERSONS_TABLE = "persons";
	public static final String CATEGORIES_TABLE = "categories";
	public static final String MAPPINGS_TABLE = "mappings";
	public static final String ADDRESSES_TABLE = "adresses";
	public static final String PHONES_TABLE = "phones";
	public static final String IDENTIFICATION_TABLE = "identifications";
	public static final String RELATIONSHIP_TABLE = "relationships";
	public static final String PICTURE_TABLE = "pictures";

	// Allgemeine SELECT Anfragen
	public static final String select_all_by_id(String table){
		return "select * from " + table + " where id = ? ;";
	}
	public static final String select_all_where_ispersonid_by_id(String table){
		return "select * from table where person = ? ;";
	}
	/**
	 * 
	 * @param columns Comma separated, e.g. "forename, surname, nickname"
	 * @param table
	 * @return
	 */
	public static final String select_by_ID(String columns, String table){
		return "select " + columns + " from " + table + " where id = ? ;";
	}

	// INSERT INTO Anfragen
	public static final String INSERT_PERSON_BY_VALUES = "insert into "
			+ PERSONS_TABLE
			+ " (gender, title, forename, surname, nickname, birthday, description) values (?, ?, ?, ?, ?, ?, ?) returning id;";

	// UPDATE Anfragen
	public static final String UPDATE_PERSON_BY_VALUES_ID = "update "
			+ PERSONS_TABLE
			+ " set gender = ?, title = ?, forename = ?, surname = ?, nickname = ?, birthday = ?, description = ? where id = ? ;";

	// Persons
	public static final String SELECT_ALL_FROM_PERSONS_ORDERBY_FORENAME = "select * from " + PERSONS_TABLE + " order by forename;";
	
	// Relationships
	public static final String SELECT_RELATIONSHIPIDID_OF_PERSON_BY_ID = "select r.id from " + PERSONS_TABLE + " p, " + RELATIONSHIP_TABLE + " r where (r.person1 = p.id or r.person2 = p.id) and p.id = ? ;";
	
	// Categories
	public static final String SELECT_ROOT_FROM_CATEGORIES_BY_COLUMNS = "select ? from "
			+ CATEGORIES_TABLE + " where lft = 1;";
	public static final String SELECT_CHILDREN_FROM_CATEGORIES_BY_ID = "select c.id, c.title, c.description "
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
	public static final String SELECT_CATEGORYID_OF_PERSON_BY_ID = "select p.id "
			+ "from " + PERSONS_TABLE + " p, " + CATEGORIES_TABLE + " c, " + MAPPINGS_TABLE + " m "
			+ "where p.id = m.person and c.id = m.category and c.id = ? ;";
}
