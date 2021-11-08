package service;

import model.Parent;
import model.Teacher;
import model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UserManagement {
    private Set<User> users;

    public UserManagement(Set<User> users) {
        this.users = users;
    }

    public UserManagement() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean addNewUser(User.ROLE role, String name, String phoneNumber) {
        User user;
        if (role == User.ROLE.PARENT) {
            user = new Parent(name, phoneNumber);
        } else if (role == User.ROLE.TEACHER) {
            user = new Teacher(name, phoneNumber);
        } else {
            user = new User(name, phoneNumber);
        }
        if (users.contains(user)) {
            return false;
        }
        users.add(user);
        return true;

    }

    public void switchUserStatus(User user, User.STATUS status) {
        user.setStatus(status);
    }

    public boolean containsUser(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

}
