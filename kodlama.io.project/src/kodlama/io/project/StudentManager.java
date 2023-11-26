package kodlama.io.project;

public class StudentManager extends UserManager {

	public StudentManager(Logger logger) {
		super(logger);

	}

	@Override
	public void add() {
		System.out.println("Öğrenci Eklendi");

	}
	@Override
	public void delete() {
		System.out.println("Öğrenci silindi");

	}
	@Override
	public void update() {
		System.out.println("Öğrenci güncellendi");

	}
	@Override
	public void getBranchGrande(Student student) {
		System.out.println(student.getFirstName()+" Sınav Notunuz: " + student.getBranchGrade());

	}

}
