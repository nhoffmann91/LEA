package lea.controller;

public class OnSelectHandler {
	private static OnSelectHandler onSelectHandler = null;

	public OnSelectHandler() {
	}

	public static OnSelectHandler getInstance() {
		if (onSelectHandler == null)
			onSelectHandler = new OnSelectHandler();
		return onSelectHandler;
	}
	
	public void setSubjectsByTeacher() {
		// TODO Auto-generated method stub
		
	}

	public void spnSubjectItemChange() {
		// TODO Auto-generated method stub
		
	}
}
