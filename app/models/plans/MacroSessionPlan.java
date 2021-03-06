package models.plans;

import models.User;
import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
public class MacroSessionPlan extends Model {

	@OneToMany(mappedBy = "macroSessionPlan", cascade = CascadeType.ALL)
	public List<WorkoutDayPlan> workoutDayPlans;
	public String name;
	public Date startDate;
	public String authorName;
	public User authorUser;

}
