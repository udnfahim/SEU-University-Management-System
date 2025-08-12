package AdmisionOffice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AdminFileHandler {

    //Default Admin
    public static void writeDefaultAdmin(){
        try{
            File file = new File("Admin.txt");
            if (!file.exists()){
                RandomAccessFile raf = new RandomAccessFile("Admin.txt" , "rw");
                raf.writeBytes("admin123;admin321");
                raf.close();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found: Unable to create Admin.txt.");
        }
        catch (IOException e){
            System.out.println("Failed to write to Admin.txt.");
        }
    }
    public static boolean readDefaultAdmin(String inputUser , String inputPassword){
        try{
            RandomAccessFile raf = new RandomAccessFile("Admin.txt" , "r");
            String admin;
            while ((admin = raf.readLine()) != null) {
                String[] arr = admin.split(";");
                String adminUser = "admin123";
                if (arr[0].equals("admin123") && arr[0].equals(inputUser)) {
                    if (arr[1].equals(inputPassword)) {
                        System.out.println("Welcome back Admin");
                        System.out.printf("\nUsername: %s %n", "admin123");
                        return true;
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                        return false;
                    }
                }
            }
            System.out.println("Username not found. Please check and try again.");
        }
        catch(FileNotFoundException e){
            System.out.println("Admin file not found.");
        }
        catch (IOException e){
            System.out.println("Error reading admin file.");
        }
        return false;
    }

    //Admission Officer
    public static void writeAdminUser(AdmissionOffice admissionOffice){
        try{
            String admin = admissionOffice.getUserName() + ";" + admissionOffice.getAdmissionOfficerPassword() +"\n";
            RandomAccessFile raf = new RandomAccessFile("Admin.txt" , "rw");
            raf.seek(raf.length());
            raf.writeBytes(admin);
        }
        catch (FileNotFoundException e){
            System.out.println("Admin file not found. Unable to write Admission Officer data.");
        }
        catch (IOException e){
            System.out.println("An error occurred while writing to Admin.txt.");
        }
    }
    protected static boolean readAdminAsUser(String inputUser , String inputPassword){
        try{
            RandomAccessFile raf = new RandomAccessFile("Admin.txt" , "r");
            String admin;
            while ((admin = raf.readLine()) != null) {
                String[] arr = admin.split(";");
                String adminUser = arr[0].trim();
                if (adminUser.trim().equals(inputUser.trim())) {
                    String password = arr[1].trim();
                    if (password.trim().equals(inputPassword.trim())) {
                        System.out.println("\nWelcome back " + adminUser + "\n");
                        return true;
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                        return false;
                    }
                }
            }
            System.out.println("Username not found. Please check and try again.");
            return false;
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found: Unable to create Admin.txt.");
        }
        catch (IOException e){
            System.out.println("Error reading Admission Officer file.");
        }
        return false;
    }
    public static void readAllAdmissionOfficersFile( ){
        try{
            RandomAccessFile raf = new RandomAccessFile("Admin.txt", "r");
            String user ;
            while ((user = raf.readLine()) != null){
                String[] arr = user.split(";");
                String name = arr[0].trim();
                String password = arr[1].trim();
                if (!name.trim().equals("admin123") && !password.trim().equals("admin321")) {
                    System.out.printf("Username: %s %n", name);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found: Unable to create Admin.txt.");
        }
        catch (IOException e){
            System.out.println("Error reading Admission Officers file.");
        }
    }
}

