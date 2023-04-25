package com.semanticsquare.coding.exercise1;

public class Book {

    public String title;

    public Book(){}

    public Book(String title){
        this.title = title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString(){
        return "Book: " + this.title;
    }
}
