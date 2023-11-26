package kodlama.io.project;

public class Main {

	public static void main(String[] args) {
		Student ogrenci1=new Student();
		ogrenci1.setId(10);
		ogrenci1.setFirstName("ugur");
		ogrenci1.setLastName("olmez");
		ogrenci1.setBranchGrade("90");
		
		Instructor ogretmen1=new Instructor();
		ogretmen1.setId(1);
		ogretmen1.setFirstName("hediye");
		ogretmen1.setLastName("olmez");
		ogretmen1.setBranch("matematik");
		
		UserManager userManager=new StudentManager(new EmailLogger());
		userManager.getBranchGrande(ogrenci1);
		
		
		
	}
}
