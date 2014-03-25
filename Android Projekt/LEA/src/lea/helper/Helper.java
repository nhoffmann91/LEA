package lea.helper;

import java.util.ArrayList;
import java.util.List;

import lea.controller.ServiceProvider;

public class Helper {
	public static int ratingCounter;
	public static ServiceObject pupil;
	public static List<ServiceObject> teacher;
	public static List<ServiceObject> subjects;
	public static List<ServiceObject> questions;
	public static List<ServiceData> results;
	public static ServiceObject selectedTeacher;
	public static ServiceObject selectedSubject;
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
			teacher = ServiceProvider.Instance().getTeacherFromService(
					pupil.getId());

			for (int i = 0; i < teacher.size(); i++) {
				teacherList.add(teacher.get(i));
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
			subjects = ServiceProvider.Instance().getSubjectsFromService(
					pupil.getId(), selectedTeacher.getId());
			for (int i = 0; i < subjects.size(); i++) {
				subjectList.add(subjects.get(i));
			}
		} catch (Exception e) {
			subjectList = null;
		} finally {
			return subjectList;
		}
	}
}
