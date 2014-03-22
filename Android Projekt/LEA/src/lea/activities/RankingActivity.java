package lea.activities;

import lea.controller.OnClickHandler;
import lea.controller.OnLoadHandler;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;

public class RankingActivity extends Activity {
	private Button btnRateOtherTeacher;
	private TableLayout tblTeacherOverview;

	private OnClickListener onClickHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == btnRateOtherTeacher)
				OnClickHandler.getInstance().btnRateOtherTeacherClick(
						(Activity) v.getContext());
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);

		this.setViewControls();
		this.addEvents();
		//this.loadTeacherOverview();
	}

	private void loadTeacherOverview() {
		this.tblTeacherOverview.addTouchables(OnLoadHandler.getInstance()
				.getTeacherOverview(this));
	}

	private void addEvents() {
		btnRateOtherTeacher.setOnClickListener(this.onClickHandler);
	}

	private void setViewControls() {
		btnRateOtherTeacher = (Button) findViewById(R.id.btnRateOtherTeacher);
		tblTeacherOverview = (TableLayout) findViewById(R.id.tblTeacherOverview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

}
