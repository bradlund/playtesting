package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2/20/12
 * Time: 11:28 AM
 */
@Entity
public class RepCount extends Model {

    public int count;

    public Float dumbbellWeight;

    public List<Bands> bandsUsed;

    public RepType type = RepType.PRIMARY;

    public RepCount(int count) {
        this.count = count;
    }

    public RepCount(int count, RepType type) {
        this.count = count;
        this.type = type;
    }

    public RepCount(int count, Float dumbbellWeight, List<Bands> bandsUsed, RepType type) {
        this.count = count;
        this.dumbbellWeight = dumbbellWeight;
        this.bandsUsed = bandsUsed;
        this.type = type;
    }

}