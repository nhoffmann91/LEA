package lea.helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResultConverter {
	public static List<ServiceObject> convertToTeacherList(JSONArray jsonArray)
			throws Exception {
		List<ServiceObject> list = new ArrayList<ServiceObject>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject json_data = jsonArray.getJSONObject(i);
			list.add(new ServiceObject(json_data.getInt("id"), json_data
					.getString("vname") + " " + json_data.getString("nname")));
		}
		return list;
	}

	public static List<ServiceObject> convertToSubjectList(JSONArray jsonArray)
			throws Exception {
		List<ServiceObject> list = new ArrayList<ServiceObject>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject json_data = jsonArray.getJSONObject(i);
			list.add(new ServiceObject(json_data.getInt("id"), json_data
					.getString("fname")));
		}
		return list;
	}
	
	public static List<ServiceObject> convertToQuestionList(JSONArray jsonArray)
			throws Exception {
		List<ServiceObject> list = new ArrayList<ServiceObject>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject json_data = jsonArray.getJSONObject(i);
			list.add(new ServiceObject(json_data.getInt("id"), json_data
					.getString("frage")));
		}
		return list;
	}
}
