package com.example.tabpagerfragment;

public class Modelstudent {

    private String textName       = ""  ;
    private String textNumber     = ""  ;
    private String textDepartment = ""  ;

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(String textNumber) {
        this.textNumber = textNumber;
    }

    public String getTextDepartment() {
        return textDepartment;
    }

    public void setTextDepartment(String textDepartment) {
        this.textDepartment = textDepartment;
    }

    @Override
    public String toString() {
        return "Modelstudent{" +
                "textName='" + textName + '\'' +
                ", textNumber='" + textNumber + '\'' +
                ", textDepartment='" + textDepartment + '\'' +
                '}';
    }

    public Modelstudent() {
    }

    public Modelstudent(String textName, String textNumber, String textDepartment) {
        this.textName = textName;
        this.textNumber = textNumber;
        this.textDepartment = textDepartment;
    }
}
