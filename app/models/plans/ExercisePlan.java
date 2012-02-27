package models.plans;

import play.db.jpa.Model;

import javax.persistence.*;
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
	public String notes;

	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ExercisePlanToStandardRepCountPlan")
    public List<RepCountPlan> standardRepCountPlans;

	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ExercisePlanToLeftRepCountPlan")
	public List<RepCountPlan> leftRepCountPlans;
	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ExercisePlanToRightRepCountPlan")
	public List<RepCountPlan> rightRepCountPlans;

    public ExercisePlan(String name, Boolean leftRightSeparate) {
        this.name = name;
        this.leftRightSeparate = leftRightSeparate;
    }
}
