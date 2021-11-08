package model;

public class Student extends User{
    private ROLE role;
    private int id;
    private Class.STATUS status;
    private Class classOfStudent;
    private Parent parent;
    private String birthday;
    private double tuitionFee;


    public Student(String name, String phoneNumber, int id, Class classVar,String birthday, Parent parent) {
        super(name, phoneNumber);
        this.role = ROLE.STUDENT;
        this.id = id;
        this.status= Class.STATUS.ON;
        this.classOfStudent=classVar;
        this.birthday =birthday;
        this.parent = parent;
        this.tuitionFee = 0;

    }
    public Student(String name, int id, Class classVar,String birthday, Parent parent) {
        super(name);
        this.role = ROLE.STUDENT;
        this.id = id;
        this.status= Class.STATUS.ON;
        this.classOfStudent=classVar;
        this.birthday =birthday;
        this.parent = parent;
        this.tuitionFee = 0;

    }
    public Student(String name, String phoneNumber, int id, Class classVar, String birthday) {
        super(name, phoneNumber);
        this.role = ROLE.STUDENT;
        this.id = id;
        this.status= Class.STATUS.ON;
        this.classOfStudent=classVar;
        this.birthday =birthday;
        this.tuitionFee = 0;
    }
    public Student(String name,  int id, Class classVar, String birthday) {
        super(name);
        this.role = ROLE.STUDENT;
        this.id = id;
        this.status= Class.STATUS.ON;
        this.classOfStudent=classVar;
        this.birthday =birthday;
        this.tuitionFee = 0;
    }

    public Student(String name, int id) {
        super(name);
        this.id = id;
        this.status= Class.STATUS.ON;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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

    public Class getStudentsClass() {
        return classOfStudent;
    }

    public void setClassOfStudent(Class classOfStudent) {
        this.classOfStudent = classOfStudent;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name= " +getName()+
                ", id=" + id +
                ", status=" + status +
                ", class=" + classOfStudent.getName() +
                ", parent=" + parent +
                ", birthday='" + birthday + '\'' +
                ", tuitionFee=" + tuitionFee +
                '}';
    }
}
