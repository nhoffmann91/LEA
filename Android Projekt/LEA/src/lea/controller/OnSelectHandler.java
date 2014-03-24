package lea.controller;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import lea.helper.Helper;
import lea.helper.ServiceData;
import lea.helper.ServiceData.DataObject;

public class OnSelectHandler {
	private static OnSelectHandler onSelectHandler = null;

	public OnSelectHandler() {
	}

	public static OnSelectHandler Instance() {
		if (onSelectHandler == null)
			onSelectHandler = new OnSelectHandler();
		return onSelectHandler;
	}

	public SpinnerAdapter getSubjectsByTeacher(DataObject selectedTeacher, Activity context) {
		try {
			ServiceData.Instance().setTeacher(selectedTeacher);
			
			ServiceData.Instance().setSubjectSet(
					ServiceProvider.Instance().getSubjectsFromService(
							ServiceData.Instance().getPupilId(),
							selectedTeacher.getId()));

			return new ArrayAdapter<Object>(context.getApplicationContext(),
					android.R.layout.simple_spinner_item, Helper.Instance()
							.buildTeacherList());
		} catch (Exception e) {
			return null;
		}
	}

	public void setSubjectFromSpinner(DataObject selectedItem) {
		ServiceData.Instance().setSubject(selectedItem);
	}
}
