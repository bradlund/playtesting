package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:42 AM
 */
@Entity
public class WorkoutDay extends Model {

    @OneToMany(mappedBy="workoutDay", cascade= CascadeType.ALL)
    public List<Session> sessions;
    public Date date;
    public Boolean dietOkay;
}
