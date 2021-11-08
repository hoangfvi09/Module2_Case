package model;

public class Teacher extends User {
    private ROLE role;

    public Teacher(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.role = ROLE.TEACHER;
    }

    public Teacher(ROLE role) {
        this.role = ROLE.TEACHER;
    }

    @Override
    public ROLE getRole() {
        return role;
    }

    @Override
    public void setRole(ROLE role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "role=" + role +
                '}';
    }
}
