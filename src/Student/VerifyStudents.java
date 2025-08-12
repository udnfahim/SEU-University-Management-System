package Student;
import java.util.Scanner;

public class VerifyStudents extends Student{
    Scanner scanner = new Scanner(System.in);

    // Student
    public void setStudent(Student student){
        System.out.println("Student Sign UP\nStudent Code: ");
        student.setStudentCode(scanner.nextLine());
        System.out.println("Password: ");
        student.setStudentPassword(scanner.nextLine());
        System.out.println("Name: ");
        student.name = scanner.nextLine();
        System.out.println("Program: ");
        student.program = scanner.nextLine();
        System.out.println("Batch: ");
        student.batch = scanner.nextInt();
        System.out.println("CGPA: ");
        student.cgpa = scanner.nextDouble();
        scanner.nextLine();
    }
    public boolean matchStudentId() {
        System.out.println("Student Code: ");
        String inputStudentCode = scanner.nextLine();
        System.out.println("Password: ");
        String inputPassword = scanner.nextLine();
        return StudentFileHandler.readStudentAsStudent(inputStudentCode, inputPassword);
    }

    public boolean findStudentById() {
        System.out.print("Student Code: ");
        String inputStudentCode = scanner.nextLine().trim();
        if (StudentFileHandler.searchStudentById(inputStudentCode)) {
            return true;
        } else {
            System.out.println("Please enter a valid Student Code.");
            return false;
        }
    }




}
