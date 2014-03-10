package testdata;

public class Lehrer {
	private String vname;
	private String nname;
	private int id;
	private Fach[] faecher;
	
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fach[] getFaecher() {
		return faecher;
	}
	public void setFaecher(Fach[] faecher) {
		this.faecher = faecher;
	}
}
