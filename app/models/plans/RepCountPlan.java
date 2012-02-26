package models.plans;

import models.RepType;
import play.db.jpa.Model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:28 AM
 */
@Entity
public class RepCountPlan extends Model {

    public int count;

    // should be between 0 and 1
    public Float percentMaxWeight;

    @ManyToOne
    public ExercisePlan exercisePlan;

    public String type = RepType.PRIMARY;

    public RepCountPlan(int count) {
        this.count = count;
    }

    public RepCountPlan(int count, String type) {
        this.count = count;
        this.type = type;
    }

    public RepCountPlan(int count, Float percentMaxWeight, String type) {
        this.count = count;
        this.percentMaxWeight = percentMaxWeight;
        this.type = type;
    }

}
