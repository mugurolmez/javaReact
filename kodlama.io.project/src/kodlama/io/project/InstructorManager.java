package kodlama.io.project;

public class InstructorManager  extends UserManager{
	
	public InstructorManager(Logger logger) {
		super(logger);
		
	}
	@Override
	public void add() {
		System.out.println("Öğretmen eklendi");
	
	}
	@Override
	public void delete(){
		System.out.println("Numaralı Öğretmen Silindi");
	}
	@Override
	public void update() {
		System.out.println("Numaralı Öğretmen Güncellendi");
		
	}
	
	public void getBranch(Instructor instructor) {
		System.out.println("sayın "+instructor.getFirstName()+" "+instructor.getLastName()+" branşınız:  "+instructor.getBranch() );
		
	}
}
