import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

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

        Exercise exercise1 = new Exercise("Push-Ups", false ).save();
        Exercise exercise2 = new Exercise("Front Wide Grip Pull-Ups", false ).save();
        Exercise exercise3 = new Exercise("Bicep Curls", true ).save();

        List<Exercise> exercises = Arrays.asList(exercise1, exercise2, exercise3);

        Session session1 = new Session("back day", false, exercises ).save();
        WorkoutDay workoutDay1 = new WorkoutDay();
        workoutDay1.sessions = Arrays.asList(session1);
        workoutDay1.date = new Date(2012, 2, 14);
        workoutDay1.save();

        WorkoutDay retrievedWorkoutDay = WorkoutDay.find( "byDate", new Date(2012,2,14)).first();

        assertNotNull( retrievedWorkoutDay);
        assertNotNull( retrievedWorkoutDay.sessions);
        assertEquals( 1, retrievedWorkoutDay.sessions.size());
        Session retrievedSession = retrievedWorkoutDay.sessions.get(0);
        assertNotNull( retrievedSession);
        assertNotNull( retrievedSession.exercises);
        assertEquals( 3, retrievedSession.exercises.size());
        assertEquals("Bicep Curls", retrievedSession.exercises.get(2).name);
    }

    @Test
    public void testRelations() {
        Exercise exercise1 = new Exercise("Push-Ups", false ).save();
        Exercise exercise2 = new Exercise("Front Wide Grip Pull-Ups", false ).save();
        Exercise exercise3 = new Exercise("Bicep Curls", true ).save();

        List<Exercise> exercises = Arrays.asList(exercise1, exercise2, exercise3);

        Session session1 = new Session("back day", false, exercises ).save();
        WorkoutDay workoutDay1 = new WorkoutDay();
        workoutDay1.sessions = Arrays.asList(session1);
        workoutDay1.date = new Date(2012, 2, 14);
        workoutDay1.save();

        WorkoutDay retrievedWorkoutDay = WorkoutDay.find( "byDate", new Date(2012,2,14)).first();

        // delete the workout day
        retrievedWorkoutDay.delete();

        // ensure that all the related exercises and sessions have been deleted
        assertEquals( 0, Exercise.count());
        assertEquals( 0, Session.count());
    }

}
