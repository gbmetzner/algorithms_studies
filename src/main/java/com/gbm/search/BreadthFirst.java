package com.gbm.search;


import com.gbm.search.util.Node;
import com.gbm.search.util.Tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;

public class BreadthFirst {

    public <T> Optional<T> search(T value, Tree<T> root) {

        var queue = new ArrayDeque<Tree<T>>();
        queue.add(root);

        Tree<T> current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.getValue().equals(value)) {
                return Optional.of(value);
            } else {
                queue.addAll(current.getChildren());
            }

        }
        return Optional.empty();
    }

    public <T> Optional<T> search(T value, Node<T> root) {
        var queue = new ArrayDeque<Node<T>>();
        queue.add(root);

        Node<T> current;
        var visited = new HashSet<Node<T>>();

        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.getValue().equals(value)) {
                return Optional.of(current.getValue());
            }
            visited.add(current);
            queue.addAll(current.getNeighbors());
            queue.removeAll(visited);
        }
        return Optional.empty();
    }
}
