package service;

import model.Conversation;
import model.User;

import java.util.*;

public class Messenger {
    private ArrayList<Conversation> messenger;
    private static int conversationNo = 0;

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

    public Conversation addNewInbox(User user1, User user2) {
        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        Conversation conversation = new Conversation(userSet, conversationNo);
        conversationNo++;
        this.messenger.add(conversation);
        return conversation;

    }

    public String showUserInbox(User user) {
        ArrayList<Conversation> userInbox = new ArrayList<>();

        for (Conversation conversation : messenger) {
            if (conversation.getMembers().contains(user)) {
                userInbox.add(conversation);
            }
        }
        String conversationPrinter = "";
        for (Conversation inbox : userInbox) {
            conversationPrinter += inbox;
        }
        return conversationPrinter;
    }

    public void sendMessage(User sender, User receiver, String message) {
        Set<User> members = new HashSet<>();
        members.add(sender);
        members.add(receiver);
        Conversation conversation = findConversationByMembers(sender,receiver);

        if (conversation != null) {
            String inbox = conversation.getMessages();
            inbox += sender.getName() + ": " + message + "\n";
            conversation.setMessages(inbox);
        } else {
            Conversation newConversation = addNewInbox(sender, receiver);
            String inbox = newConversation.getMessages();
            inbox += sender.getName() + ": " + message + "\n";
            newConversation.setMessages(inbox);
        }


    }

    public Conversation findConversationByMembers(User user1, User user2) {
        for (Conversation conversation : messenger) {
            Set<User> groupChatMembers = conversation.getMembers();
            if (groupChatMembers.contains(user1) && groupChatMembers.contains(user2)) {
                return conversation;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user1 = new User("hvi1");
        User user2 = new User("hvi2");
        User user3 = new User("hvi3");
        Messenger messenger = new Messenger();
        messenger.addNewInbox(user1, user2);
        messenger.addNewInbox(user2, user3);
        messenger.sendMessage(user1, user2, "Hello, how are you" );
        messenger.sendMessage(user2, user1, "fine tks");
        messenger.sendMessage(user1,user2,"dc rui ne!");
        messenger.sendMessage(user3,user1, "hi 1, i'am 3");
        System.out.println(messenger.showUserInbox(user1));

    }


}

