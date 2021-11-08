package service;

import model.Class;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ClassManagement {
    private static final ClassManagement INSTANCE = new ClassManagement();
    private ArrayList<Class> classList;


    public static ClassManagement getInstance() {
        return INSTANCE;
    }

    private ClassManagement() {
        this.classList = new ArrayList<>();
    }

    public Class addClass(String name) {
        Class newClass = new Class(name);
        classList.add(newClass);
        return newClass;
    }

    public Class addClass(String name, Teacher teacher) {
        Class newClass = new Class(teacher, name);
        classList.add(newClass);
        return newClass;
    }

    public void switchClassStatus(Class classVar, Class.STATUS status) {
        classVar.setStatus(status);
    }

    public ArrayList<Class> findClassByTeacher(Teacher teacher) {
        ArrayList<Class> classes = new ArrayList<>();
        for (Class classVar : classList) {
            if (classVar.getTeacher() == teacher) {
                classes.add(classVar);
            }
        }
        return classes;
    }

    public String printClassInfoByTeacher(Teacher teacher) {
        String str = "";
        ArrayList<Class> classes = findClassByTeacher(teacher);
        for (Class classVar : classes) {
            ArrayList<Student> students = StudentManagement.getInstance().filterStudentsByClass(classVar.getName());
            str += "Class "+ classVar.getName() +"\n";
            for (Student student : students) {
                str += student  + "\n";
            }
        }
        return str;
    }

    public String printAllClasses() {
        String str = "";

        for (Class classVar : classList) {
            ArrayList<Student> students = StudentManagement.getInstance().filterStudentsByClass(classVar.getName());
            str += "Class "+ classVar.getName() +"\n";
            for (Student student : students) {
                str += student  + "\n";
            }
        }
        return str;
    }

    public void updateTeacherForClass(Class classVar, Teacher teacher) {
        classVar.setTeacher(teacher);
    }

    public Class findClassByName(String name) {
        for (Class classVar : classList) {
            if (classVar.getName().equals(name)) {
                return classVar;
            }
        }
        return null;
    }

}
