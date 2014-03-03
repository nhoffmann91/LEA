package lea.controller;

import lea.activities.LoginActivity;
import lea.activities.RankingActivity;
import lea.activities.TeacherChoiceActivity;
import lea.helper.Constants;
import lea.helper.SQLHelper;
import android.app.Activity;
import android.content.Intent;

public class EventHandler {

	private static EventHandler eventHandler = null;

	public EventHandler() {
	}

	public static EventHandler getInstance() {
		if (eventHandler == null)
			eventHandler = new EventHandler();
		return eventHandler;
	}

	// Method to handle the login button click event
	public void btnLoginClick(String username, String password, Activity context) {
		try {
			// Set the pupil id
			SQLHelper.getInstance().setPupilIdIfNotExists(username, password);
			// Create new intent
			Intent ranking = new Intent(context.getApplicationContext(),
					RankingActivity.class);

			// Start intent and change to ranking activity
			context.startActivity(ranking);
		} catch (Exception e) {
			Intent login = new Intent(context.getApplicationContext(),
					LoginActivity.class);

			// Put data into the intent
			login.putExtra(Constants.ErrorKey, e.getLocalizedMessage());

			// Start intent and change to login activity
			context.startActivity(login);
		}
	}

	// Method to handle the rate other teacher button click event
	public void btnRateOtherTeacherClick(Activity context) {
		// Create new intent
		Intent otherTeacher = new Intent(context.getApplicationContext(),
				TeacherChoiceActivity.class);

		// Start intent and change to teacher choice activity
		context.startActivity(otherTeacher);
	}

	public void btnSubmitClick(String teacher, String subject, Activity context) {
		
	}

	public void spnTeacherItemChange() {
		// TODO Auto-generated method stub
		
	}

	public void spnSubjectItemChange() {
		// TODO Auto-generated method stub
		
	}
}
