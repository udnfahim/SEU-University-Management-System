package Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class StudentFileHandler {

    public static void writeStudent(Student student) {
        try {
            String user = student.getStudentCode() + "," + student.getStudentPassword() + "," + student.name + "," + student.program + "," + student.batch + "," + student.cgpa + "\n";
            RandomAccessFile s = new RandomAccessFile("StudentID.txt", "rw");
            s.seek(s.length());
            s.writeBytes(user);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: Unable to create Student.txt.");
        } catch (IOException e) {
            System.out.println("Failed to write to Student.txt.");
        }
    }

    public static boolean readStudentAsStudent(String inputID, String inputPassword) {
        try {
            RandomAccessFile raf = new RandomAccessFile("StudentID.txt", "r");
            String user;
            while ((user = raf.readLine()) != null) {
                String[] arr = user.split(",");
                String studentID = arr[0];
                if (studentID.trim().equals(inputID.trim())) {
                    if (arr[1].trim().equals(inputPassword.trim())) {
                        String name = arr[2].trim();
                        String program = arr[3].trim();
                        int batch = Integer.parseInt(arr[4].trim());
                        double cgpa = Double.parseDouble(arr[5].trim());
                        System.out.println("╔══════════════════════════════════════════════╗");
                        System.out.println("║              STUDENT DASHBOARD               ║");
                        System.out.println("╠══════════════════════════════════════════════╣\n");

                        System.out.println("\nWelcome back " + name + "\n");
                        System.out.printf("Student Code: %s  \nName: %s  \nProgram: %s  \nBatch: %d  \nCGPA: %.2f %n", studentID, name, program, batch, cgpa);
                        return true;
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                        return false;
                    }
                }
            }
            System.out.println("Student Code not found. Please check and try again.");
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("Student file not found.");
        } catch (IOException e) {
            System.out.println("Error reading Student file.");
        }
        return false;
    }

    public static void readAllStudents() {
        try {
            RandomAccessFile raf = new RandomAccessFile("StudentID.txt", "r");
            String user;
            while ((user = raf.readLine()) != null) {
                String[] arr = user.split(",");
                if (arr.length >= 6) {
                    String studentID = arr[0].trim();
                    String name = arr[2].trim();
                    String program = arr[3].trim();
                    int batch = Integer.parseInt(arr[4].trim());
                    double cgpa = Double.parseDouble(arr[5].trim());
                    System.out.printf("Student Code: %s  Name: %s  Program: %s  Batch: %d  CGPA: %.2f %n", studentID, name, program, batch, cgpa);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Student file not found.");
        } catch (IOException e) {
            System.out.println("Error reading Student file.");
        }
    }

    public static boolean searchStudentById(String studentId) {
        try {
            RandomAccessFile raf = new RandomAccessFile("StudentID.txt", "r");
            String line;
            while ((line = raf.readLine()) != null) {
                String[] arr = line.trim().split(",");
                if (arr.length >= 6) {
                    String id = arr[0].trim();
                    if (id.equals(studentId)) {
                        String password = arr[1].trim();
                        String name = arr[2].trim();
                        String program = arr[3].trim();
                        int batch = Integer.parseInt(arr[4].trim());
                        double cgpa = Double.parseDouble(arr[5].trim());

                        System.out.println("Student Details Found:");
                        System.out.printf("ID: %s Name: %s Program: %s Batch: %d CGPA: %.2f\n", id, name, program, batch, cgpa);
                        return true;
                    }
                }
            }
            System.out.println("No student found with ID: " + studentId);
            return false;
        } catch (Exception e) {
            System.out.println("Error reading student data.");
            return false;
        }
    }
}
