
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise3;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {

//        int noOfStudents = studentIdList.length;

        double[]  result = new double[studentIdList.length];

        double grades;

            /*for(int row = 0; row < noOfStudents; row++){
                grades = 0.0;
                for(int col = 0; col < studentsGrades[row].length; col++){
                    if(studentsGrades[row][col] == 'A'){
                        grades += 4;
                    }else if(studentsGrades[row][col] == 'B'){
                        grades += 3;
                    }else if(studentsGrades[row][col] == 'C'){
                        grades += 2;
                    }
                }
                result[row] = (grades/studentsGrades[row].length);
            }*/
        int i =0;
            for (char[] ch: studentsGrades){
                grades = 0.0;
                int studentGradesLength = ch.length;

                for(char grade: ch){
                    if(grade == 'A'){
                        grades += 4;
                    }else if(grade == 'B'){
                        grades += 3;
                    }else {
                        grades += 2;
                    }
                }
                double average = grades/studentGradesLength;
                result[i++] = average;
            }
        return result;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if(lower < 0 || higher < 0 || (lower > higher) ){
            return null;
        }

        // invoke calculateGPA
        double[] gpa = calculateGPA(studentIdList,studentsGrades);

        int count = 0,index=0;

        for(double val: gpa){
            if(val >= lower && val <= higher){
                count++;
            }
        }

        int[] res = new int[count];

        for(int i = 0; i < gpa.length; i++){
            if(lower < gpa[i] && (gpa[i] < higher)){
                res[index++] = studentIdList[i];
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] studentIdList = {1001,1002};
        char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };

        double[] arr = calculateGPA(studentIdList,studentsGrades);

        for(double res: arr)
            System.out.print(res+ " " );

        System.out.println();

        int[] res = getStudentsByGPA(3.2,3.5,studentIdList,studentsGrades);
        for(int i: res)
            System.out.print(i+ " " );
    }

}
