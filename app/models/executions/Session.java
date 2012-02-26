package models.executions;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:40 AM
 */

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Session extends Model {

    @ManyToOne
    public WorkoutDay workoutDay;

    @OneToMany(mappedBy="session", cascade= CascadeType.ALL)
    public List<Exercise> exercisePlans;

    public Boolean isOptional;

    public String name;

    public Session(String name, Boolean optional, List<Exercise> exercisePlans) {
        this.name = name;
        isOptional = optional;
        this.exercisePlans = exercisePlans;
    }
}
