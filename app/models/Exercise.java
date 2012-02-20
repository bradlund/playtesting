package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:25 AM
 */
@Entity
public class Exercise extends Model {

    public String name;
    public Boolean leftRightSeparate;
    public List<RepCount> standardRepCounts;
    public String notes;
    public List<RepCount> leftRepCounts;
    public List<RepCount> rightRepCounts;
}
