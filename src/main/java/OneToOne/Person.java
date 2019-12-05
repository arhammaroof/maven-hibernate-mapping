package OneToOne;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Person {
    private int personId;
    private String personName;
    private PersonDetails pDetails;

    @Id
    @GeneratedValue(generator = "incrementor")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     *cascade is used to cascade the insertion deletion and updation of a record
     *Fetch is used to fetch the joined table record. Eager Fetch to get it with the current table. Late to get it seperately
     * @JoinColumn annotation is used to define the relationship we are creating on which field.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pDetail_FK")
    public PersonDetails getpDetails() {
        return pDetails;
    }

    public void setpDetails(PersonDetails pDetails) {
        this.pDetails = pDetails;
    }




}
