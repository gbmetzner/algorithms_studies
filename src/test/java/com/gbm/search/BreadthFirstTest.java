package com.gbm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadthFirstTest {


    @Test
    public void testBreadthFirstFindValue() {

        var tree = new Tree<>(0);
        tree.addChildren(new Tree<>(1));
        var tree2 = new Tree<>(2);
        tree2.addChildren(new Tree<>(4));
        tree.addChildren(tree2);
        tree.addChildren(new Tree<>(3));

        var breadthFirst = new BreadthFirst();
        var result = breadthFirst.search(4, tree);

        assertTrue(result.isPresent());
        assertEquals(4, result.get());

    }

    @Test
    public void testBreadthFirstDoesntFindValue() {

        var tree = new Tree<>(0);
        tree.addChildren(new Tree<>(1));
        var tree2 = new Tree<>(2);
        tree2.addChildren(new Tree<>(4));
        tree.addChildren(tree2);
        tree.addChildren(new Tree<>(3));

        var breadthFirst = new BreadthFirst();
        var result = breadthFirst.search(5, tree);

        assertTrue(result.isEmpty());

    }

    @Test
    public void testBreadthFirstFindValueNode() {

        var node = new Node<>(0);
        node.addNeighbor(new Node<>(1));
        var node2 = new Node<>(2);
        node2.addNeighbor(new Node<>(4));
        node.addNeighbor(node2);
        node.addNeighbor(new Node<>(3));

        var breadthFirst = new BreadthFirst();
        var result = breadthFirst.search(4, node);

        assertTrue(result.isPresent());
        assertEquals(4, result.get());

    }

    @Test
    public void testBreadthFirstDoesntFindValueNode() {

        var node = new Node<>(0);
        node.addNeighbor(new Node<>(1));
        var node2 = new Node<>(2);
        node2.addNeighbor(new Node<>(4));
        node.addNeighbor(node2);
        node.addNeighbor(new Node<>(3));

        var breadthFirst = new BreadthFirst();
        var result = breadthFirst.search(5, node);
        assertTrue(result.isEmpty());

    }


}
