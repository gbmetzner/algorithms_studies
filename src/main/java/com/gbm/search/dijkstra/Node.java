package com.gbm.search.dijkstra;

import java.util.*;

public class Node<T> {

    private final T value;
    private final Map<Node<T>, Integer> neighbors = new HashMap<>();
    private Integer weight = Integer.MAX_VALUE;
    private Set<Node<T>> shortestPath = new LinkedHashSet<>();

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Integer weight) {
        this.value = value;
        this.weight = weight;
    }

    public void updateWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void addNeighbor(Node<T> neighbor, Integer weight) {
        this.neighbors.put(neighbor, weight);
    }

    public Map<Node<T>, Integer> getNeighbors() {
        return neighbors;
    }

    public Set<Node<T>> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(Set<Node<T>> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", weight=" + weight + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
