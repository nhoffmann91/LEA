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
	private DataObject teacher;
	private DataObject subject;
	private ResultSet teacherSet;
	private ResultSet subjectSet;
	private ResultSet questionSet;
	private DataObject dataObjectForService;

	public int getPupilId() {
		return this.pupilId;
	}

	public void setPupilId(int pupilId) {
		this.pupilId = pupilId;
	}

	public ResultSet getTeacherSet() {
		return teacherSet;
	}

	public void setTeacherSet(ResultSet teacherSet) {
		this.teacherSet = teacherSet;
	}

	public ResultSet getSubjectSet() {
		return subjectSet;
	}

	public void setSubjectSet(ResultSet subjectSet) {
		this.subjectSet = subjectSet;
	}

	public ResultSet getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(ResultSet questionSet) {
		this.questionSet = questionSet;
	}

	public DataObject getDataObjectForService() {
		return dataObjectForService;
	}

	public void setDataObjectForService(int id, String name) {
		this.dataObjectForService.setId(id);
		this.dataObjectForService.setName(name);
	}

	public void setDataObjectForService(int id, String name, double ranking) {
		this.dataObjectForService.setId(id);
		this.dataObjectForService.setName(name);
		this.dataObjectForService.setRanking(ranking);
	}

	public class DataObject {
		public DataObject(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public DataObject(int id, String name, double ranking) {
			this.id = id;
			this.name = name;
			this.ranking = ranking;
		}

		private int id;
		private String name;
		private double ranking;

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void setRanking(double ranking) {
			this.ranking = ranking;
		}

		public double getRanking() {
			return this.ranking;
		}
	}

	public DataObject getSubject() {
		return subject;
	}

	public void setSubject(DataObject subject) {
		this.subject = subject;
	}
	
	public DataObject getTeacher(){
		return this.teacher;
	}

	public void setTeacher(DataObject teacher) {
		this.teacher = teacher;
	}
}
