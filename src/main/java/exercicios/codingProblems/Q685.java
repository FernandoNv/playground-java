package exercicios.codingProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//Given a string and a set of delimiters, reverse the words in the string
// while maintaining the relative order of the delimiters.
// For example, given "hello/world:here", return "here/world:hello"
//
//Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"
public class Q685 {
    private static final Set<Character> characterSet = new HashSet<>();
    static {
        characterSet.add('/');
        characterSet.add(':');
    }
    public static String f(String str){
        Stack<String> words = new Stack<>();
        Queue<Character> delimiters = new LinkedList<>();

        int i = 0, j = 0;
        while(j < str.length()){
            char firstLetter = str.charAt(i);
            if(characterSet.contains(firstLetter)){//if is a delimiter
                // empty word after a delimiter
                words.add("?");
                delimiters.add(str.charAt(j));
            }else{
                while(j < str.length() && !characterSet.contains(str.charAt(j))) j++;
                String word = str.substring(i, j);
                words.push(word);
                if(j < str.length()) delimiters.add(str.charAt(j));
            }
            j++;
            i = j;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String word;
        while (!words.isEmpty()) {
            word = words.pop();
            if(!word.equals("?"))
                stringBuilder.append(word);
            if(delimiters.peek() != null)
                stringBuilder.append(delimiters.poll());
        }

        return stringBuilder.toString();
    }

}
