package lea.activities;

import lea.controller.OnClickHandler;
import lea.controller.OnSelectHandler;
import lea.helper.Helper;
import lea.helper.ServiceObject;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class TeacherChoiceActivity extends Activity {
	private Spinner spnTeacher;
	private Spinner spnSubject;
	private Button btnRate;
	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == btnRate)
				OnClickHandler.Instance().btnRateClick(
						(Activity) v.getContext());
		}
	};
	private OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			if (arg1 == spnTeacher) {
				spnSubject.setAdapter(OnSelectHandler.Instance()
						.getSubjectsByTeacher(
								(ServiceObject) spnTeacher.getSelectedItem(),
								(Activity) arg1.getContext()));
			} else if (arg1 == spnSubject) {
				OnSelectHandler.Instance().setSubjectFromSpinner(
						(ServiceObject) spnSubject.getSelectedItem());
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_choice);

		this.setViewControls();
		this.addEvents();
		this.bindData();
	}

	private void addEvents() {
		this.btnRate.setOnClickListener(this.onClickListener);
		this.spnTeacher.setOnItemSelectedListener(this.onItemSelectedListener);
		this.spnSubject.setOnItemSelectedListener(this.onItemSelectedListener);
	}

	private void setViewControls() {
		this.btnRate = (Button) findViewById(R.id.btnRate);
		this.spnTeacher = (Spinner) findViewById(R.id.spinnerTeacher);
		this.spnSubject = (Spinner) findViewById(R.id.spinnerSubject);

		this.spnSubject.setActivated(false);
	}

	private void bindData() {
		ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,
				android.R.layout.simple_spinner_item, Helper.Instance()
						.buildTeacherList());
		this.spnTeacher.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_choice, menu);
		return true;
	}

}
