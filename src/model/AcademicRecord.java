package model;

public class AcademicRecord {
    private double mathsGrade;
    private double englishGrade;
    private double literatureGrade;
    private double physicsGrade;
    private double chemistryGrade;


    public AcademicRecord(double mathsGrade, double englishGrade, double literatureGrade, double physicsGrade, double chemistryGrade) {
        this.mathsGrade = mathsGrade;
        this.englishGrade = englishGrade;
        this.literatureGrade = literatureGrade;
        this.physicsGrade = physicsGrade;
        this.chemistryGrade = chemistryGrade;
    }

    public AcademicRecord() {
    }

    public void setMathsGrade(double mathsGrade) {
        this.mathsGrade = mathsGrade;
    }

    public void setEnglishGrade(double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public void setLiteratureGrade(double literatureGrade) {
        this.literatureGrade = literatureGrade;
    }

    public void setPhysicsGrade(double physicsGrade) {
        this.physicsGrade = physicsGrade;
    }

    public void setChemistryGrade(double chemistryGrade) {
        this.chemistryGrade = chemistryGrade;
    }

    @Override
    public String toString() {
        return "Academic Record" + '\n'+
                "  Maths grade = " + mathsGrade +'\n'+
                "  English grade = " + englishGrade +'\n'+
                "  Literature grade = " + literatureGrade +'\n'+
                "  Physics grade=" + physicsGrade +'\n'+
                "  Chemistry grade=" + chemistryGrade +'\n';
    }
}
