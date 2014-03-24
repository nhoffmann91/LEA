package lea.controller;

import java.sql.ResultSet;

import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

public class ServiceProvider {
	private static ServiceProvider serviceProvider = null;
	
	public ServiceProvider() {
//		WebResource s1 = Client.create().resource( "http://localhost:8080/rest" );
//		Builder sb1 = s1.path( "message" ).path( "serverinfo" )
//		                                  .accept( MediaType.APPLICATION_JSON );
//		System.out.println( sb1.get( ServerInfo.class ).server );  // Windows Vista 6.0
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
	
	public ResultSet getSubjectsFromService(int pupilId, int teacherId){
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
