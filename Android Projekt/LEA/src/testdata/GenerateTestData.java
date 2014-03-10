package testdata;

public class GenerateTestData {
	private Schueler s;
	
	public Schueler generateSchueler(){
		this.s = new Schueler();
		this.s.setNname("Hoffmann");
		this.s.setVname("Nick");
		this.s.setId(1);
		
		this.s.setFaecher(generateFacherForSchueler());
		
		return this.s;
	}

	private Fach[] generateFacherForSchueler() {
		Fach[] faecher = new Fach[4];
		
		Fach f = new Fach();
		
		f.setFname("Deutsch");
		f.setId(1);
		faecher[0] = f;
		
		f.setFname("Mathematik");
		f.setId(2);
		faecher[1] = f;
		
		f.setFname("Ethik");
		f.setId(3);
		faecher[2] = f;
		
		f.setFname("Religion");
		f.setId(4);
		faecher[3] = f;
		
		return faecher;
	}
	
	public boolean checkUserAndPw(String username, String password){
		if()
	}
}
