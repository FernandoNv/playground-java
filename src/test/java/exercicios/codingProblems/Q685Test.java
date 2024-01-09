package exercicios.codingProblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q685Test {
    private String expected;
    @Test
    void f1() {
        this.expected = "here/world:hello";
        Assertions.assertEquals(this.expected, Q685.f("hello/world:here"));
    }

    @Test
    void f2() {
        this.expected = "here/world:hello/";
        Assertions.assertEquals(this.expected, Q685.f("hello/world:here/"));
    }

    @Test
    void f3() {
        this.expected = "here//world:hello";
        Assertions.assertEquals(this.expected, Q685.f("hello//world:here"));
    }
}