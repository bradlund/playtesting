import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Created with IntelliJ IDEA.
 * User: brad
 * Date: 2/26/12
 * Time: 10:07 AM
 */
@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {

        System.out.println("Bootstrap invoked");

        // Check if database is empty - if it is, load data from yaml
        if (User.count() == 0)
        {
            System.out.println("Loading data from UserAndPlan.yml...");
            Fixtures.loadModels( "UserAndPlan.yml" );
            System.out.println("System now has " + User.count() + " users");
        }
    }
}
