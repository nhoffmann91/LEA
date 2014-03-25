package lea.helper;

public class ServiceObject {
	public ServiceObject(int id){
		this.id = id;
	}
	
	public ServiceObject(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
}
