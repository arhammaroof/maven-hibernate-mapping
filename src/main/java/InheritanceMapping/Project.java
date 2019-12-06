package InheritanceMapping;

import javax.persistence.*;

@Entity
/**
 * Inheritance mapping is used when there is a inheritance relation ship between Entities.
 * @Inheritance annotiation is used and strategy is passed as a parameter telling the database how to save the entities in the db
 * When joined is used all the entities will be stored in a different table joining them together with a key of the Parent table.(i.e Project, in our case)
 */
@Inheritance(strategy = InheritanceType.JOINED)
public class Project {
    private int projectId;
    private String projectName;

    @Id
    @GeneratedValue
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
