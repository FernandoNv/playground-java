package exercicios.codewars;
//DESCRIPTION:
//You probably know the "like" system from Facebook and other pages.
// People can "like" blog posts, pictures or other items.
// We want to create the text that should be displayed next to such an item.
//
//Implement the function which takes an array containing the names of people that like an item.
// It must return the display text as shown in the examples:
//
//[]                                -->  "no one likes this"
//["Peter"]                         -->  "Peter likes this"
//["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
//["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
//["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
//Note: For 4 or more names, the number in "and 2 others" simply increases.
public class Question4 {

    public static void main(String[] args) {
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    public static String whoLikesIt(String... names) {
        //Do your magic here
        int size = names.length;
        if(size == 0){
            return "no one likes this";
        }
        if(size == 1){
            return names[0] + " likes this";
        }

        if(size == 2){
            return names[0] + " and " + names[1] + " like this";
        }

        if(size == 3){
            return names[0] + ", " + names[1]+ " and " + names[2] + " like this";
        }

        return names[0] + ", " + names[1]+ " and " + (names.length-2) + " others like this";
    }
}
