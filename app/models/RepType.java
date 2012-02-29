package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 12:24 PM
 */
@Entity
public class RepType extends Model {
	public static final String PRIMARY = "PRIMARY";
	public static final String ASSISTED = "ASSISTED";
	public static final String DROP_SET = "DROP_SET";
}
