package ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Delegates {
    private int delegateId;
    private String delegateName;
    private List<Event> events = new ArrayList<>();

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
