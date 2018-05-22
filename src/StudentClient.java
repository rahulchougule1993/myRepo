import java.util.Scanner;

import com.dac.bean.Student;
import com.dac.service.StudebtServiceImpl;
import com.dac.service.StudentService;

public class StudentClient {

	StudentService service;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new StudentClient();
	}
	public StudentClient() {
		super();
		service = new StudebtServiceImpl();
		Scanner sc = new Scanner(System.in);
		int rollNo = 0;
		
		while(true){
		int choice = StudentClient.getChoice();
		
		switch (choice) {
		case 1:
			System.out.println("Enter <rollNo> <name> <std> <stream> ");
			
			Student stu = new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
			boolean saved = service.save(stu);
			if(saved){
				System.out.println("student saved");
			}else{
				System.out.println("student not saved");
			}
			break;
		case 2:
			System.out.println("Enter Roll No : ");
			rollNo= sc.nextInt();
			Student student = service.getStudent(rollNo);
			
			if(student == null){
				System.out.println("student not found");
			}else{
				System.out.println(student);
			}
			
			break;
		case 3:
			System.out.println("Enter Roll No : ");
			rollNo = sc.nextInt();
			 boolean deleted =  service.deleteStudent(rollNo);
			if(deleted){
				System.out.println("deleted succesfully");
			}else{
				System.out.println("deletion of student failed..");
			}
			
			
			break;
		case 4:
            System.out.println("Enter <rollNo> <name> <std> <stream> ");
			
			Student studentUpdate = new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
			boolean updated = service.updateStudent(studentUpdate);
			if(updated){
				System.out.println("student updated Successfully");
			}else{
				System.out.println("student not updated");
			}
			
			break;
		case 5:
			service.closeEntityManager();
			System.exit(0);
			
			break;

		default:
			System.out.println("Enter only 1 to 5 nos as choice ");
			break;
		}
		
		
		}
	}
	private static int getChoice() {
		// TODO Auto-generated method stub
		System.out.println("1.save Student");
		System.out.println("2.display Student");
		System.out.println("3.delete Student");
		System.out.println("4.update Student");
		System.out.println("5.Exit application");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;
	}

}
