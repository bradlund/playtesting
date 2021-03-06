package models.executions;

import models.RepType;
import play.db.jpa.Model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:28 AM
 */
@Entity
public class RepCount extends Model {

	public int count;

	@ElementCollection
	public List<String> bandsUsed;

	public String type = RepType.PRIMARY;

	public RepCount(int count) {
		this.count = count;
	}

	public RepCount(int count, String type) {
		this.count = count;
		this.type = type;
	}

	public RepCount(int count, List<String> bandsUsed, String type) {
		this.count = count;
		this.bandsUsed = bandsUsed;
		this.type = type;
	}
}
