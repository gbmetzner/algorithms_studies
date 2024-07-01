package com.gbm.search.dijkstra;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Collections.emptySet;

public class Dijkstra {

    public <T> Set<Node<T>> findPath(Node<T> source, Node<T> target) {

        source.updateWeight(0);

        var visited = new HashSet<Node<T>>();
        var notVisited = new HashSet<Node<T>>();

        notVisited.add(source);

        while (!notVisited.isEmpty()) {

            var lowestWeightNode = getLowestWeight(notVisited);
            notVisited.remove(lowestWeightNode);

            lowestWeightNode.getNeighbors().forEach((key, value) -> {
                if (!visited.contains(key)) {
                    calculateShortestPath(key, value, lowestWeightNode);
                    notVisited.add(key);
                }
            });

            visited.add(lowestWeightNode);
        }


        return visited.stream().filter(target::equals).findFirst().map(Node::getShortestPath).orElse(emptySet());
    }

    private <T> Node<T> getLowestWeight(Set<Node<T>> notVisited) {

        var lowestDistanceNode = new AtomicReference<Node<T>>();
        var lowestWeight = new AtomicInteger(Integer.MAX_VALUE);

        notVisited.forEach(nv ->  {
            var nodeWeight = nv.getWeight();
            if (nodeWeight < lowestWeight.get()) {
                lowestWeight.set(nodeWeight);
                lowestDistanceNode.set(nv);
            }
        });

        return lowestDistanceNode.get();
    }

    private <T> void calculateShortestPath(Node<T> evaluationNode, Integer edgeWeight, Node<T> sourceNode) {

        var pathWeight = sourceNode.getWeight() + edgeWeight;

        if (pathWeight < evaluationNode.getWeight()) {
            evaluationNode.updateWeight(pathWeight);
            Set<Node<T>> shortestPath = new LinkedHashSet<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            shortestPath.add(evaluationNode);
            evaluationNode.setShortestPath(shortestPath);
        }

    }

}
