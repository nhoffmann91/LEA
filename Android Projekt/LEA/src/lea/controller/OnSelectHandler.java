package lea.controller;

import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import lea.helper.Helper;
import lea.helper.ServiceData;

public class OnSelectHandler {
	private static OnSelectHandler onSelectHandler = null;

	public OnSelectHandler() {
	}

	public static OnSelectHandler Instance() {
		if (onSelectHandler == null)
			onSelectHandler = new OnSelectHandler();
		return onSelectHandler;
	}
	
	public SpinnerAdapter getSubjectsByTeacher(Object selectedTeacher) {
		try {
			ServiceData.Instance().setTeacher(teacher)
			
			ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,
					android.R.layout.simple_spinner_item, Helper.Instance().buildTeacherList());
		} catch (Exception e) {
		}
	}

	public void spnSubjectItemChange() {
		// TODO Auto-generated method stub
		
	}
}
