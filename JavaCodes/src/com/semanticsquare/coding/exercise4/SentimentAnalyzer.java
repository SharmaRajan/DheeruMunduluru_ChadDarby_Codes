
/*
@Author: Rajan Kumar Sharma
Date: 24/04/2023
*/

package com.semanticsquare.coding.exercise4;

import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];
        review = review.toLowerCase();

        int idx = 0;
        // your code ~ you will be invoking getOpinionOnFeature
        subSet:for(String[] featureSubSet : featureSet){
            for(String feature : featureSubSet){
                int rating = getOpinionOnFeature(review,feature,posOpinionWords,negOpinionWords);
                if(rating != 0){
                    featureOpinions[idx++] = rating;
                    continue subSet;
                }

            }
            featureOpinions[idx++] = 0;
        }

        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int rating = checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);
        if(rating == 0){
            rating = checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
        }
        return rating;

    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";


        int idx = -1;
        idx = review.indexOf(pattern);
        if(idx != -1){
            idx = idx + pattern.length();
            review = review.substring(idx);
            for(String pos : posOpinionWords){
                if(review.startsWith(pos)){
                    return 1;
                }
            }
            for(String cons : negOpinionWords){
                if(review.startsWith(cons)){
                    return -1;
                }
            }

        }

        return opinion;
    }

    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        String[] sentences = review.split("\\.");
        int opinion = 0;
        int idx = -1;
        // your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)
        for(String words : sentences){
            for(String pos : posOpinionWords){
                idx = words.indexOf(pos);
                if(idx != -1){
                    idx = idx + pos.length()+1;
                    words = words.substring(idx);
                    if(words.startsWith(feature)){
                        return 1;
                    }

                }
            }
            for(String cons : negOpinionWords){
                idx = words.indexOf(cons);
                if(idx != -1){
                    idx = idx + cons.length()+1;
                    words = words.substring(idx);
                    if(words.startsWith(feature)){
                        return -1;
                    }

                }
            }
        }
        return opinion;
    }

    public static void main(String[] args) {
        //String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
        };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome","delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}
