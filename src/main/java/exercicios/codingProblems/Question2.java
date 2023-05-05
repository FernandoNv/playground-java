package exercicios.codingProblems;
//Get the Middle Character
//You are going to be given a word. Your job is to return the middle character of the word. If the word's length is odd, return the middle character. If the word's length is even, return the middle 2 characters.
//
//#Examples:
// Kata.getMiddle("test") should return "es"
// Kata.getMiddle("testing") should return "t"
// Kata.getMiddle("middle") should return "dd"
// Kata.getMiddle("A") should return "A"

//#Input
//A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000 in some test cases
// due to an error in the test cases). You do not need to test for this. This is only here to tell you that you do not need to worry about your solution timing out.
//#Output
//The middle character(s) of the word represented as a string.
public class Question2 {
    public static void main(String[] args) {
        String word = "monstr";

        System.out.println(Question2.getMiddle(word));
    }
    public static String getMiddle(String word) {
        //Code goes here
        int size = word.length();
        int mid = size/2;
        return size % 2 == 0 ? word.substring(mid-1, mid+1) : word.substring(mid, mid+1);
    }
}
