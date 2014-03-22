package lea.helper;

import java.sql.ResultSet;
import java.util.ArrayList;

import lea.controller.ServiceProvider;

public class Helper {
	private static Helper helper = null;

	public Helper() {
	}

	public static Helper Instance() {
		if (helper == null)
			helper = new Helper();
		return helper;
	}

	@SuppressWarnings("finally")
	public ArrayList<String> buildTeacherList() {
		ArrayList<String> teacherList = new ArrayList<String>();

		try {
			ResultSet teacherSet;
			if (ServiceData.Instance().getTeacher() == null
					&& ServiceData.Instance().getPupilId() != -1) {
				teacherSet = ServiceProvider.Instance().getTeacherFromService(
						ServiceData.Instance().getPupilId());
			} else {
				teacherSet = ServiceData.Instance().getTeacher();
			}

			while (teacherSet.next()) {
				teacherList.add(teacherSet.getString("vname")
						+ " " +teacherSet.getString("nname"));
			}
		} catch (Exception e) {
			teacherList = null;
		} finally {
			return teacherList;
		}
	}
}
