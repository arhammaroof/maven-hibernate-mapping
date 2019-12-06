package ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Delegates {
    private int delegateId;
    private String delegateName;
    private List<Event> events = new ArrayList<>();

    public Delegates(String delegateName){
        this.delegateName = delegateName;
    }
    public Delegates(){}
    @Id
    @GeneratedValue
    public int getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(int delegateId) {
        this.delegateId = delegateId;
    }

    public String getDelegateName() {
        return delegateName;
    }

    public void setDelegateName(String delegateName) {
        this.delegateName = delegateName;
    }

    /**
     *To create a pivot/conjunction table use @jointable annotation between the two entities.
     * joinColumns will store the primary key of the current entity.(i.e Delegate in our case)
     * joinInverseColumns will store the primary key of the other entity.(i.e Event in our case)
     */
    @ManyToMany
    @JoinTable(name = "Delegate_Event",
            joinColumns = {@JoinColumn(name = "delegateId")},
            inverseJoinColumns = {@JoinColumn(name = "eventId")})
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
