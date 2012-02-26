package models.executions;

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
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCount> standardRepCountPlans;
    public String notes;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCount> leftRepCountPlans;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCount> rightRepCountPlans;

    public Exercise(String name, Boolean leftRightSeparate) {
        this.name = name;
        this.leftRightSeparate = leftRightSeparate;
    }
}
