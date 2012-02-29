package models.executions;

import models.User;
import models.plans.MacroSessionPlan;
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
 * A macro session is a full multi day routine.  As an example, the full 90 day original session.
 * <p/>
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:38 AM
 */
@Entity
public class MacroSession extends Model {

	@OneToMany(mappedBy = "macroSession", cascade = CascadeType.ALL)
	public List<WorkoutDay> workoutDays;
	public String name;
	public Date startDate;
	public String authorName;

	@ManyToOne
	public User authorUser;

	@ManyToOne
	public User exercisingUser;

	public static MacroSession createFromTemplate(MacroSessionPlan plan, User exercisingUser, Date startDate) {
		MacroSession session = new MacroSession();
		session.exercisingUser = exercisingUser;
		session.startDate = startDate;
		session.name = plan.name;
		session.authorName = plan.authorName;
		session.authorUser = plan.authorUser;
		session.workoutDays = new ArrayList<WorkoutDay>();

		for (WorkoutDayPlan dayPlan : plan.workoutDayPlans) {
			startDate.setDate(startDate.getDate() + 1);
			WorkoutDay createdDay = WorkoutDay.createFromTemplate(dayPlan, (Date) startDate.clone());
			session.workoutDays.add(createdDay);
		}

		return session;
	}

}
