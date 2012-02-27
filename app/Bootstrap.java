import models.User;
import models.executions.Exercise;
import models.executions.MacroSession;
import models.plans.MacroSessionPlan;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

import java.util.Date;

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
        if ( User.count() == 0)
        {
            System.out.println("Loading data from UserAndPlan.yml...");
			Fixtures.deleteAllModels();
            Fixtures.loadModels( "UserAndPlan.yml" );

			User firstUser = User.find("byUsername", "brad").first();
			MacroSessionPlan firstPlan = MacroSessionPlan.find("byName", "P90X Original").first();

			Date startDate = new Date();
			startDate.setDate( startDate.getDate() - 1);
			MacroSession firstInstance = MacroSession.createFromTemplate( firstPlan, firstUser, startDate);
			firstInstance.save();

            System.out.println("System now has " + User.count() + " users");
			System.out.println("System now has " + Exercise.count() + " instantiated exercises");
        }
    }
}
