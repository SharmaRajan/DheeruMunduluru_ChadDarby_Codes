
/*
 * @Author: Rajan Kumar Sharma
 * */

package com.semanticsquare.codingexercise11;

public class IllegalArgumentException extends Exception{

    public IllegalArgumentException(int studentIdListLength, int studentsGradesLength) {

        System.out.println("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdListLength +
                ", studentsGrades.length: " + studentsGradesLength);
    }

}
