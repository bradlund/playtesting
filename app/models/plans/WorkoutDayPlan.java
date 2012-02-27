package models.plans;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:42 AM
 */
@Entity
public class WorkoutDayPlan extends Model {

    @ManyToOne
    public MacroSessionPlan macroSessionPlan;

    //@OneToMany(mappedBy="workoutDayPlan", cascade= CascadeType.ALL)
	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "WorkoutDayPlanToSessionPlanTable")
	public List<SessionPlan> sessionPlans;
}
