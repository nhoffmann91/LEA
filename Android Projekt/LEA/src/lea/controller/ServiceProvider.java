package lea.controller;

import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceProvider {
	private static ServiceProvider serviceProvider = null;

	public ServiceProvider() {
		String uri =
			    "http://localhost:8080/LeaWebService/service/getpupilid";
			URL url = new URL(uri);
			HttpURLConnection connection =
			    (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/jason");
			connection.setRequestProperty("Content-Type", "application/json");

			connection.disconnect();
	}

	public static ServiceProvider getInstance() {
		if (serviceProvider == null)
			serviceProvider = new ServiceProvider();
		return serviceProvider;
	}
	
	
}
