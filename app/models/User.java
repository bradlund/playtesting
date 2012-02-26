package models;

import org.hibernate.annotations.CollectionOfElements;
import play.db.jpa.Model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:32 AM
 */
@Entity
public class User extends Model {

    public String username;

    @ElementCollection
    public List<String> bandset;
}
