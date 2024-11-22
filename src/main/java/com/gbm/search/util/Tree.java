package com.gbm.search.util;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

	private final T value;
	private final List<Tree<T>> children;

	public Tree(T value) {
		this.value = value;
		this.children = new ArrayList<>();
	}

	public void addChildren(Tree<T> node) {
		this.children.add(node);
	}

	public List<Tree<T>> getChildren() {
		return this.children;
	}

	public T getValue() {
		return value;
	}
}
