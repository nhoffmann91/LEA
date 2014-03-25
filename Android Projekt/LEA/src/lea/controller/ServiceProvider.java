package lea.controller;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import lea.helper.Constant;
import lea.helper.ResultConverter;
import lea.helper.ServiceData;
import lea.helper.ServiceObject;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;

import com.google.gson.Gson;

public class ServiceProvider {
	private static ServiceProvider serviceProvider = null;

	public ServiceProvider() {
	}

	public static ServiceProvider Instance() {
		if (serviceProvider == null)
			serviceProvider = new ServiceProvider();
		return serviceProvider;
	}

	@SuppressWarnings("finally")
	public int getPupilIdFromService(String firstName, String lastName,
			String password) {
		String uri = Constant.ServiceUrl + Constant.GetPupilIdPath + "/"
				+ firstName + "/" + lastName + "/" + password;
		int pupilId = -1;

		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			// JAXBContext jc = JAXBContext.newInstance(Customer.class);
			InputStream json = connection.getInputStream();
			// Customer customer = (Customer)
			// jc.createUnmarshaller().unmarshal(xml);
			connection.disconnect();
			pupilId = 1;
		} catch (Exception e) {

		} finally {
			return pupilId;
		}
	}

	public List<ServiceObject> getTeacherFromService(int pupilId) {
		String uri = Constant.ServiceUrl + Constant.GetTeacherPath + "/"
				+ pupilId;

		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			Gson gson = new Gson();
			// JAXBContext jc = JAXBContext.newInstance(Customer.class);
			InputStream json = connection.getInputStream();
			connection.disconnect();
			
			List<ServiceObject> teacherList = ResultConverter
					.convertToTeacherList(gson.fromJson(json.toString(),
							JSONArray.class));
			return teacherList;
			// Customer customer = (Customer)
			// jc.createUnmarshaller().unmarshal(xml);
		} catch (Exception e) {
			return null;
		}
	}

	public List<ServiceObject> getSubjectsFromService(int pupilId, int teacherId) {
		String uri = Constant.ServiceUrl + Constant.GetSubjectsPath + "/"
				+ pupilId + "/" + teacherId;

		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			Gson gson = new Gson();
			// JAXBContext jc = JAXBContext.newInstance(Customer.class);
			InputStream json = connection.getInputStream();
			connection.disconnect();
			
			List<ServiceObject> subjectList = ResultConverter
					.convertToSubjectList(gson.fromJson(json.toString(),
							JSONArray.class));
			return subjectList;
			// Customer customer = (Customer)
			// jc.createUnmarshaller().unmarshal(xml);
		} catch (Exception e) {
			return null;
		}
	}

	public List<ServiceObject> getQuestionsFromService(int pupilId,
			int teacherId, int subjectId) {
		String uri = Constant.ServiceUrl + Constant.GetQuestionsPath + "/"
				+ pupilId + "/" + teacherId + "/" + subjectId;

		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			Gson gson = new Gson();
			// JAXBContext jc = JAXBContext.newInstance(Customer.class);
			InputStream json = connection.getInputStream();
			connection.disconnect();
			
			List<ServiceObject> questionList = ResultConverter
					.convertToQuestionList(gson.fromJson(json.toString(),
							JSONArray.class));
			return questionList;
			// Customer customer = (Customer)
			// jc.createUnmarshaller().unmarshal(xml);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateService(List<ServiceData> results) {
		try {
			for (int i = 0; i < results.size(); i++) {
				String uri = Constant.ServiceUrl + Constant.UpdateResultPath
						+ "/" + results.get(i).getPupilId() + "/"
						+ results.get(i).getTeacherId() + "/"
						+ results.get(i).getSubjectId() + "/"
						+ results.get(i).getQuestionId() + "/"
						+ results.get(i).getResult();

				URL url = new URL(uri);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Accept", "application/json");

				InputStream json = connection.getInputStream();

				connection.disconnect();

			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
