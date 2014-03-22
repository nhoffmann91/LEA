package lea.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.google.gson.Gson;

import lea.activities.RankingActivity;
import lea.activities.RatingActivity;
import lea.activities.TeacherChoiceActivity;
import android.app.Activity;
import android.content.Intent;
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
		// Split usernname into lastname and firstname
		String[] login = username.split(".");

		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpContext localContext = new BasicHttpContext();
			HttpGet httpGet = new HttpGet(
					"http://localhost:8080/LeaWebService/service/getpupilid/nick?hoffmann?87654321");
			String text = null;

			HttpResponse response = httpClient.execute(httpGet, localContext);

			HttpEntity entity = response.getEntity();

			Gson gson = new Gson();
			int id = gson.fromJson(entity.toString(), int.class);

			// Create new intent
			Intent ranking = new Intent(context.getApplicationContext(),
					RankingActivity.class);

			// Start intent and change to ranking activity
			context.startActivity(ranking);
		} catch (Exception e) {
			// Show toast with error message
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

	public void btnSubmitClick(String teacher, String subject, Activity context) {
		Intent rating = new Intent(context.getApplicationContext(),
				RatingActivity.class);
		// rating.putExtra(name, value)
	}
}
