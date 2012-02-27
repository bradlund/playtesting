package models.plans;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:40 AM
 */

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class SessionPlan extends Model {

    @ManyToMany( cascade = CascadeType.ALL)
	//@JoinTable(name = "SessionPlanToExercisePlanTable")
    public List<ExercisePlan> exercisePlans;

    public Boolean isOptional;

    public String name;

    public SessionPlan(String name, Boolean optional, List<ExercisePlan> exercisePlans) {
        this.name = name;
        isOptional = optional;
        this.exercisePlans = exercisePlans;
    }
}
