package com.semanticsquare.coding.exercise11;

public class MissingGradeException extends Exception{

    private int studentId;

    public MissingGradeException(int studentId) {
        this.studentId = studentId;
        System.out.println("Grade missing for studentId: " + studentId);
    }

    public int getStudentId() {
        return studentId;
    }

}
