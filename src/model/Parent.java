package model;

public class Parent extends User{
    private ROLE role;

    public Parent(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.role = ROLE.PARENT;
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
        return "Parent{" +
                "name = "+getName()+
                '}';
    }
}
