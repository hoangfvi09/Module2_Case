package service;

import model.Parent;
import model.Student;
import model.Teacher;
import model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UserManagement {
    private static final UserManagement INSTANCE = new UserManagement();
    private Set<User> users;
    private static int teacherNo = 0;

    public static UserManagement getInstance() {
        return INSTANCE;
    }


    private UserManagement() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
// if phone number already exist, return existing teacher object, else return new teacher object
    public User addNewUser(User.ROLE role, String name, String phoneNumber) {
        if (findUserByPhoneNumber(phoneNumber) != null) {
            return findUserByPhoneNumber(phoneNumber);
        }
        User user;
        if (role == User.ROLE.PARENT) {
            user = new Parent(name, phoneNumber);
        } else if (role == User.ROLE.TEACHER) {
            user = new Teacher(name, phoneNumber, teacherNo);
            teacherNo++;
        } else {
            user = new User(name, phoneNumber, role);
        }
        users.add(user);
        return user;
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

    public User findUserByPhoneNumber(String phoneNumber) {
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Parent> getParentList() {
        ArrayList<Parent> parents = new ArrayList<>();
        for (User user : users) {
            if (user.getRole() == User.ROLE.PARENT) {
                parents.add((Parent) user);
            }
        }
        return parents;
    }

    public Teacher findTeacherById(int id) {
        for (User user : users) {
            if (user.getRole() == User.ROLE.TEACHER) {
                Teacher teacher = (Teacher) user;
                if (teacher.getId() == id) {
                    return teacher;
                }
            }
        }
        return null;
    }


}
