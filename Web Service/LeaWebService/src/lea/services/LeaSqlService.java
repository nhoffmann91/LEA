package lea.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lea.helper.SQLHelper;

@Path("/service")
public class LeaSqlService {
	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("/getpupilid/{jsonData}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getPupilId(@PathParam(value = "jsonData") String jsonData) {
		// String[] t = getData.fromJson(jsonData, String.class).split(",");
		String[] t = jsonData.split(",");

		try {
			return "" + (SQLHelper.getInstance().getPupilId(t[0], t[1], t[2]))
					+ "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@GET
	@Path("/getallteachersbypupil/{pupilId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String[][] getAllTeachersByPupil(
			@PathParam(value = "pupilId") int pupilId) throws Exception {
		String[][] teacher = null;
		
		try {
			ResultSet result = SQLHelper.getInstance().getAllTeachersByPupil(
					pupilId);
			teacher = new String[10][2];
			int counter = 0;
			while (result.next()) {
				teacher[counter][0] = "" + result.getInt("id") + "";
				teacher[counter][1] = result.getString("nname");
			}
		} catch (Exception e) {
		}

		return teacher;
	}
}