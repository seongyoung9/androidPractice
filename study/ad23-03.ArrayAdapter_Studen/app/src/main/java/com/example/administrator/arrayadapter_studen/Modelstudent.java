package com.example.administrator.arrayadapter_studen;

import org.apache.commons.collections.Predicate;

import java.util.Comparator;

public class Modelstudent {

    private String text_name;
    private String text_number;
    private String text_department;

    public String getText_name() {
        return text_name;
    }

    public String getText_number() {
        return text_number;
    }

    public String getText_department() {
        return text_department;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }

    public void setText_number(String text_number) {
        this.text_number = text_number;
    }

    public void setText_department(String text_department) {
        this.text_department = text_department;
    }

    @Override
    public String toString() {
        return "Modelstudent{" +
                "text_name='" + text_name + '\'' +
                ", text_number='" + text_number + '\'' +
                ", text_department='" + text_department + '\'' +
                '}';
    }

    public Modelstudent() {
    }

    public Modelstudent(String text_name, String text_number, String text_department) {
        this.text_name = text_name;
        this.text_number = text_number;
        this.text_department = text_department;
    }



    // Name정렬 : comparator
    // name을 기준으로 오름차순 정렬. true추가시 내림차순
    public static class NameCompare implements Comparator<Modelstudent> {

        private int mode = 1;

        public void setMode(boolean desc) {

            if ( desc == true )
                this.mode = -1;   //내림
            else
                this.mode = 1;    //올림

        }

        public NameCompare() {
            mode = 1;

        }
        public NameCompare(boolean desc) {
            this.setMode( desc );
        }

        @Override
        public int compare(Modelstudent o1, Modelstudent o2) {

            // +일때 : 바꾼다.
            // 0일때 : 바꾸지 않는다.
            // -일때 : 바꾸지 않는다.

            return o1.getText_name().compareTo( o2.getText_name() )*mode;
        }

    }
    // Number정렬 : comparator
    public static class NumberCompare implements Comparator<Modelstudent> {

        private int mode = 1;

        public void setMode(boolean desc) {

            if ( desc == true )
                this.mode = -1;   //내림
            else
                this.mode = 1;    //올림

        }
        public NumberCompare() {
            mode = 1;

        }
        public NumberCompare(boolean desc) {
            this.setMode( desc );
        }

        @Override
        public int compare(Modelstudent o1, Modelstudent o2) {

            // +일때 : 바꾼다.
            // 0일때 : 바꾸지 않는다.
            // -일때 : 바꾸지 않는다.

            return o1.getText_number().compareTo( o2.getText_number() )*mode;
        }

    }


    // Department정렬 : comparator
    public static class DepartmentCompare implements Comparator<Modelstudent> {

        private int mode = 1;

        public void setMode(boolean desc) {

            if ( desc == true )
                this.mode = -1;   //내림
            else
                this.mode = 1;    //올림

        }
        public DepartmentCompare() {
            mode = 1;

        }
        public DepartmentCompare(boolean desc) {
            this.setMode( desc );
        }

        @Override
        public int compare(Modelstudent o1, Modelstudent o2) {

            // +일때 : 바꾼다.
            // 0일때 : 바꾸지 않는다.
            // -일때 : 바꾸지 않는다.

            return o1.getText_department().compareTo( o2.getText_department() )*mode;
        }

    }



    // 검색 : predicate
    // compile group: 'commons-collections', name: 'commons-collections', version: '3.2.2'
    // 추가해야함
    public static class MyPredicate implements Predicate {

        private String fieldName;
        private Object value;

        public MyPredicate(String fieldName, Object value) {
            this.fieldName = fieldName;
            this.value = value;
        }

        @Override
        public boolean evaluate(Object object) {

            if ( fieldName.equals( "name" ) ){
                return ((Modelstudent)object).getText_name().contains( value.toString() );
            }
            else if ( fieldName.equals( "number" ) ){
                return ((Modelstudent)object).getText_number().contains( value.toString() );
            }
            else if ( fieldName.equals( "department" ) ){
                return ((Modelstudent)object).getText_department().contains( value.toString() );
            }
            else {
                return false;
            }
        }
    }

}
