package Student;

public class Student {
    protected String studentCode;
    private String studentPassword;
    String name;
    String program ;
    int batch ;
    double cgpa;

    public void setStudentCode(String studentCode){
        if (studentCode.length() == 13){
            this.studentCode = studentCode;
        }else{
            System.out.println("Please enter a valid 13-digit Student Code consisting of numbers only.");
        }
    }
    public String getStudentCode(){
        return this.studentCode;
    }
    public void setStudentPassword(String studentPassword){
        if( studentPassword != null && studentPassword.length() > 7){
            this.studentPassword = studentPassword;
        }else {
            System.out.println("Password must be at least 8 characters long. Please try again.");
        }
    }
    public String getStudentPassword(){
        return this.studentPassword;
    }
}

