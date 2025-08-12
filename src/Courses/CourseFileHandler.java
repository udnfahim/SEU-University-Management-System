package Courses;

import Student.Student;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CourseFileHandler {

    public static void writeCourse(Course course){
        try {
            String line = course.getCourse() +"\n";
            RandomAccessFile raf = new RandomAccessFile("AdvisingCourse.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
            raf.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: AdvisingCourse.txt file not found. Unable to save course.");
        }
        catch (IOException e){
            System.out.println("Error: Failed to write course to file.");
        }
    }
    public static void readAllCourse(){
        try {
            RandomAccessFile raf = new RandomAccessFile("AdvisingCourse.txt" , "r");
            String line;
            while ((line = raf.readLine()) != null){
                String[] arr = line.split(" ");
                if (arr.length >= 2){
                    String course = arr[0].trim();
                    String type = arr[1].trim();
                    System.out.printf("Course Code: %s Type: %s %n" , course , type);
                }
            }
            raf.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Advised courses file not found.");
        }
        catch (IOException e){
            System.out.println("Error reading advised courses.");
        }
    }
    public static void registerCourse(Student student, Course course) {
        try {
            File file = new File("RegisteredCourse.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            int courseCount = 0;
            boolean alreadyRegistered = false;

            String line;
            while ((line = raf.readLine()) != null) {
                String[] arr = line.trim().split(";");
                if (arr.length == 2) {
                    String id = arr[0].trim();
                    String registeredCourse = arr[1].trim();

                    if (id.equals(student.getStudentCode())) {
                        courseCount++;
                        if (registeredCourse.equalsIgnoreCase(course.getCourse().trim())) {
                            alreadyRegistered = true;
                            break;
                        }
                    }
                }
            }
            if (alreadyRegistered) {
                System.out.println("You have already registered for this course!");
                raf.close();
                return;
            }
            if (courseCount >= 5) {
                System.out.println("You cannot register more than 5 courses.");
                raf.close();
                return;
            }
            raf.seek(raf.length());
            String regCourse = student.getStudentCode() + ";" + course.getCourse() + "\n";
            raf.writeBytes(regCourse);
            System.out.println("Course registration saved successfully.");
            raf.close();
        }
        catch (IOException e) {
            System.out.println("Error during course registration.");
            e.printStackTrace();
        }
    }

    public static boolean isCourseExists(String courseCode) {
        File file = new File("RegisteredCourse.txt");

        try (RandomAccessFile raf = new RandomAccessFile("AdvisingCourse.txt", "r")) {
            String line;
            while ((line = raf.readLine()) != null) {
                String[] arr =  line.split("\\s+ ");
                if (arr.length >= 1) {
                    String code = arr[0].trim();
                    if (code.trim().equals(courseCode.trim())) {
                        return true;
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading course file.");
        }
        return false;
    }

    public static void searchRegisteredCoursesByStudentId(String studentId) {
        try {
            RandomAccessFile raf = new RandomAccessFile("RegisteredCourse.txt", "r");
            String line;
            boolean found = false;
            System.out.println("Courses registered : " + studentId);
            while ((line = raf.readLine()) != null) {
                String[] parts = line.trim().split(";");
                if (parts.length == 2) {
                    String id = parts[0].trim();
                    String course = parts[1].trim();
                    if (id.equals(studentId) && !course.trim().isEmpty()) {
                        System.out.println(" - " + course);
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("No registered courses found for this student.");
            }
        } catch (IOException e) {
            System.out.println("Error reading registered courses file.");
        }
    }

}
