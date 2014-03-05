package lea.helper;

import java.util.ArrayList;

public class TestData {
	private static TestData testData = null;

	public TestData() {
		this.username = "nick";
		this.password = "1234";
		
		ArrayList<String> teacher = new ArrayList<String>();
		teacher.add("Pfleiderer");
		teacher.add("Eiermann");
		teacher.add("Pröbstl");
		this.teacherList = teacher;
		
		ArrayList<String> sub = new ArrayList<String>();
		sub.add("Deutsch");
		sub.add("AEP");
		sub.add("Sozi");
		this.subjectList = sub;
	}

	public static TestData getInstance() {
		if (testData == null)
			testData = new TestData();
		return testData;
	}
	
	private String username;
	private String password;
	private ArrayList<String> teacherList;
	private ArrayList<String> subjectList;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<String> teacherList) {
		this.teacherList = teacherList;
	}

	public ArrayList<String> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<String> subjectList) {
		this.subjectList = subjectList;
	}
	
}
