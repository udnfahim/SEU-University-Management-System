package AdmisionOffice;

import java.util.Scanner;

public class VerifyAdmins extends AdmissionOffice{
    Scanner scanner = new Scanner(System.in);

    //Default Admin Matching
    public boolean matchAdmin(){
        System.out.println("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.println("Password: ");
        String inputPassword = scanner.nextLine();
        return AdminFileHandler.readDefaultAdmin(inputUsername,inputPassword);
    }

    //Admission Officer
    public void setAdmissionOfficer(AdmissionOffice admissionOffice){
        while (true){
            System.out.println("Admission Officer Sign UP \nUsername:");
            if(admissionOffice.setUserName(scanner.nextLine())){
                break;
            }
        }
        System.out.println("Password: ");
        admissionOffice.setAdmissionOfficerPassword(scanner.nextLine());
    }
    public boolean matchUsername(){
        System.out.println("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.println("Password: ");
        String inputPassword = scanner.nextLine();
        return AdminFileHandler.readAdminAsUser(inputUsername,inputPassword);
    }
}
