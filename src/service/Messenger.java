package service;

import model.Conversation;
import model.User;

import java.util.*;

public class Messenger {
    private ArrayList<Conversation> messenger;
    private static int inboxNo = 0;

    public Messenger(ArrayList<Conversation> messenger) {
        this.messenger = messenger;
    }

    public Messenger() {
        this.messenger = new ArrayList<>();
    }

    public ArrayList<Conversation> getMessenger() {
        return messenger;
    }

    public void setMessenger(ArrayList<Conversation> messenger) {
        this.messenger = messenger;
    }

    public void addNewInbox(User... users) {

        Set<User> userSet = null;
        Collections.addAll(userSet, users);
        Conversation inbox = new Conversation(userSet, inboxNo);
        inboxNo++;
        this.messenger.add(inbox);

    }

    public ArrayList<Conversation> showUserInbox(User user) {
        ArrayList<Conversation> userInbox = new ArrayList<>();

        for (Conversation conversation : messenger) {
            if (conversation.getMembers().contains(user)) {
                userInbox.add(conversation);
            }
        }
        return userInbox;
    }

    public void sendMessage(User sender, User receiver, String message) {
        Set<User> members = new HashSet<>();
        members.add(sender);
        members.add(receiver);
        Conversation conversation = findConversationByMembers(members);

        if (conversation != null) {
            String inbox = conversation.getInbox();
            inbox += sender.getName() + ": " + message
        }else {

        }

    }

    public Conversation findConversationByMembers(Set<User> members) {
        for (Conversation conversation : messenger) {
            Set<User> groupChatMembers = conversation.getMembers();
            if (groupChatMembers.contains(members) && groupChatMembers.size() == members.size()) {
                return conversation;
            }
        }
        return null;
    }


}




}

