package ManyToMany;

/**
 * Custom class to retrieve fields according to our needs.
 */
public class Result {
    private String eventName;
    private String delegateName;

    public Result(String eventName, String delegateName)
    {
        this.eventName=eventName;
        this.delegateName=delegateName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDelegateName() {
        return delegateName;
    }

    public void setDelegateName(String delegateName) {
        this.delegateName = delegateName;
    }
}
