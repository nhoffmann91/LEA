package lea.helper;

import java.sql.ResultSet;

public class ServiceData {
	private static ServiceData serviceData = null;

	public ServiceData() {
	}

	public static ServiceData Instance() {
		if (serviceData == null)
			serviceData = new ServiceData();
		return serviceData;
	}
	
	private int pupilId;
	private ResultSet teacher;
	private ResultSet subjects;
	private ResultSet questions;

	public int getPupilId() {
		return this.pupilId;
	}

	public void setPupilId(int pupilId) {
		this.pupilId = pupilId;
	}

	public ResultSet getTeacher() {
		return teacher;
	}

	public void setTeacher(ResultSet teacher) {
		this.teacher = teacher;
	}

	public ResultSet getSubjects() {
		return subjects;
	}

	public void setSubjects(ResultSet subjects) {
		this.subjects = subjects;
	}

	public ResultSet getQuestions() {
		return questions;
	}

	public void setQuestions(ResultSet questions) {
		this.questions = questions;
	}
}
