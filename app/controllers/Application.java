package controllers;

import models.executions.MacroSession;
import models.executions.WorkoutDay;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {

		User user = (User) User.findAll().get(0);
		MacroSession macroSession = MacroSession.find("byExercisingUser", user ).first();

		long test = WorkoutDay.count();
		List<WorkoutDay> previousThreeWorkoutDays = WorkoutDay.findAll(); //WorkoutDay.find("byMacroSession", macroSession).fetch();
		WorkoutDay todayWorkouts = (WorkoutDay) WorkoutDay.findAll().get(0); //WorkoutDay.find("byMacroSession", macroSession).first();

        render( user, macroSession, previousThreeWorkoutDays, todayWorkouts );
    }

}