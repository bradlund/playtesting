import models.User;
import models.plans.ExercisePlan;
import models.plans.MacroSessionPlan;
import models.plans.SessionPlan;
import models.plans.WorkoutDayPlan;
import org.junit.*;
import java.util.*;
import play.test.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void createAndRetrieveWorkoutSession() {

        ExercisePlan exercisePlan1 = new ExercisePlan("Push-Ups", false ).save();
        ExercisePlan exercisePlan2 = new ExercisePlan("Front Wide Grip Pull-Ups", false ).save();
        ExercisePlan exercisePlan3 = new ExercisePlan("Bicep Curls", true ).save();

        List<ExercisePlan> exercisePlans = Arrays.asList(exercisePlan1, exercisePlan2, exercisePlan3);

        SessionPlan sessionPlan1 = new SessionPlan("back day", false, exercisePlans).save();
        WorkoutDayPlan workoutDayPlan1 = new WorkoutDayPlan();
        workoutDayPlan1.sessionPlans = Arrays.asList(sessionPlan1);
        //workoutDayPlan1.date = new Date(2012, 2, 14);
        workoutDayPlan1.save();

        MacroSessionPlan macroSessionPlan1 = new MacroSessionPlan();
        macroSessionPlan1.authorName = "J-Dawg";
        macroSessionPlan1.workoutDayPlans = Arrays.asList(workoutDayPlan1);
        macroSessionPlan1.name = "A really bad workout";
        macroSessionPlan1.save();

        MacroSessionPlan retrievedMacroSessionPlan = MacroSessionPlan.find( "byName", "A really bad workout").first();

        assertNotNull( retrievedMacroSessionPlan);
        assertNotNull( retrievedMacroSessionPlan.workoutDayPlans);
        WorkoutDayPlan retrievedWorkoutDayPlan = retrievedMacroSessionPlan.workoutDayPlans.get(0);
        assertNotNull(retrievedWorkoutDayPlan);
        assertNotNull( retrievedWorkoutDayPlan.sessionPlans);
        assertEquals( 1, retrievedWorkoutDayPlan.sessionPlans.size());
        SessionPlan retrievedSessionPlan = retrievedWorkoutDayPlan.sessionPlans.get(0);
        assertNotNull(retrievedSessionPlan);
        assertNotNull( retrievedSessionPlan.exercisePlans);
        assertEquals( 3, retrievedSessionPlan.exercisePlans.size());
        assertEquals("Bicep Curls", retrievedSessionPlan.exercisePlans.get(2).name);
    }

    @Test
    public void testRelations() {
        ExercisePlan exercisePlan1 = new ExercisePlan("Push-Ups", false ).save();
        ExercisePlan exercisePlan2 = new ExercisePlan("Front Wide Grip Pull-Ups", false ).save();
        ExercisePlan exercisePlan3 = new ExercisePlan("Bicep Curls", true ).save();

        List<ExercisePlan> exercisePlans = Arrays.asList(exercisePlan1, exercisePlan2, exercisePlan3);

        SessionPlan sessionPlan1 = new SessionPlan("back day", false, exercisePlans).save();
        WorkoutDayPlan workoutDayPlan1 = new WorkoutDayPlan();
        workoutDayPlan1.sessionPlans = Arrays.asList(sessionPlan1);
        workoutDayPlan1.save();

        MacroSessionPlan macroSessionPlan1 = new MacroSessionPlan();
        macroSessionPlan1.authorName = "J-Dawg";
        macroSessionPlan1.workoutDayPlans = Arrays.asList(workoutDayPlan1);
        macroSessionPlan1.name = "A really bad workout";
        macroSessionPlan1.save();

        MacroSessionPlan retrievedMacroSessionPlan = MacroSessionPlan.find( "byName", "A really bad workout").first();

        // delete the workout day
        retrievedMacroSessionPlan.delete();

        // ensure that all the related exercisePlans and sessions have been deleted
		assertEquals( 0, MacroSessionPlan.count());
		assertEquals( 0, WorkoutDayPlan.count());
		assertEquals( 0, SessionPlan.count());
        assertEquals( 0, ExercisePlan.count());
        assertEquals( 0, SessionPlan.count());
    }


    @Test
    public void testYamlData() {
		Fixtures.deleteAllModels();
        Fixtures.loadModels( "UserAndPlan.yml");

		assertEquals( 10, ExercisePlan.count() );
        assertEquals( 4, SessionPlan.count());
		assertEquals( 4, WorkoutDayPlan.count());
		assertEquals( 1, MacroSessionPlan.count());
        assertEquals( 1, User.count());

		ExercisePlan jumpingPlan = ExercisePlan.find( "byName", "Jumping").first();
		assertNotNull( jumpingPlan);
		assertNotNull( jumpingPlan.standardRepCountPlans);
		assertEquals( 1, jumpingPlan.standardRepCountPlans.size());

		MacroSessionPlan retrievedMacroSessionPlan = MacroSessionPlan.find( "byName", "P90X Original").first();
		assertNotNull( retrievedMacroSessionPlan);
		assertNotNull( retrievedMacroSessionPlan.workoutDayPlans );
		assertEquals( 4, retrievedMacroSessionPlan.workoutDayPlans.size());
	}
}
