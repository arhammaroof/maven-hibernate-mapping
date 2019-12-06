package ManyToOne;

import javax.persistence.*;

@Entity
public class Student {
    private int studentId;
    private String studentName;
    private College college;

    @Id
    @GeneratedValue
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @ManyToOne
    /**
     * join column identifies the column we want to create the relationship with. (in our case Students have a many to one relationship with College. hence, college_id is used.)
     */
    @JoinColumn(name = "college_id")
    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
