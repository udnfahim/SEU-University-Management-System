package Courses;

import Student.Student;

import java.util.Scanner;

public class VerifyCourses {
    Scanner scanner = new Scanner(System.in);
    public void setCourse(Course course){
        System.out.println("Enter course code followed by course type (T for Theory, L for Lab), e.g., CSE141.01 T: ");
        course.setCourse(scanner.nextLine());
    }
    public void setRegisterCourse(Student student , Course course){
        System.out.print("Please enter your Student ID: ");
        student.setStudentCode(scanner.nextLine().trim());
        System.out.print("Enter the course code with type (e.g., CSE161.01 T for Theory, CSE162.01 L for Lab): ");
        String courseInput = scanner.nextLine().trim();
        if (CourseFileHandler.isCourseExists(courseInput)) {
            course.setCourse(courseInput);
            System.out.println("Processing ...");
        } else {
            System.out.println("Course not found. Please check the course code and try again.");
        }
    }

    public void findRegisteredCourse(Student student){
        System.out.print("Please enter Student ID: ");
        student.setStudentCode(scanner.nextLine());
        CourseFileHandler.searchRegisteredCoursesByStudentId(student.getStudentCode());
    }
}
