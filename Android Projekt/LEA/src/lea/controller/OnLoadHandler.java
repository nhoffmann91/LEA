package lea.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import lea.helper.SQLHelper;

import android.app.Activity;
import android.view.View;
import android.widget.TableRow;

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
		ResultSet teachers = SQLHelper.getInstance().getAllTeachersOfTheCurrentPupil();
		
		
		return new ArrayList<View>();
	}
}
