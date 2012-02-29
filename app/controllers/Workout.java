package controllers;

import models.User;
import models.executions.Exercise;
import models.executions.Session;
import play.Logger;
import play.mvc.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: brad
 * Date: 2/29/12
 * Time: 8:44 AM
 */
public class Workout extends Controller {

/*	public static void index() {
		render();
	}*/

	/**
	 * If the user is launching into a new workout session, find the first exercise
	 * and use that as the first exercise to display.
	 *
	 * @param sessionId
	 */
	public static void workoutBySession(Long sessionId) {

		Session session = Session.find("byId", sessionId).first();
		Exercise firstExercise;

		if (null != session && session.exercises.size() > 0) {
			firstExercise = session.exercises.get(0);
			workoutBySessionAndExercise(sessionId, firstExercise.id);
		} else {
			workoutBySessionAndExercise(sessionId, 0L);
		}
	}

	/**
	 * Display the current and upcoming exercises.
	 *
	 * @param sessionId
	 * @param exerciseId
	 */
	public static void workoutBySessionAndExercise(Long sessionId, Long exerciseId) {

		// TODO: this isn't the real user
		User user = (User) User.findAll().get(0);
		Session workoutSession = Session.find("byId", sessionId).first();
		Exercise exercise = Exercise.find("byId", exerciseId).first();

		Exercise nextExercise = null;

		int exerciseIndex = workoutSession.exercises.indexOf( exercise );

		if ( exerciseIndex < (workoutSession.exercises.size() - 1) )
		{
			nextExercise = workoutSession.exercises.get(exerciseIndex+1);
		}

		render(workoutSession, exercise, user, nextExercise);
	}


	public static void postExerciseResult(Long workoutSessionId, Long exerciseId, Long nextExerciseId, Float sharedRepCount, Float sharedRepWeight, String[] bandSet ) {
		Logger.info("Post received for the following parameters:");
		Logger.info("Session: %s, Exercise %s", workoutSessionId, exerciseId);
		Logger.info("I did %s reps of %s lbs, or used %s bands", sharedRepCount, sharedRepWeight, (bandSet != null) ? bandSet.length : "No");
		workoutBySessionAndExercise( workoutSessionId, nextExerciseId);
	}
}
