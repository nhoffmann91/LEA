package lea.controller;

import java.util.ArrayList;
import android.app.Activity;
import android.view.View;

public class OnLoadHandler {
	private static OnLoadHandler onLoadHandler = null;

	public OnLoadHandler() {
	}

	public static OnLoadHandler getInstance() {
		if (onLoadHandler == null)
			onLoadHandler = new OnLoadHandler();
		return onLoadHandler;
	}
	
	public ArrayList<View> getTeacherOverview(Activity context){
		// ToDo
		return new ArrayList<View>();
	}
}
