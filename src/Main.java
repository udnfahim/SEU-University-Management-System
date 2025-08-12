import AdmisionOffice.AdminFileHandler;
import AdmisionOffice.AdmissionOffice;
import Courses.Course;
import Courses.CourseFileHandler;
import Courses.VerifyCourses;
import Student.StudentFileHandler;
import Student.Student;
import Student.VerifyStudents;
import AdmisionOffice.VerifyAdmins;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        AdminFileHandler.writeDefaultAdmin();
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        StudentFileHandler studentFileHandler = new StudentFileHandler();
        VerifyStudents verifyStudents = new VerifyStudents();
        AdmissionOffice admissionOffice = new AdmissionOffice();
        VerifyAdmins verifyAdmins = new VerifyAdmins();
        Course course = new Course();
        CourseFileHandler courseFileHandler = new CourseFileHandler();
        VerifyCourses verifyCourses = new VerifyCourses();

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║        SEU UNIVERSITY MANAGEMENT SYSTEM        ║");
        System.out.println("╠════════════════════════════════════════════════╣\n");

        while (true){

            System.out.println("\n    Welcome to SEU UMS! Please choose an option:\n");

            System.out.println("    [1] Admin Sign In");
            System.out.println("    [2] Admission Officer Sign In");
            System.out.println("    [3] Student Sign In");
            System.out.println("    [4] Reach Out");
            System.out.println("    [5] Quit");

            System.out.print("\nPlease enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                if(verifyAdmins.matchAdmin()) {
                    while (true) {
                        System.out.println("\n--- Main Admin Control Panel ---");
                        System.out.println("1. Register Admission Officer");
                        System.out.println("2. Register Student");
                        System.out.println("3. View Registered Admission Officers");
                        System.out.println("4. View Registered Students");
                        System.out.println("5. Logout");
                        System.out.print("Please enter your choice: ");
                        int option = scanner.nextInt();
                        scanner.nextLine();
                        switch (option) {
                            case 1:
                                verifyAdmins.setAdmissionOfficer(admissionOffice);
                                AdminFileHandler.writeAdminUser(admissionOffice);
                                break;
                            case 2:
                                verifyStudents.setStudent(student);
                                StudentFileHandler.writeStudent(student);
                                break;
                            case 3:
                                System.out.println("\n--- Registered Admission Officers ---\n");
                                AdminFileHandler.readAllAdmissionOfficersFile();
                                break;
                            case 4:
                                System.out.println("\n--- Registered Students List ---\n");
                                StudentFileHandler.readAllStudents();
                                break;
                            case 5:
                                System.out.println("Logout.");
                                break;
                            default:
                                System.out.println("Invalid Option Try Again!");
                                continue;
                        }
                        if (option == 5) {
                            System.out.println("Logging out...");
                            break;
                        }
                    }
                }
            }
            else if (choice == 2){
                if(verifyAdmins.matchUsername()){
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║            ADMISSION OFFICER DASHBOARD         ║");
                    System.out.println("╠════════════════════════════════════════════════╣\n");
                    while (true){

                        System.out.println("Please select an option:\n");

                        System.out.println("  [1] Register Student");
                        System.out.println("  [2] Register Course");
                        System.out.println("  [3] View Registered Students");
                        System.out.println("  [4] View Registered Courses");
                        System.out.println("  [5] Search Student");
                        System.out.println("  [6] Assign Course to Student");
                        System.out.println("  [7] Logout");

                        System.out.print("\nPlease enter your choice: ");
                        int choose = scanner.nextInt();
                        scanner.nextLine();
                        switch (choose){
                            case 1:
                                System.out.println("\n--- Register New Student ---");
                                verifyStudents.setStudent(student);
                                StudentFileHandler.writeStudent(student);
                                break;
                            case 2:
                                System.out.println("\n--- Register New Course ---");
                                verifyCourses.setCourse(course);
                                CourseFileHandler.writeCourse(course);
                                break;
                            case 3:
                                System.out.println("\n--- Registered Students List ---\n");
                                StudentFileHandler.readAllStudents();
                                break;
                            case 4:
                                System.out.println("\n--- Registered Course List ---\n");
                                CourseFileHandler.readAllCourse();
                                break;
                            case 5:
                                System.out.println("\n--- View Student Details ---");
                                verifyStudents.findStudentById();
                                System.out.println("\n--- View Registered Courses ---");
                                verifyCourses.findRegisteredCourse(student);
                                break;
                            case 6:
                                System.out.println("\n--- Register Course for Student ---");
                                verifyCourses.setRegisterCourse(student, course);
                                CourseFileHandler.registerCourse(student ,course);
                                System.out.println("Course registration process completed.\n");
                                break;
                            case 7:
                                System.out.println("Logout.");
                                break;
                            default:
                                System.out.println("Invalid Option Try Again!");
                                continue;
                        }
                        if (choose == 7) {
                            System.out.println("Logging out...");
                            break;
                        }
                    }
                }
            }
            else if (choice == 3) {
                if(verifyStudents.matchStudentId()){

                    while(true){

                        System.out.println("\nPlease select an option:\n");

                        System.out.println("  [1] View Registered Courses");
                        System.out.println("  [2] Register for New Course");
                        System.out.println("  [3] Course Advising");
                        System.out.println("  [4] Logout");

                        System.out.print("\nPlease enter your choice: ");
                        int co = scanner.nextInt();
                        scanner.nextLine();
                        switch (co){
                            case 1:
                                System.out.println("\n--- View Registered Courses ---");
                                verifyCourses.findRegisteredCourse(student);
                                break;
                            case 2:
                                System.out.println("\n--- Register Course for Student ---");
                                verifyCourses.setRegisterCourse(student, course);
                                CourseFileHandler.registerCourse(student ,course);
                                System.out.println("Course registration process completed.\n");
                                break;
                            case 3:
                                System.out.println("\n--- Course Advising ---\n");
                                CourseFileHandler.readAllCourse();
                                break;
                            case 4:
                                System.out.println("Logout.");
                                break;
                            default:
                                System.out.println("Invalid Option Try Again!");
                                continue;

                        }
                        if (co == 4) {
                            System.out.println("Logging out...");
                            break;
                        }
                    }

                }

            }

            else if (choice == 4){
                System.out.println("\n========================================== ");
                System.out.println("             CONTACT INFORMATION         ");
                System.out.println("==========================================");
                System.out.println("GitHub  : https://github.com/Udnfahim");
                System.out.println("LinkedIn: https://linkedin.com/in/uddnfahim");
                System.out.println("Email   : udnfain@gmail.com");
                System.out.println("==========================================\n");
            }

            else if (choice == 5) {
                System.out.println("\nThank you for using SEU University Management System.");
                System.out.println("Goodbye and have a great day!");
                break;
            }
            else{
                System.out.println("Invalid!");
            }
        }
    }

}

