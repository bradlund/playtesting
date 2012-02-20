package models;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:40 AM
 */

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Session extends Model {

    public List<Exercise> exercises;

    public Boolean isOptional;
}
