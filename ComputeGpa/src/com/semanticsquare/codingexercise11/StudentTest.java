
/*
* @Author: Rajan Kumar Sharma
* */

package com.semanticsquare.codingexercise11;

public class StudentTest {

    public static void main(String[] args)
            throws IllegalArgumentException, MissingGradeException, InvalidDataException {

        double lower = 3.2;
        double higher = 3.8;
        int[] studentIdList = { 1001, 1002 };
        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, {'A', 'C', ' '} };

        StudentUtil student = new StudentUtil();
        int[] ans = new int[2];

        try {
            ans = student.getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
        } catch(IllegalArgumentException e) {
            throw e;
        } catch(MissingGradeException e) {
            //System.out.println(e);
            System.out.println(e.getCause());
        }

        for (int i: ans) {
            System.out.print(i + " ");
        }

    }


}
