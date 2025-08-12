package AdmisionOffice;

public class AdmissionOffice {

    private String userName;
    private String adminPassword;
    private String admissionOfficerPassword;
    //Default Set
    public void setAdminPassword(String adminPassword){
        this.adminPassword = adminPassword;
    }
    public String getAdminPassword(){
        return this.adminPassword;
    }

    public boolean setUserName(String userName){
        if (userName != null && userName.length() > 9){
            this.userName = userName;
            return true;
        }
        else {
            System.out.println("Username must be at least 10 characters long. Please try again.");
            return false;
        }
    }
    public String getUserName(){
        return this.userName;
    }

    public void setAdmissionOfficerPassword(String admissionOfficerPassword){
        if (admissionOfficerPassword != null && admissionOfficerPassword.length() > 7 ){
            this.admissionOfficerPassword = admissionOfficerPassword;
        }else {
            System.out.println("Password must be at least 8 characters long. Please try again.");
        }
    }
    public String getAdmissionOfficerPassword(){
        return this.admissionOfficerPassword;
    }
}
