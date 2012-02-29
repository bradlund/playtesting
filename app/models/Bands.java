package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 12:10 PM
 */
@Entity
public class Bands extends Model {
	public static final String RED = "RED";
	public static final String GREEN = "GREEN";
	public static final String BLUE = "BLUE";
	public static final String BLACK = "BLACK";
	public static final String YELLOW = "YELLOW";
	public static final String GRAY = "GRAY";
	public static final String ORANGE = "ORANGE";
	public static final String PINK = "PINK";
	public static final String PURPLE = "PURPLE";
	public static final String WHITE = "WHITE";
}
