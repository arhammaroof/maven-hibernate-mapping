package ManyToOne;

import javax.persistence.*;
import java.util.List;
@Entity
public class College {
    private int collegeId;
    private String collegeName;
    private List<Student> students;

    @Id
    @GeneratedValue
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     *targetEntity, as the name implies targets the entity we are creating the relationship with.(i.e in our case Student)
     *cascadeType.all cascades all the operation (Insert, updates, deletes)
     * fetchType.LAZY is used when we don't want to bring the data in our memory of the associated records in the other table. In our case college has many Students. We don't want to load all the Student records in the memory when we load a College record.
     * By default hibernate sets the fetchtype in @OneToMany annotation as lazy which makes sense as we don't want to waste the memory unless required. we can always Explicitly set it to EAGER.
     */
    @OneToMany(targetEntity = Student.class, mappedBy = "college",
                cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
