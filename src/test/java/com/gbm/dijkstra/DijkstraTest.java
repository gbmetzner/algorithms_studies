package com.gbm.dijkstra;

import com.gbm.search.dijkstra.Dijkstra;
import com.gbm.search.dijkstra.Node;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DijkstraTest {

    @Test
    public void testDijkstraHappyPath() {

        var book = new Node<>("Book");
        var poster = new Node<>("Poster");
        var lp = new Node<>("LP");
        var drums = new Node<>("Drums");
        var guitar = new Node<>("Guitar");
        var piano = new Node<>("Piano");

        book.addNeighbor(poster, 0);
        book.addNeighbor(lp, 5);

        poster.addNeighbor(drums, 35);
        poster.addNeighbor(guitar, 30);

        lp.addNeighbor(guitar, 15);
        lp.addNeighbor(drums, 20);

        drums.addNeighbor(piano, 10);

        guitar.addNeighbor(piano, 20);

        var dijkstra = new Dijkstra();

        var shortestPath = dijkstra.findPath(book, piano);
        var set = new LinkedHashSet<Node<String>>();

        set.add(new Node<>("Book", 0));
        set.add(new Node<>("LP", 5));
        set.add(new Node<>("Drums", 25));
        set.add(new Node<>("Piano", 35));

        assertTrue(set.size() == shortestPath.size() && set.containsAll(shortestPath) && shortestPath.containsAll(set));
    }

}
