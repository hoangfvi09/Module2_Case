package model;

import java.util.Set;

public class Conversation {
    private String inbox;
    private Set <User> members;
    private int id;

    public Conversation(String inbox, Set<User> members, int id) {
        this.inbox = inbox;
        this.members = members;
        this.id =id;
    }

    public Conversation(Set<User> members, int id) {
        this.members = members;
        this.inbox = "";
        this.id = id;
    }

    public Conversation() {
        this.inbox =  "";
        this.members =  null;
    }

    public String getInbox() {
        return inbox;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "inbox=" + inbox +
                ", members=" + members +
                '}';
    }
}
