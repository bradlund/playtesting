package controllers;

import models.User;
import models.executions.Exercise;
import models.executions.Session;
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
		}
		else
		{
			workoutBySessionAndExercise( sessionId, 0L);
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
		Session session = Session.find("byId", sessionId).first();
		Exercise exercise = Exercise.find("byId", exerciseId).first();
		render(session, exercise, user);
	}
}
