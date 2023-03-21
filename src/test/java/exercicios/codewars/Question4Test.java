package exercicios.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Question4Test {

    @Test
    void whoLikesIt() {
        Assertions.assertEquals("Alex, Jacob and 2 others like this", Question4.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        Assertions.assertEquals("Max, John and Mark like this", Question4.whoLikesIt("Max", "John", "Mark"));
        Assertions.assertEquals("Peter likes this", Question4.whoLikesIt("Peter"));
        Assertions.assertEquals("Jacob and Alex like this", Question4.whoLikesIt("Jacob", "Alex"));
        Assertions.assertEquals("no one likes this", Question4.whoLikesIt());
    }
}