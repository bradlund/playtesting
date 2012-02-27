package models.executions;

import models.plans.SessionPlan;
import models.plans.WorkoutDayPlan;
import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:42 AM
 */
@Entity
public class WorkoutDay extends Model {

	@ManyToOne
	public MacroSession macroSession;

	@OneToMany(mappedBy="workoutDay", cascade= CascadeType.ALL)
    public List<Session> sessions;
    public Date date;
    public Boolean dietOkay;

	public static WorkoutDay createFromTemplate( WorkoutDayPlan plan, Date effectiveDate )
	{
		WorkoutDay day = new WorkoutDay();
		day.dietOkay = false;
		day.date = effectiveDate;
		day.sessions = new ArrayList<Session>();

		for (SessionPlan sessionPlan : plan.sessionPlans )
		{
			day.sessions.add( Session.createFromTemplate( sessionPlan));
		}

		return day;
	}
}
