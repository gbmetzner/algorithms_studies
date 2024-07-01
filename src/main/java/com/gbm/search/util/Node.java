package com.gbm.search.util;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class Node<T> {

    private final T value;
    private final Set<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbors() {
        return unmodifiableSet(neighbors);
    }

    public void addNeighbor(Node<T> neighbor) {
        if (this == neighbor) {
            throw new IllegalArgumentException("Cannot add itself.");
        }
        neighbor.neighbors.add(this);
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value + "}";
    }
}
