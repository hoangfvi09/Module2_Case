package service;

import model.Class;
import model.Teacher;

import java.util.Map;
import java.util.TreeMap;

public class ClassManagement {
   private Map<String, Class> classMap ;

    public ClassManagement(Map<String, Class> classMap) {
        this.classMap = classMap;
    }

    public ClassManagement() {
        this.classMap = new TreeMap<>();
    }

    public void addClass(String name){
        Class newClass = new Class(name);
        classMap.put(name,newClass);
    }

    public void addClass(String name, Teacher teacher){
        Class newClass = new Class(teacher,name);
        classMap.put(name,newClass);
    }

    public void switchClassStatus(Class classVar, Class.STATUS status){
        classVar.setStatus(status);
    }
}
