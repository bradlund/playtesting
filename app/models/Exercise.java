package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:25 AM
 */
@Entity
public class Exercise extends Model {

    @ManyToOne
    public Session session;

    public String name;
    public Boolean leftRightSeparate;
    @OneToMany(mappedBy="exercise", cascade= CascadeType.ALL)
    public List<RepCount> standardRepCounts;
    public String notes;
    @OneToMany(mappedBy="exercise", cascade= CascadeType.ALL)
    public List<RepCount> leftRepCounts;
    @OneToMany(mappedBy="exercise", cascade= CascadeType.ALL)
    public List<RepCount> rightRepCounts;

    public Exercise(String name, Boolean leftRightSeparate) {
        this.name = name;
        this.leftRightSeparate = leftRightSeparate;
    }
}
