package ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event {
    private int eventId;
    private String eventName;
    private List<Delegates> delegates = new ArrayList<>();

    public Event(){}
    public Event(String eventName){
        this.eventName=eventName;
    }
    @Id
    @GeneratedValue
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @ManyToMany
    /**
     *To create a pivot/conjunction table use @jointable annotation between the two entities.
     * joinColumns will store the primary key of the current entity.(i.e Delegate in our case)
     * joinInverseColumns will store the primary key of the other entity.(i.e Event in our case)
     */
    @JoinTable(name = "Delegate_Event",
            joinColumns = {@JoinColumn(name = "eventId")},
            inverseJoinColumns = {@JoinColumn(name = "delegateId")})
    public List<Delegates> getDelegates() {
        return delegates;
    }

    public void setDelegates(List<Delegates> delegates) {
        this.delegates = delegates;
    }


}
