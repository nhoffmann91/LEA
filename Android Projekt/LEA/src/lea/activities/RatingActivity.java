package lea.activities;

import lea.controller.OnClickHandler;
import lea.helper.Constant;
import lea.helper.Helper;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends Activity {
	private Button btnCancel;
	private Button btnSubmit;
	private TextView question;
	private TextView header;
	private RatingBar rating;

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			if (arg0 == btnSubmit) {
				OnClickHandler.Instance().btnSubmitClick(rating.getRating(),
						(Activity) arg0.getContext());
			} else if (arg0 == btnCancel) {
				OnClickHandler.Instance().btnCancelClick(
						(Activity) arg0.getContext());
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating);

		this.retrieveIntentExtras(this.getIntent());
		this.setViewControls();
		this.addEvents();
		this.bindData();
	}

	private void retrieveIntentExtras(Intent intent) {
		try {
			this.question.setText(intent
					.getStringExtra(Constant.QuestionNameKey));
			this.header.setText("Bewertungsbogen für "
					+ intent.getStringExtra(Constant.TeacherNameKey)
					+ " in dem Fach "
					+ intent.getStringExtra(Constant.SubjectNameKey));
		} catch (Exception e) {

		}

	}

	private void bindData() {
		if (Helper.ratingCounter == 6) {
			this.btnSubmit.setText(Constant.SubmitButtoText);
		}
	}

	private void addEvents() {
		this.btnSubmit.setOnClickListener(this.onClickListener);
	}

	private void setViewControls() {
		this.btnCancel = (Button) this.findViewById(R.id.btnCancel);
		this.btnSubmit = (Button) this.findViewById(R.id.btnSubmit);
		this.question = (TextView) this.findViewById(R.id.txtViewQuestion);
		this.header = (TextView) this.findViewById(R.id.txtViewHeader);
		this.rating = (RatingBar) this.findViewById(R.id.ratingBarQuestion);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rating, menu);
		return true;
	}

}
