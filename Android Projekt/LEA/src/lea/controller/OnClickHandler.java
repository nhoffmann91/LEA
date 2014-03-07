package lea.controller;

import lea.activities.RankingActivity;
import lea.activities.RatingActivity;
import lea.activities.TeacherChoiceActivity;
import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.widget.Toast;

public class OnClickHandler {

	private static OnClickHandler onClickHandler = null;

	public OnClickHandler() {
	}

	public static OnClickHandler getInstance() {
		if (onClickHandler == null)
			onClickHandler = new OnClickHandler();
		return onClickHandler;
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
			// Show toast with error message
			Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
		}
//		
//		if(username.equals(TestData.getInstance().getUsername()) && password.equals(TestData.getInstance().getPassword())){
//			Intent ranking = new Intent(context.getApplicationContext(),
//				RankingActivity.class);
//			context.startActivity(ranking);
//		}
//		else{
//			Toast.makeText(context, "Username oder Passwort falsch!", Toast.LENGTH_LONG).show();
//		}
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
		Intent rating = new Intent(context.getApplicationContext(), RatingActivity.class);
		//rating.putExtra(name, value)
	}
}
