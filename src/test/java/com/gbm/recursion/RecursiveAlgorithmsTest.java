package com.gbm.recursion;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecursiveAlgorithmsTest {

    @Test
    public void testFactorialRecursiveSuccess() {
        var factorialRecursive = new RecursiveAlgorithms();
        assertEquals(new BigInteger("120"), factorialRecursive.factorial(new BigInteger("5")));
    }

    @Test
    public void testFactorialRecursiveReturn1() {
        var factorialRecursive = new RecursiveAlgorithms();
        assertEquals(BigInteger.ONE, factorialRecursive.factorial(new BigInteger("-1")));
    }

    @Test
    public void testFactorialTailRecSuccessSmallNumber() {
        var factorialRecursive = new RecursiveAlgorithms();
        assertEquals(new BigInteger("120"), factorialRecursive.factorialTailRec(new BigInteger("5")));
    }

    @Test
    public void testFactorialTailRecReturn1() {
        var factorialRecursive = new RecursiveAlgorithms();
        assertEquals(BigInteger.ONE, factorialRecursive.factorialTailRec(new BigInteger("-1")));
    }

    @Test
    public void testFactorialTailRecSuccessBigNumber() {
        var factorialRecursive = new RecursiveAlgorithms();
        var big = factorialRecursive.factorialTailRec(new BigInteger("50000"));
        assertNotNull(big);
    }

    @Test
    public void testSumRecursive() {
        var factorialRecursive = new RecursiveAlgorithms();
        var sum = factorialRecursive.sum(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        assertEquals(15, sum);
    }

    @Test
    public void testCountRecursive() {
        var factorialRecursive = new RecursiveAlgorithms();
        var count = factorialRecursive.count(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        assertEquals(5, count);
    }

    @Test
    public void testMaxRecursive() {
        var factorialRecursive = new RecursiveAlgorithms();
        var max = factorialRecursive.max(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        assertEquals(5, max);
    }

}
