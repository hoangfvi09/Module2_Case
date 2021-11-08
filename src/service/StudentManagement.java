package service;

import model.Class;
import model.Parent;
import model.Student;

import java.util.*;

public class StudentManagement {
    private static final StudentManagement INSTANCE = new StudentManagement();
    private final ArrayList<Student> studentList;
    private static int studentNo = 0;

    public static StudentManagement getInstance() {
        return INSTANCE;
    }


    private StudentManagement() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(String name, String phoneNumber, Class classVar, String birthday) {
        Student student = new Student(name, phoneNumber, studentNo, classVar, birthday);
        studentList.add(student);
        studentNo++;
    }

    public void addStudent(String name, String phoneNumber, Class classVar, String birthday, Parent parent) {
        Student student = new Student(name, phoneNumber, studentNo, classVar, birthday, parent);
        studentList.add(student);
        studentNo++;
    }

    //tao hsinh moi
    public Student addStudent(String name, Class classVar, String birthday, Parent parent) {
        Student student = new Student(name, studentNo, classVar, birthday, parent);
        studentList.add(student);
        studentNo++;
        return student;
    }


    public void addStudent(String name) {
        Student student = new Student(name, studentNo);
        studentList.add(student);
        studentNo++;
    }

    public void switchStudentStatus(Student student, Class.STATUS status) {
        student.setStatus(status);
    }

    //return array list of students in specific class
    public ArrayList<Student> filterStudentsByClass(String className) {
        ArrayList<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            Class classOfStudent = student.getStudentsClass();
            if (classOfStudent.getName() == className) {
                students.add(student);
            }
        }
        return students;
    }

    public Student findStudentById(int id) {
        for (Student student : studentList) {

            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentList) {

            if (student.getName().contains(name)) {
                students.add(student);
            }
        }
        return students;
    }

    public ArrayList<Student> findStudentByParent(Parent parent) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentList) {

            if (student.getParent() == parent) {
                students.add(student);
            }
        }
        return students;
    }


}
