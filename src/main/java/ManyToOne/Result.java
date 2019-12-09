package ManyToOne;

public class Result {
    private String collegeName;
    private String studentName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Result(String collegeName, String studentName){
        this.collegeName=collegeName;
        this.studentName=studentName;
    }
}
