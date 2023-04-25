
/**
 * @Author: Rajan Kumar Sharma
 * Date: 24/04/2023
 */

package com.semanticsquare.coding.exercise13;

import java.util.*;
import java.util.stream.*;

public class SetDemo {

    private static void hashSetDemo() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("a");

        System.out.println("set1: " +  set1);

        Book book1 = new Book("Walden", "Henry Thoreau", 1854);
        Book book2 = new Book("Walden", "Henry Thoreau", 1854);
        Set<Book> set2 = new HashSet<>();
        set2.add(book1);
        set2.add(book2);
        System.out.println("set2: " +  set2);
    }

    public static void linkedHashSetDemo() {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Raj");
        hashSet.add("John");
        hashSet.add("Anita");
        System.out.println("hashSet: " + hashSet);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Raj");
        linkedHashSet.add("John");
        linkedHashSet.add("Anita");
        System.out.println("linkedHashSet: " + linkedHashSet);
    }

    private static Set<Book> treeSetDemo(Comparator comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last lecture","Handy Paush",2008);

        Set<Book> books = new TreeSet<>(comparator);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
//
//		@SuppressWarnings("unchecked")
//		int result = comparator.compare(book1, book3);
//
        /*for (Book book : books) {
            System.out.println(book);
        }*/
        return books;
    }



    public static void main(String[] args) {
        //bookSet.stream().collect();
//        Arrays.asList(bookSet.stream().sorted()).toArray();



//		bookSet.stream().sorted(new PubDateAscComparator()).filter(x->System.out.println(x)).collect(Collector.toSet());
//        bookSet.stream().collect(Collectors.toSet());

//		List<Book> bookList = (List<Book>) bookSet;
//
//		Collections.sort(bookList.stream()
//				.sorted(new PubDateAscComparator()).toList().forEach(x->System.out.println(x)));

//		for(Book book: bookSet)
//			System.out.println(book);
//		treeSetDemo(null);
//		System.out.println();
//		treeSetDemo(new PubDateAscComparator());
////		System.out.println()
//		treeSetDemo(new PubDateDescComparator());


//        System.out.println(treeSetDemo(null));


        // for streaming
        Set<Book> bookSet = treeSetDemo(new PubDateAscComparator());

//        bookSet.forEach(x-> System.out.println(x));
//
//        bookSet.forEach(System.out::println);
//
//        System.out.println(bookSet.stream().collect(Collectors.toSet()));
//
//        bookSet.stream().peek(x-> System.out.println(x)).count();

        System.out.println("Books count: " + bookSet.stream()
                .filter(s-> s.getTitle().startsWith("H"))
                .peek(s-> System.out.println("Filtered data: " +s))
                .map(Book::getTitle)
                .peek(s-> System.out.println("Title startWith 'H': " + s))
                .count());


/*
        Set<Book> bookSet1 = treeSetDemo(new PubDateAscComparator());
        System.out.println(bookSet1);*/

    }

}
