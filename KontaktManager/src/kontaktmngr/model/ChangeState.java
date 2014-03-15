package kontaktmngr.model;

/**
 * The ChangeState is used for each Entity. It indicates, if the Entity changed.
 * The State is used to determine if the Object contains Changes that need to be 
 * written to the Database.
 */
public enum ChangeState
{
	UNCHANGED,
	CHANGED,
	NEW,
	DELETED
}
