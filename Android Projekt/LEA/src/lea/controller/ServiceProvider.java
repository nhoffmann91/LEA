package lea.controller;

import java.sql.ResultSet;

public class ServiceProvider {
	private static ServiceProvider serviceProvider = null;
	
	public ServiceProvider() {
//		ClientConfig config = new DefaultClientConfig();
//		  Client client = Client.create(config);
//		  client.addFilter(new LoggingFilter());
//		  WebResource service = client.resource(getBaseURI());
//		  JSONObject inputJsonObj = new JSONObject();
//		  inputJsonObj.put("input", "Value");
//		  System.out.println(service.path("rest").path("hello").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, inputJsonObj));
	}

	public static ServiceProvider Instance() {
		if (serviceProvider == null)
			serviceProvider = new ServiceProvider();
		return serviceProvider;
	}
	
	public int getPupilIdFromService(String firstName, String lastName, String password){
		return -1;
	}
	
	public ResultSet getTeacherFromService(int pupilId){
		return null;
	}
	
//	public ResultSet getUser(String userName) throws UniformInterfaceException {
//        final WebResource userResource = webResource
//           .path(String.format("/user/%s", userName))
//           .accept(MediaType.TEXT_XML) ;
//        return userResource.get(User.class);
//    }
//
//    public ResultSet getTweets(String userName) throws UniformInterfaceException {
//        final WebResource tweetResource = webResource
//           .path(String.format("/user/%s/tweets", userName))
//           .accept(MediaType.TEXT_XML) ;
//        return tweetResource.get(new GenericType<Collection<Tweet>>(){});
//    }
}
