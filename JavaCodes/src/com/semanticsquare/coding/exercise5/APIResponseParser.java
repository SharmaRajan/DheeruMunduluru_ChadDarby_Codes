
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise5;

public class APIResponseParser {

    /**
     * Parses the input text and returns a Book instance containing the parsed data.
     *
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */

    public static Book parse(String response) {
        Book book = new Book();

        String endRule = "<";

        String[] startRule = { "<title>", "<name>", "<original_publication_year type=\"integer\">", "<average_rating>",
                "<ratings_count type=\"integer\">", "<image_url>" };

        // parsing title
        String title = parse(response, startRule[0], endRule);

        // parsing name
        String name = parse(response, startRule[1], endRule);

        // to parse publication year
        int publicationYear = Integer.parseInt(parse(response, startRule[2], endRule));

        // to parse average rating
        double averageRating = Double.parseDouble(parse(response, startRule[3], endRule));

        // to parse rating count and split it on "," and store on a array.
        String ratingsCounts[] = parse(response, startRule[4], endRule).split(",");

        String rating = "";

        //concatenate each element of ratingsCounts array into rating variable.
        for (String i : ratingsCounts) {
            rating = rating.concat(i);
        }

        //converting string type of rating into integer.
        int ratings = Integer.parseInt(rating);

        //to parsing imageUrl
        String imageUrl = parse(response, startRule[5], endRule);

        book.setTitle(title);
        book.setAuthor(name);
        book.setPublicationYear(publicationYear);
        book.setAverageRating(averageRating);
        book.setRatingsCount(ratings);
        book.setImageUrl(imageUrl);
        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int index = response.indexOf(startRule);
        response = response.substring(index + startRule.length());
        String answer = "";
        char c;
        for (int i = 0; i < response.length(); i++) {
            c = response.charAt(i);
            if (c == (endRule.charAt(0))) {
                return answer;
            } else {
                answer = answer.concat(String.valueOf(c));
            }
        }
        return answer;
    }

    // write overloaded parse method with the 3 parameters response, startRule,
    // endRule

    public static void main(String[] args) {
        String response = "<work>" + "<id type=\"integer\">2361393</id>"
                + "<books_count type=\"integer\">813</books_count>"
                + "<ratings_count type=\"integer\">1,16,315</ratings_count>"
                + "<text_reviews_count type=\"integer\">3439</text_reviews_count>"
                + "<original_publication_year type=\"integer\">1854</original_publication_year>"
                + "<original_publication_month type=\"integer\" nil=\"true\"/>"
                + "<original_publication_day type=\"integer\" nil=\"true\"/>" + "<average_rating>3.79</average_rating>"
                + "<best_book type=\"Book\">" + "<id type=\"integer\">16902</id>" + "<title>Walden</title>" + "<author>"
                + "<id type=\"integer\">10264</id>" + "<name>Henry David Thoreau</name>" + "</author>" + "<image_url>"
                + "http://images.gr-assets.com/books/1465675526m/16902.jpg" + "</image_url>" + "<small_image_url>"
                + "http://images.gr-assets.com/books/1465675526s/16902.jpg" + "</small_image_url>" + "</best_book>"
                + "</work>";

        APIResponseParser.parse(response);

        //Book b = APIResponseParser.parse(response);
        /*System.out.println("Title of Book is : " + b.getTitle());
        System.out.println("Name of Author is : " + b.getAuthor());
        System.out.println("Publication Year of Book is : " + b.getPublicationYear());
        System.out.println("Average Rating of Book is : " + b.getAverageRating());
        System.out.println("Rating Count of Book is : " + b.getRatingsCount());
        System.out.println("Image Url of Book is : " + b.getImageUrl());*/
    }
}

