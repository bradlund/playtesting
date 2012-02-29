package models.executions;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:40 AM
 */

import models.plans.ExercisePlan;
import models.plans.SessionPlan;
import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Session extends Model {

	@ManyToOne
	public WorkoutDay workoutDay;

	@ManyToMany(cascade = CascadeType.ALL)
	public List<Exercise> exercises;

	public Boolean isOptional;

	public String name;

	public Session(String name, Boolean optional, List<Exercise> exercises) {
		this.name = name;
		isOptional = optional;
		this.exercises = exercises;
	}

	public static Session createFromTemplate(SessionPlan plan) {
		Session session = new Session(plan.name, plan.isOptional, new ArrayList<Exercise>());

		for (ExercisePlan exercisePlan : plan.exercisePlans) {
			session.exercises.add(Exercise.createFromTemplate(exercisePlan));
		}

		return session;
	}
}
