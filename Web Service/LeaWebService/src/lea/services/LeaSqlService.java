package lea.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import lea.helper.SQLHelper;

@Path("/service")
public class LeaSqlService {
	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("/getpupilid")
	@ExceptionHandler
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getPupilId(String firstname, String lastname, String password)
			throws Exception {
		try {
			return new JSONObject(SQLHelper.getInstance().getPupilId(firstname, lastname,
					password));
		} catch (Exception e) {
			throw e;
		}
	}
}
