package lea.controller;

<<<<<<< HEAD
public class ServiceProvider {
	private static ServiceProvider serviceProvider = null;

	public ServiceProvider() {
//		ClientConfig config = new DefaultClientConfig();
//			  Client client = Client.create(config);
//			  WebResource service = client.resource(UriBuilder.fromUri("http://restUrl").build());
//			  // getting XML data
//			  System.out.println(service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_JSON).get(String.class));
//		  // getting JSON data
//		  System.out.println(service. path("restPath").path("resourcePath").accept(MediaType.APPLICATION_XML).get(String.class));
//		 }}
=======
import java.sql.ResultSet;

import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

public class ServiceProvider {
	private static ServiceProvider serviceProvider = null;
	
	public ServiceProvider() {
<<<<<<< HEAD
//		ClientConfig config = new DefaultClientConfig();
//		  Client client = Client.create(config);
//		  client.addFilter(new LoggingFilter());
//		  WebResource service = client.resource(getBaseURI());
//		  JSONObject inputJsonObj = new JSONObject();
//		  inputJsonObj.put("input", "Value");
//		  System.out.println(service.path("rest").path("hello").accept(MediaType.APPLICATION_JSON).post(JSONObject.class, inputJsonObj));
>>>>>>> origin/branch_1
=======
//		WebResource s1 = Client.create().resource( "http://localhost:8080/rest" );
//		Builder sb1 = s1.path( "message" ).path( "serverinfo" )
//		                                  .accept( MediaType.APPLICATION_JSON );
//		System.out.println( sb1.get( ServerInfo.class ).server );  // Windows Vista 6.0
>>>>>>> origin/branch_1
	}

	public static ServiceProvider Instance() {
		if (serviceProvider == null)
			serviceProvider = new ServiceProvider();
		return serviceProvider;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	
=======
=======
	public int getPupilIdFromService(String firstName, String lastName, String password){
		return -1;
	}
	
	public ResultSet getTeacherFromService(int pupilId){
		return null;
	}
	
	public ResultSet getSubjectsFromService(int pupilId, int teacherId){
		return null;
	}
	
>>>>>>> origin/branch_1
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
>>>>>>> origin/branch_1
}
