package models.executions;

import models.plans.ExercisePlan;
import play.db.jpa.Model;

import javax.persistence.*;
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
	public String notes;

	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ExerciseToStandardRepCount")
	public List<RepCount> standardRepCount;

	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ExerciseToLeftRepCount")
	public List<RepCount> leftRepCount;
	@OneToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ExerciseToLeftRepCount")
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
