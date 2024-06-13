package com.gbm.recursion;

import java.math.BigInteger;
import java.util.stream.Stream;

import static com.gbm.recursion.FactorialRecursive.TailRec.complete;

public class FactorialRecursive {

    public BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.TWO) < 0) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    // tried to implement this idea: https://youtu.be/wM1lyTfyuRo?t=2416
    public BigInteger factorialTailRec(BigInteger n) {
        return tailRecFactorial(n, n.subtract(BigInteger.ONE)).process();
    }

    private TailRec<BigInteger> tailRecFactorial(BigInteger f, BigInteger n) {
        if (n.compareTo(BigInteger.ONE) < 0) {
            return () -> complete(BigInteger.ONE);
        }
        if (n.compareTo(BigInteger.ONE) == 0) {
            return () -> complete(f);
        }
        return () -> tailRecFactorial(f.multiply(n), n.subtract(BigInteger.ONE));
    }

    @FunctionalInterface
    interface TailRec<T> {

        static <T> TailRec<T> complete(T value) {
            return new TailRec<T>() {

                @Override
                public TailRec<T> next() {
                    throw new UnsupportedOperationException("Next should never be called when completed");
                }

                @Override
                public T result() {
                    return value;
                }
            };
        }

        TailRec<T> next();

        default boolean isComplete() {
            return result() != null;
        }

        default T result() {
            return null;
        }

        default T process() {
            return Stream.iterate(this, TailRec::next)
                    .filter(TailRec::isComplete)
                    .findFirst().orElseThrow()
                    .result();
        }
    }
}
