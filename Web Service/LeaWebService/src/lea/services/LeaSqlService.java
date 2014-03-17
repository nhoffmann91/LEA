package lea.services;

import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import lea.helper.ResultConverter;
import lea.helper.SQLHelper;

@Path("/service")
public class LeaSqlService {

	@SuppressWarnings("finally")
	@GET
	@Path("/getpupilid/{firstname}/{lastname}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPupilId(
			@PathParam(value = "firstname") String firstname,
			@PathParam(value = "lastname") String lastname,
			@PathParam(value = "password") String password) {
		Gson gson = new Gson();
		int status = 400;
		String result = "";

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

	@SuppressWarnings("finally")
	@GET
	@Path("/getallteachersbypupil/{pupilId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTeachersByPupil(
			@PathParam(value = "pupilId") int pupilId) {
		Gson gson = new Gson();
		int status = 400;
		String result = "";
		
		try {
			ResultSet resultSet = SQLHelper.getInstance()
					.getAllTeachersByPupil(pupilId);
			result = gson.toJson(ResultConverter.convertToJson(resultSet));
			status = 200;
		} catch (Exception e) {
			result = gson.toJson(e, Exception.class);
		} finally {
			return Response.status(status).entity(result).build();
		}
	}

	@SuppressWarnings("finally")
	@GET
	@Path("/getallsubjectsbypupilandteacher/{pupilId}/{teacherId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSubjectsByPupilAndTeacher(
			@PathParam(value = "pupilId") int pupilId,
			@PathParam(value = "teacherId") int teacherId) {
		Gson gson = new Gson();
		int status = 400;
		String result = "";

		try {
			ResultSet resultSet = SQLHelper.getInstance()
					.getAllSubjectsByPupilAndTeacher(pupilId, teacherId);
			result = gson.toJson(ResultConverter.convertToJson(resultSet));
			status = 200;
		} catch (Exception e) {
			result = gson.toJson(e, Exception.class);
		} finally {
			return Response.status(status).entity(result).build();
		}
	}

	@SuppressWarnings("finally")
	@GET
	@Path("/getratingquestions/{pupilId}/{teacherId}/{subjectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRatingQuestions(
			@PathParam(value = "pupilId") int pupilId,
			@PathParam(value = "teacherId") int teacherId,
			@PathParam(value = "subjectId") int subjectId) {
		Gson gson = new Gson();
		int status = 400;
		String result = "";

		try {
			ResultSet resultSet = SQLHelper.getInstance().getRatingQuestions(
					pupilId, teacherId, subjectId);
			result = gson.toJson(ResultConverter.convertToJson(resultSet));
			status = 200;
		} catch (Exception e) {
			result = gson.toJson(e, Exception.class);
		} finally {
			return Response.status(status).entity(result).build();
		}
	}

	@SuppressWarnings("finally")
	@POST
	@Path("/updaterating/{pupilId}/{teacherId}/{subjectId}/{questionId}/{result}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRating(@PathParam(value = "pupilId") int pupilId,
			@PathParam(value = "teacherId") int teacherId,
			@PathParam(value = "subjectId") int subjectId,
			@PathParam(value = "questionId") int questionId,
			@PathParam(value = "result") int result) {
		Gson gson = new Gson();
		String returnResult = "";
		int status = 400;

		try {
			SQLHelper.getInstance().updateRating(pupilId, teacherId,
					questionId, subjectId, result);
			returnResult = gson.toJson("true", boolean.class);
		} catch (Exception e) {
			returnResult = gson.toJson(e, Exception.class);
		} finally {
			return Response.status(status).entity(returnResult).build();
		}
	}
}