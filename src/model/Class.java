package model;

public class Class {
    private Teacher teacher;
    private String name;
    public static enum STATUS {
        ON, OFF
    }
    private STATUS status;

    public Class(Teacher teacher, String name) {
        this.teacher = teacher;
        this.name = name;
        this.status = STATUS.ON;
    }



    public Class(String name) {
        this.name = name;
        this.status = STATUS.ON;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Class{" +
                "teacher=" + teacher.getName() +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
