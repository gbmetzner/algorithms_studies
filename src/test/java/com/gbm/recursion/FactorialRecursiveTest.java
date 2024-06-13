package com.gbm.recursion;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FactorialRecursiveTest {

    @Test
    public void testFactorialRecursiveSuccess() {
        var factorialRecursive = new FactorialRecursive();
        assertEquals(new BigInteger("120"), factorialRecursive.factorial(new BigInteger("5")));
    }

    @Test
    public void testFactorialRecursiveReturn1() {
        var factorialRecursive = new FactorialRecursive();
        assertEquals(BigInteger.ONE, factorialRecursive.factorial(new BigInteger("-1")));
    }

    @Test
    public void testFactorialTailRecSuccessSmallNumber() {
        var factorialRecursive = new FactorialRecursive();
        assertEquals(new BigInteger("120"), factorialRecursive.factorialTailRec(new BigInteger("5")));
    }

    @Test
    public void testFactorialTailRecReturn1() {
        var factorialRecursive = new FactorialRecursive();
        assertEquals(BigInteger.ONE, factorialRecursive.factorialTailRec(new BigInteger("-1")));
    }

    @Test
    public void testFactorialTailRecSuccessBigNumber() {
        var factorialRecursive = new FactorialRecursive();
        var big = factorialRecursive.factorialTailRec(new BigInteger("50000"));
        assertNotNull(big);
    }

}
