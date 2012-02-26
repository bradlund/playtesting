package models.plans;

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
public class ExercisePlan extends Model {

    @ManyToOne
    public SessionPlan sessionPlan;

    public String name;
    public Boolean leftRightSeparate;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCountPlan> standardRepCountPlans;
    public String notes;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCountPlan> leftRepCountPlans;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCountPlan> rightRepCountPlans;

    public ExercisePlan(String name, Boolean leftRightSeparate) {
        this.name = name;
        this.leftRightSeparate = leftRightSeparate;
    }
}
