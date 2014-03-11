package lea.services;

import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import lea.helper.SQLHelper;

@Path("/service")
public class LeaSqlService {

	@SuppressWarnings("finally")
	@GET
	@Path("/getpupilid/{firstname}/{lastname}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPupilId(
			@PathParam(value = "firstname") String firstname,
			@PathParam(value = "lastname") String lastname,
			@PathParam(value = "password") String password) {
		Gson gson = new Gson();
		String result = "";
		int status = 400;

		try {
			int id = SQLHelper.getInstance().getPupilId(firstname, lastname,
					password);
			result = gson.toJson(id);
			status = 200;
		} catch (Exception e) {
			result = gson.toJson(e);
		} finally {
			return Response.status(status).entity(result).build();
		}
	}

	@GET
	@Path("/getallteachersbypupil/{pupilId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTeachersByPupil(
			@PathParam(value = "pupilId") int pupilId) throws Exception {
		Gson gson = new Gson();
		String result = "";

		try {
			ResultSet resultSet = SQLHelper.getInstance()
					.getAllTeachersByPupil(pupilId);
			result = gson.toJson(resultSet);
		} catch (Exception e) {
			result = gson.toJson(e);
		}

		return result;
	}

	@GET
	@Path("/getallsubjectsbypupilandteacher/{pupilId}/{teacherId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSubjectsByPupilAndTeacher(
			@PathParam(value = "pupilId") int pupilId,
			@PathParam(value = "teacherId") int teacherId) throws Exception {
		Gson gson = new Gson();
		String result = "";

		try {
			ResultSet resultSet = SQLHelper.getInstance()
					.getAllSubjectsByPupilAndTeacher(pupilId, teacherId);
			result = gson.toJson(resultSet);
		} catch (Exception e) {
			result = gson.toJson(e);
		}
		return result;
	}

	@GET
	@Path("/getratingquestions/{pupilId}/{teacherId}/{subjectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRatingQuestions(@PathParam(value = "pupilId") int pupilId,
			@PathParam(value = "teacherId") int teacherId,
			@PathParam(value = "subjectId") int subjectId) throws Exception {
		Gson gson = new Gson();
		String result = "";

		try {
			ResultSet resultSet = SQLHelper.getInstance().getRatingQuestions(
					pupilId, teacherId, subjectId);
			result = gson.toJson(resultSet);
		} catch (Exception e) {
			result = gson.toJson(e);
		}
		return result;
	}

	@POST
	@Path("/updaterating/{pupilId}/{teacherId}/{subjectId}/{questionId}/{result}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateRating(@PathParam(value = "pupilId") int pupilId,
			@PathParam(value = "teacherId") int teacherId,
			@PathParam(value = "subjectId") int subjectId,
			@PathParam(value = "questionId") int questionId,
			@PathParam(value = "result") int result) throws Exception {
		Gson gson = new Gson();
		String returnResult = "";

		try {
			SQLHelper.getInstance().updateRating(pupilId, teacherId,
					questionId, subjectId, result);
			returnResult = "true";
		} catch (Exception e) {
			returnResult = gson.toJson(e);
		}

		return returnResult;
	}
}