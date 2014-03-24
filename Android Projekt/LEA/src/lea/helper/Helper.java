package lea.helper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<Object> buildTeacherList() {
		List<Object> teacherList = new ArrayList<Object>();

		try {
			ResultSet teacherSet;
			if (ServiceData.Instance().getTeacher() == null
					&& ServiceData.Instance().getPupilId() != -1) {
				teacherSet = ServiceProvider.Instance().getTeacherFromService(
						ServiceData.Instance().getPupilId());
			} else {
				teacherSet = ServiceData.Instance().getTeacherSet();
			}

			while (teacherSet.next()) {
				teacherList.add(ServiceData.Instance().new DataObject(
						teacherSet.getInt("id"), teacherSet.getString("vname")
								+ " " + teacherSet.getString("nname")));
			}
		} catch (Exception e) {
			teacherList = null;
		} finally {
			return teacherList;
		}
	}

	@SuppressWarnings("finally")
	public List<Object> buildSubjectList() {
		List<Object> subjectList = new ArrayList<Object>();

		try {
			ResultSet subjectSet;
			if (ServiceData.Instance().getSubjectSet() == null) {
				subjectSet = ServiceProvider.Instance().getSubjectsFromService(
						ServiceData.Instance().getPupilId(),
						ServiceData.Instance().getTeacher().getId());
			} else {
				subjectSet = ServiceData.Instance().getSubjectSet();
			}

			while (subjectSet.next()) {
				subjectList
						.add(ServiceData.Instance().new DataObject(subjectSet
								.getInt("id"), subjectSet.getString("fname")));
			}
		} catch (Exception e) {
			subjectList = null;
		} finally {
			return subjectList;
		}
	}
}
