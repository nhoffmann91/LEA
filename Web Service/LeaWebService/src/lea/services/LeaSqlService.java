package lea.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import lea.helper.SQLHelper;

@Path("/service")
public class LeaSqlService {
	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("/getpupilid")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getPupilId(String jsonData) {
		Gson returnData = new Gson();
		Gson getData = new Gson();
		
		String[] t = getData.fromJson(jsonData, String.class).split(",");

		try {
			return returnData.toJson(SQLHelper.getInstance().getPupilId(t[0],
					t[1], t[2]));
		} catch (Exception e) {
			return returnData.toJson(e);
		}
	}
}
