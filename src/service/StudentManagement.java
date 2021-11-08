package service;

import model.Class;
import model.Student;

import java.util.*;

public class StudentManagement {
    private final Map<Integer, Student> studentMap;
    private static int studentNo = 0;

    public StudentManagement(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public StudentManagement() {
        this.studentMap = new TreeMap<>();
    }

    public void addStudent(String name, String phoneNumber, Class classVar) {
        Student student = new Student(name, phoneNumber, studentNo, classVar);
        studentMap.put(studentNo, student);
        studentNo++;
    }

    public void addStudent(String name) {
        Student student = new Student(name, studentNo);
        studentMap.put(studentNo, student);
        studentNo++;
    }

    public void switchStudentStatus(Student student, Class.STATUS status) {
        student.setStatus(status);
    }

    //return array list of students in specific class
    public ArrayList<Student> showStudentListOfClass(Class classVar) {
        ArrayList <Student> students=new ArrayList<>();
        Set<Integer> idSet = studentMap.keySet();

        for (Integer id : idSet) {
            Class classOfStudent =  studentMap.get(id).getClassOfStudent();
            if (studentMap.get(id).getClassOfStudent() == classVar){
                students.add(studentMap.get(id));
            }
        }
        return students;
    }




}
