package com.semanticsquare.coding.exercise11;

public class InvalidDataException extends Exception{

    public InvalidDataException(Throwable e) {
        System.out.println("Data entered is invalid. Enter again... " + e.getMessage());
    }

    public InvalidDataException(String string) {
        System.out.println(string);
    }

}
