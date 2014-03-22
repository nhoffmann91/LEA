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
>>>>>>> origin/branch_1
	}

	public static ServiceProvider getInstance() {
		if (serviceProvider == null)
			serviceProvider = new ServiceProvider();
		return serviceProvider;
	}
	
<<<<<<< HEAD
	
=======
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
