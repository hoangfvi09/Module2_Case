package model;

public class Student extends User{
    private ROLE role;
    private int id=0;
    private Class.STATUS status;
    private Class classOfStudent;


    public Student(String name, String phoneNumber, int id, Class classVar) {
        super(name, phoneNumber);
        this.role = ROLE.STUDENT;
        this.id = id;
        this.status= Class.STATUS.ON;
        this.classOfStudent=classVar;
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
        this.status= Class.STATUS.ON;
    }

    public Class.STATUS getStudentStatus() {
        return status;
    }

    public void setStatus(Class.STATUS status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Class getClassOfStudent() {
        return classOfStudent;
    }

    public void setClassOfStudent(Class classOfStudent) {
        this.classOfStudent = classOfStudent;
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
        return "Student{" +
                "role=" + role +
                '}';
    }
}
