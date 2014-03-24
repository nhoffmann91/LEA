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
import lea.helper.ServiceData;
import android.app.Activity;
import android.content.Intent;
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
<<<<<<< HEAD
			HttpClient httpClient = new DefaultHttpClient();
			HttpContext localContext = new BasicHttpContext();
			HttpGet httpGet = new HttpGet("http://192.168.178.35:8080/LeaWebService/service/getpupilid/nick?hoffmann?87654321");
			String text = null;

			HttpResponse response = httpClient.execute(httpGet, localContext);

			HttpEntity entity = response.getEntity();

			Gson gson = new Gson();
			int id = gson.fromJson(entity.toString(), int.class);

			// Create new intent
			Intent ranking = new Intent(context.getApplicationContext(), RankingActivity.class);
=======
			String[] login = username.split(".");
			ServiceData.Instance().setPupilId(
					ServiceProvider.Instance().getPupilIdFromService(login[1],
							login[0], password));

			Intent ranking = new Intent(context.getApplicationContext(),
					RankingActivity.class);
>>>>>>> 70eb32402cce91d448454cc518dd5d98b6f0fd20

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

	public void btnSubmitClick(Activity context) {
		Intent rating = new Intent(context.getApplicationContext(),
				RatingActivity.class);
		
		context.startActivity(rating);
	}
}
