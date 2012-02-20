package models;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:40 AM
 */

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Session extends Model {

    @OneToMany
    public List<Exercise> exercises;

    public Boolean isOptional;

    public String name;

    public Session(String name, Boolean optional, List<Exercise> exercises) {
        this.name = name;
        isOptional = optional;
        this.exercises = exercises;
    }
}
