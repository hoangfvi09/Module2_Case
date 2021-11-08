package service;

import model.AcademicRecord;
import model.Student;

import java.util.ArrayList;

public class AcademicRecordManagement {
    private ArrayList<AcademicRecord> recordList;
    private static final AcademicRecordManagement INSTANCE = new AcademicRecordManagement();

    private AcademicRecordManagement() {
        this.recordList = new ArrayList<>();
    }

    public static AcademicRecordManagement getInstance() {
        return INSTANCE;
    }

    public  AcademicRecord findRecordByStudent(Student student) {
        for (AcademicRecord record : INSTANCE.recordList) {
            if (record.getStudent() == student) {
                return record;
            }
        }
        return null;
    }

    public AcademicRecord addNewRecord(Student student){
        AcademicRecord academicRecord = new AcademicRecord(student);
        recordList.add(academicRecord);
        return academicRecord;
    }

}
