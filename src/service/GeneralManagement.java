package service;

import model.*;
import model.Class;

import java.util.ArrayList;

public class GeneralManagement {
    private static final AccountManagement accountManagement = AccountManagement.getInstance();
    private static final ClassManagement classManagement = ClassManagement.getInstance();
    private static final Messenger messenger = Messenger.getInstance();
    private static final StudentManagement studentManagement = StudentManagement.getInstance();
    private static final UserManagement userManagement = UserManagement.getInstance();
    private static final AcademicRecordManagement academicRecordManagement = AcademicRecordManagement.getInstance();
    private User currentUser;

    public GeneralManagement(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean confirmAuthorization(User.ROLE role) {
        return currentUser.getRole() == role;
    }

    // try
    public String viewThisStudent() {
        String studentsInfo = "";
        if (confirmAuthorization(User.ROLE.PARENT)) {
            for (Student student : studentManagement.findStudentByParent((Parent) currentUser)) {
                studentsInfo += student;
            }
        }
        if (confirmAuthorization((User.ROLE.STUDENT))) {
            Student student = (Student) currentUser;
            studentsInfo += student;

        }
        return studentsInfo;
    }

    public String viewClass() {
        String classInfo = "";
        if (confirmAuthorization(User.ROLE.TEACHER)) {
            Teacher teacher = (Teacher) currentUser;
//            ArrayList <model.Class> classes = classManagement.findClassByTeacher(teacher);
//            if (classes!=null){
//
            classInfo +=  classManagement.printClassInfoByTeacher(teacher) + "\n";

        }
        return classInfo;
    }

    public String viewAllClasses() {
        String classInfo = "";
        if (confirmAuthorization(User.ROLE.ADMIN)) {
            classInfo += classManagement.printAllClasses();
        }
        return classInfo;
    }

    public boolean updateStudentRecord(int id, double maths, double english, double literature, double physics, double chemistry) {
        Student student = studentManagement.findStudentById(id);
        if (student != null) {

            if (confirmAuthorization(User.ROLE.TEACHER)) {

                Teacher teacher = (Teacher) currentUser;
                boolean canAccessThisStudent = classManagement.findClassByTeacher(teacher).contains(student.getStudentsClass());
                if (canAccessThisStudent) {
                    AcademicRecord record = academicRecordManagement.findRecordByStudent(id);
                    record.setMathsGrade(maths);
                    record.setChemistryGrade(chemistry);
                    record.setEnglishGrade(english);
                    record.setLiteratureGrade(literature);
                    record.setPhysicsGrade(physics);

                    return true;
                }

            } else if (confirmAuthorization(User.ROLE.ADMIN)) {
                AcademicRecord record = academicRecordManagement.findRecordByStudent(id);
                record.setMathsGrade(maths);
                record.setChemistryGrade(chemistry);
                record.setEnglishGrade(english);
                record.setLiteratureGrade(literature);
                record.setPhysicsGrade(physics);
                return true;
            }

        }
        return false;
    }


    public boolean updateStudentInfo(int id, String newName, String newBirthday) {
        Student student = studentManagement.findStudentById(id);
        if (student != null) {
            if (confirmAuthorization(User.ROLE.TEACHER)) {
                Teacher teacher = (Teacher) currentUser;
                boolean canAccessThisStudent = classManagement.findClassByTeacher(teacher).contains(student.getStudentsClass());
                if (canAccessThisStudent) {
                    student.setName(newName);
                    student.setBirthday(newBirthday);
                    return true;
                }

            } else if (confirmAuthorization(User.ROLE.ADMIN)) {
                student.setName(newName);
                student.setBirthday(newBirthday);
                return true;
            }
        }
        return false;
    }

    public boolean updateParentInfoByStudentId(int id, String newParentName, String newParentPhoneNo) {

        Student student = studentManagement.findStudentById(id);
        if (student != null) {
            if (confirmAuthorization(User.ROLE.TEACHER)) {
                Teacher teacher = (Teacher) currentUser;
                boolean canAccessThisStudent = classManagement.findClassByTeacher(teacher).contains(student.getStudentsClass());
                if (canAccessThisStudent) {
                    Parent parent = student.getParent();
                    parent.setName(newParentName);
                    parent.setPhoneNumber(newParentPhoneNo);
                    return true;
                }

            } else if (confirmAuthorization(User.ROLE.ADMIN)) {
                Parent parent = student.getParent();
                parent.setName(newParentName);
                parent.setPhoneNumber(newParentPhoneNo);
                return true;
            }
        }
        return false;
    }

    public boolean updateTuitionFee(int id, double newFee) {
        Student student = studentManagement.findStudentById(id);
        if (student != null) {
            if (confirmAuthorization(User.ROLE.ADMIN)) {
                student.setTuitionFee(newFee);
                return true;
            }
        }
        return false;
    }

    public boolean updateTeacherInfo(int id, String newName, String phoneNumber) {
        Teacher teacher = userManagement.findTeacherById(id);
        if (teacher != null) {
            if (confirmAuthorization(User.ROLE.ADMIN)) {
                teacher.setName(newName);
                teacher.setPhoneNumber(phoneNumber);
                return true;
            }
        }
        return false;
    }

    public boolean updateTeacherForClass(String className, int teacherId) {
        Teacher teacher = userManagement.findTeacherById(teacherId);
        Class classVar = classManagement.findClassByName(className);
        if (teacher != null && classVar != null) {
            if (confirmAuthorization(User.ROLE.ADMIN)) {
                classManagement.updateTeacherForClass(classVar, teacher);
                return true;
            }
        }
        return false;
    }

    public String showMyInbox() {
        return messenger.showUserInbox(currentUser);
    }

    public boolean sendMessage(String phoneNumber, String message) {
        User receiver = userManagement.findUserByPhoneNumber(phoneNumber);
        if (receiver != null) {
            messenger.sendMessage(currentUser, receiver, message);
            return true;
        }
        return false;
    }

    // when add new student, create account for student, and account for parent if phone number doesn't exist, if already exits, not create new account for parent
    public boolean addNewStudent(String name, String birthday, String className, String parentName, String parentPhoneNumber, String stUsername) {
        if (confirmAuthorization(User.ROLE.ADMIN)) {
            Class classVar = classManagement.findClassByName(className);
            Parent parent = (Parent) userManagement.findUserByPhoneNumber(parentPhoneNumber);

            if (classVar == null) {
                classVar = classManagement.addClass(className);
            }
            if (parent == null) {
                parent = (Parent) userManagement.addNewUser(User.ROLE.PARENT, parentName, parentPhoneNumber);
            }

            Student student = studentManagement.addStudent(name, classVar, birthday, parent);
            accountManagement.addNewAccount(stUsername, "00000000", student);
            accountManagement.addNewAccount(parentPhoneNumber, "00000000", parent);
            academicRecordManagement.addNewRecord(student);
            return true;
        }
        return false;
    }

    public void addNewTeacher(String tcName, String tcPhoneNo, String className) {
        Teacher teacher = (Teacher) userManagement.addNewUser(User.ROLE.TEACHER, tcName, tcPhoneNo);
        Class classVar = classManagement.findClassByName(className);
        accountManagement.addNewAccount(tcPhoneNo, "0000000", teacher);
        classManagement.updateTeacherForClass(classVar, teacher);

    }

    public boolean changePassword(String newPassWord) {
        String username = accountManagement.getUsername(currentUser);
        return accountManagement.changePassword(username, newPassWord);
    }

    public String printClassByName(String className) {
        ArrayList<Student> students = studentManagement.filterStudentsByClass(className);
        StringBuilder str = new StringBuilder();
        for (Student student : students) {
            str.append(student).append("\n");
        }
        return str.toString();
    }

    public Teacher findTeacherByPhoneNo(String phoneNo) {
        return (Teacher) userManagement.findUserByPhoneNumber(phoneNo);
    }
    public Parent findParentByPhoneNo(String phoneNo) {
        return (Parent) userManagement.findUserByPhoneNumber(phoneNo);
    }

    public String viewRecord(){
        String str = "";
        if (confirmAuthorization(User.ROLE.STUDENT)){
            Student student = (Student) currentUser;
            str += academicRecordManagement.findRecordByStudent(student.getId());
        }else if (confirmAuthorization(User.ROLE.PARENT)){
            Parent parent = (Parent) currentUser;
            ArrayList <Student> students = studentManagement.findStudentByParent(parent);
            for (Student student:students){
                str += student.getName() + "\n"+
                        academicRecordManagement.findRecordByStudent(student.getId());
            }

        }
        return str;
    }

    public static void main(String[] args) {
        User user1 = UserManagement.getInstance().addNewUser(User.ROLE.ADMIN, "hoangvi", "0379744382");
        AccountManagement.getInstance().addNewAccount("hoangvi09", "0000", user1);
        GeneralManagement adminManagement = new GeneralManagement(user1);
        adminManagement.addNewStudent("hoc sinh A", "090998", "A", "phu huynh A", "9999", "usernameA");
        adminManagement.addNewStudent("hoc sinh B", "020202", "C", "phu huynh B", "9988", "usernameB");
        adminManagement.addNewStudent("hoc sinh C", "010101", "B", "phu huynh C", "9784", "usernameC");
        adminManagement.addNewStudent("hoc sinh D", "030321", "A", "phu huynh D", "9988", "usernameD");
        adminManagement.addNewTeacher("giao vien 1", "000000", "A");
        adminManagement.updateStudentInfo(1, "new hvi", "090990");
        Teacher teacher = adminManagement.findTeacherByPhoneNo("000000");
        adminManagement.updateTuitionFee(3,400000);
        adminManagement.updateStudentRecord(0,9,9,9,9,9);
        adminManagement.updateStudentRecord(1,9,9,9,9,9);
        adminManagement.updateStudentRecord(2,9,9,9,9,9);
        adminManagement.updateStudentRecord(3,9,9,9,9,9);
        Parent parent = adminManagement.findParentByPhoneNo("9999");
        GeneralManagement parentManagement = new GeneralManagement(parent);

        adminManagement.updateTeacherForClass("B", 0);
        GeneralManagement teacherManagement = new GeneralManagement(teacher);

        System.out.println(parentManagement.viewRecord());


    }


}
