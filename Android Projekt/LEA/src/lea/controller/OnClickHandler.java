package lea.controller;

import java.util.ArrayList;

import lea.activities.RankingActivity;
import lea.activities.RatingActivity;
import lea.activities.TeacherChoiceActivity;
import lea.helper.Constant;
import lea.helper.Helper;
import lea.helper.ServiceData;
import lea.helper.ServiceObject;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract.Constants;
import android.widget.Toast;

public class OnClickHandler {

	private static OnClickHandler onClickHandler = null;

	public OnClickHandler() {
	}

	public static OnClickHandler Instance() {
		if (onClickHandler == null)
			onClickHandler = new OnClickHandler();
		return onClickHandler;
	}

	// Method to handle the login button click event
	public void btnLoginClick(String username, String password, Activity context) {
		// Split usernname into lastname and firstname
		try {
			String[] login = username.split(".");
			Helper.pupil = new ServiceObject(ServiceProvider.Instance()
					.getPupilIdFromService(login[1], login[0], password));

			Intent ranking = new Intent(context.getApplicationContext(),
					RankingActivity.class);

			context.startActivity(ranking);

		} catch (Exception e) {
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
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

	public void btnRateClick(Activity context) {
		Helper.ratingCounter = 1;
		Intent rating = new Intent(context.getApplicationContext(),
				RatingActivity.class);
		this.putRatingExtras(rating);

		context.startActivity(rating);
	}

	private void putRatingExtras(Intent intent) {
		intent.putExtra(Constant.QuestionNameKey,
				Helper.questions.get(Helper.ratingCounter - 1).getName());
		intent.putExtra(Constant.TeacherNameKey,
				Helper.selectedTeacher.getName());
		intent.putExtra(Constant.SubjectNameKey,
				Helper.selectedSubject.getName());
	}

	public void btnSubmitClick(float rating, Activity context) {
		if (Helper.ratingCounter < 6) {
			if (Helper.results == null) {
				Helper.results = new ArrayList<ServiceData>();
			}

			Helper.results.add(new ServiceData(Helper.pupil.getId(),
					Helper.selectedTeacher.getId(), Helper.selectedSubject
							.getId(), Helper.questions.get(
							Helper.ratingCounter - 1).getId(), rating));

			Helper.ratingCounter++;

			Intent intent = new Intent(context.getApplicationContext(),
					RatingActivity.class);
			this.putRatingExtras(intent);

			context.startActivity(intent);
		} else {
			if (ServiceProvider.Instance().updateService(Helper.results)) {
				Intent ranking = new Intent(context, RankingActivity.class);
				context.startActivity(ranking);
			} else {
				Intent ranking = new Intent(context, RankingActivity.class);
				ranking.putExtra(Constant.ErrorKey,
						"Etwas ist schief gelaufen!");
				context.startActivity(ranking);
			}
		}
	}

	public void btnCancelClick(Activity context) {
		Intent ranking = new Intent(context, RankingActivity.class);
		context.startActivity(ranking);
	}
}
