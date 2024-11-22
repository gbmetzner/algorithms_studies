package com.gbm.recursion;

import static com.gbm.recursion.RecursiveAlgorithms.TailRec.complete;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public class RecursiveAlgorithms {

	public BigInteger factorial(BigInteger n) {
		if (n.compareTo(BigInteger.TWO) < 0) {
			return BigInteger.ONE;
		}
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}

	// tried to implement his idea (Venkat Subramaniam):
	// https://youtu.be/wM1lyTfyuRo?t=2416
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
		return sumHelper(integerList, 0);
	}

	private Integer sumHelper(List<Integer> integerList, int currentIndex) {
		if (integerList == null || currentIndex == integerList.size()) {
			return 0;
		}
		return integerList.get(currentIndex) + sumHelper(integerList, currentIndex + 1);
	}

	public Integer count(List<Integer> integerList) {
		return countHelper(integerList, 0);
	}

	private Integer countHelper(List<Integer> integerList, int currentIndex) {
		if (integerList == null || currentIndex == integerList.size()) {
			return 0;
		}
		return 1 + countHelper(integerList, currentIndex + 1);
	}

	public Integer max(List<Integer> integerList) {
		return maxHelper(integerList, 0, integerList.get(0));
	}

	private Integer maxHelper(List<Integer> integerList, int currentIndex, int currentMax) {
		if (currentIndex == integerList.size()) {
			return currentMax;
		}
		return maxHelper(integerList, currentIndex + 1, Math.max(currentMax, integerList.get(currentIndex)));
	}

	// tried to implement his idea (Venkat Subramaniam):
	// https://youtu.be/wM1lyTfyuRo?t=2416
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
			return Stream.iterate(this, TailRec::next).filter(TailRec::isComplete).findFirst().orElseThrow().result();
		}
	}
}
