package models.executions;

import models.plans.ExercisePlan;
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
    public List<RepCount> standardRepCount;
    public String notes;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCount> leftRepCount;
    @OneToMany(mappedBy="exercisePlan", cascade= CascadeType.ALL)
    public List<RepCount> rightRepCount;

	public ExercisePlan plan;

    public Exercise(String name, Boolean leftRightSeparate) {
        this.name = name;
        this.leftRightSeparate = leftRightSeparate;
    }

	public static Exercise createFromTemplate( ExercisePlan plan )
	{
		Exercise exercise = new Exercise( plan.name, plan.leftRightSeparate );
		exercise.plan = plan;

		return exercise;
	}
}
