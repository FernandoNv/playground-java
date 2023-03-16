package exercicios.codewars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//DESCRIPTION:
//Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
//
//Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
//
//If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
//
//Examples
//"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
//        "4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
//        ""  -->  ""

public class Question1 {
    public static void main(String[] args) {
        String word = "is2 Thi1s T4est 3a";
        System.out.println(word);
        System.out.println(Order.order(word));
    }
}

class Order {
    static Pattern digitPattern = Pattern.compile("\\d+");
    public static String order(String words) {
        if(words.equals("")) return words;

        String[] arrayWords = words.split(" ");
        String[] arrayResult = new String[arrayWords.length];

        int[] newIndexes = Arrays.stream(arrayWords)
                .map(Order::getDigit)
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i = 0; i < newIndexes.length; i++){
            arrayResult[newIndexes[i]-1] = arrayWords[i];
        }

        return String.join(" ", arrayResult);
    }

    public static String getDigit(String word){
        Matcher matcher = Order.digitPattern.matcher(word);
        matcher.find();

        return matcher.group();
    }

}
