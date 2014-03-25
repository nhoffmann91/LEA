package lea.controller;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import lea.helper.Helper;
import lea.helper.ServiceObject;

public class OnSelectHandler {
	private static OnSelectHandler onSelectHandler = null;

	public OnSelectHandler() {
	}

	public static OnSelectHandler Instance() {
		if (onSelectHandler == null)
			onSelectHandler = new OnSelectHandler();
		return onSelectHandler;
	}

	public SpinnerAdapter getSubjectsByTeacher(ServiceObject selectedTeacher,
			Activity context) {
		try {

			Helper.subjects = ServiceProvider.Instance()
					.getSubjectsFromService(Helper.pupil.getId(),
							selectedTeacher.getId());
			Helper.selectedTeacher = selectedTeacher;

			return new ArrayAdapter<Object>(context.getApplicationContext(),
					android.R.layout.simple_spinner_item, Helper.Instance()
							.buildSubjectList());
		} catch (Exception e) {
			return null;
		}
	}

	public void setSubjectFromSpinner(ServiceObject selectedItem) {
		Helper.selectedSubject = selectedItem;
	}
}
