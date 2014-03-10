package lea.controller;

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
	}

	public static ServiceProvider getInstance() {
		if (serviceProvider == null)
			serviceProvider = new ServiceProvider();
		return serviceProvider;
	}
	
	
}
