package exercicios.codingProblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question6Test {

    @Test
    public void testBasic() {
        assertFalse(Question6.isPrime(0), "0  is not prime");
        assertFalse(Question6.isPrime(1), "1  is not prime");
        assertTrue(Question6.isPrime(2), "2  is prime");
        assertTrue(Question6.isPrime(73), "73 is prime");
        assertFalse(Question6.isPrime(75), "75 is not prime");
        assertFalse(Question6.isPrime(-1), "-1 is not prime");
    }

    @Test
    public void testPrime() {
        assertTrue(Question6.isPrime(3), "3 is prime");
        assertTrue(Question6.isPrime(5), "5 is prime");
        assertTrue(Question6.isPrime(7), "7 is prime");
        assertTrue(Question6.isPrime(41), "41 is prime");
        assertTrue(Question6.isPrime(5099), "5099 is prime");
    }

    @Test
    public void testNotPrime() {
        assertFalse(Question6.isPrime(4), "4 is not prime");
        assertFalse(Question6.isPrime(6), "6 is not prime");
        assertFalse(Question6.isPrime(8), "8 is not prime");
        assertFalse(Question6.isPrime(9), "9 is not prime");
        assertFalse(Question6.isPrime(45), "45 is not prime");
        assertFalse(Question6.isPrime(-5), "-5 is not prime");
        assertFalse(Question6.isPrime(-8), "-8 is not prime");
        assertFalse(Question6.isPrime(-41), "-41 is not prime");
    }
}