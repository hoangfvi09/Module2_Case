package model;

public class User {
    public static enum STATUS {
        ACTIVE, INACTIVE;
    }
    private String name;
    private String phoneNumber;
    public static enum ROLE {
        PARENT, TEACHER, ADMIN, STUDENT, ANONYMOUS
    }
    private ROLE role;
    private STATUS status;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = ROLE.ANONYMOUS;
        this.status = STATUS.ACTIVE;
    }

    public User(String name, String phoneNumber, ROLE role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = STATUS.ACTIVE;
    }

    public User() {

    }

    public User(String name) {
        this.name = name;
        this.status = STATUS.ACTIVE;
        this.role = ROLE.ANONYMOUS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                '}';
    }
}
