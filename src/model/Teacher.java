package model;

public class Teacher extends User {
    private ROLE role;
    private int id;

    public Teacher(String name, String phoneNumber, int id) {
        super(name, phoneNumber);
        this.role = ROLE.TEACHER;
        this.id =id;
    }

    public Teacher(ROLE role) {
        this.role = ROLE.TEACHER;
    }

    public int getId() {
        return id;
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
