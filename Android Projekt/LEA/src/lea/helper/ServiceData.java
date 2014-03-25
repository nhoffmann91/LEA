package lea.helper;

public class ServiceData {
//	private static ServiceData serviceData = null;
//
//	public ServiceData() {
//	}
//
//	public static ServiceData Instance() {
//		if (serviceData == null)
//			serviceData = new ServiceData();
//		return serviceData;
//	}
	
	public ServiceData(int pupilId, int teacherId, int subjectId, int questionId, float result){
		this.pupilId = pupilId;
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.questionId = questionId;
		this.result = result;
	}
	
	private int pupilId;
	private int teacherId;
	private int subjectId;
	private int questionId;
	private float result;
	
	public int getPupilId() {
		return pupilId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public double getResult() {
		return result;
	}
	
	

//	private int pupilId;
//	private DataObject teacher;
//	private DataObject subject;
//	private ResultSet teacherSet;
//	private ResultSet subjectSet;
//	private ResultSet questionSet;
//	private List<DataObject> resultForService;
//
//	public int getPupilId() {
//		return this.pupilId;
//	}
//
//	public void setPupilId(int pupilId) {
//		this.pupilId = pupilId;
//	}
//
//	public ResultSet getTeacherSet() {
//		return teacherSet;
//	}
//
//	public void setTeacherSet(ResultSet teacherSet) {
//		this.teacherSet = teacherSet;
//	}
//
//	public ResultSet getSubjectSet() {
//		return subjectSet;
//	}
//
//	public void setSubjectSet(ResultSet subjectSet) {
//		this.subjectSet = subjectSet;
//	}
//
//	public ResultSet getQuestionSet() {
//		return questionSet;
//	}
//
//	public void setQuestionSet(ResultSet questionSet) {
//		this.questionSet = questionSet;
//	}
//
//	public List<DataObject> getResultForService() {
//		return this.resultForService;
//	}
//
//	public void putResultForService(int id, String name) {
//		if(this.resultForService == null){
//			this.resultForService = new ArrayList<DataObject>();
//		}
//		
//		DataObject d = new DataObject(id, name);
//		this.resultForService.add(d);
//	}
//
//	public void putResultForService(int id, String name, float rating) {
//		if(this.resultForService == null){
//			this.resultForService = new ArrayList<DataObject>();
//		}
//		
//		DataObject d = new DataObject(id, name, rating);
//		this.resultForService.add(d);
//	}
//
//	public class DataObject {
//		public DataObject(int id, String name) {
//			this.id = id;
//			this.name = name;
//		}
//
//		public DataObject(int id, String name, float rating) {
//			this.id = id;
//			this.name = name;
//			this.rating = rating;
//		}
//
//		private int id;
//		private String name;
//		private float rating;
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//		public int getId() {
//			return this.id;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getName() {
//			return this.name;
//		}
//
//		public void setRanking(float rating) {
//			this.rating = rating;
//		}
//
//		public double getRanking() {
//			return this.rating;
//		}
//	}
//
//	public DataObject getSubject() {
//		return subject;
//	}
//
//	public void setSubject(DataObject subject) {
//		this.subject = subject;
//	}
//	
//	public DataObject getTeacher(){
//		return this.teacher;
//	}
//
//	public void setTeacher(DataObject teacher) {
//		this.teacher = teacher;
//	}
}
