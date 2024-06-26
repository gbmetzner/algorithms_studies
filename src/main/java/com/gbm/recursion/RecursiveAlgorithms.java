package com.gbm.recursion;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import static com.gbm.recursion.RecursiveAlgorithms.TailRec.complete;

public class RecursiveAlgorithms {

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

    public Integer sum(List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            return 0;
        }
        return integerList.removeFirst() + sum(integerList);
    }

    public Integer count(List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            return 0;
        }
        integerList.removeFirst();
        return 1 + count(integerList);
    }

    public Integer max(List<Integer> integerList) {
        if (integerList.size() == 2) {
            return integerList.get(0) > integerList.get(1) ? integerList.get(0) : integerList.get(1);
        }
        var maybeMax = max(integerList.subList(1, integerList.size()));
        return integerList.get(0) > maybeMax ? integerList.get(0) : maybeMax;
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
