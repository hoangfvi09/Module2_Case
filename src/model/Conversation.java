package model;

import java.util.Set;

public class Conversation {
    private String messages;
    private Set <User> members;
    private int id;

    public Conversation(String inbox, Set<User> members, int id) {
        this.messages = inbox;
        this.members = members;
        this.id =id;
    }

    public Conversation(Set<User> members, int id) {
        this.members = members;
        this.messages = "";
        this.id = id;
    }

    public Conversation() {
        this.messages =  "";
        this.members =  null;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String inbox) {
        this.messages = inbox;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public String printMembers(){
        String membersName ="";
        for (User member: members){
            membersName+= " " + member.getName();
        }
        return membersName;
    }

    @Override
    public String toString() {
        return "Conversation between: " +printMembers()+'\n'+
                 messages + '\n';
    }
}
