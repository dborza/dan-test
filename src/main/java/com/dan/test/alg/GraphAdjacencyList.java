package com.dan.test.alg;

import java.util.*;

/**
 * Test the graph as an adjacency list data structure.
 * <p/>
 * Created by gborza on 24/04/2014.
 */
public class GraphAdjacencyList {

    /**
     * A vertex in the graph.
     */
    static class Vertex {

        public Vertex(int id) {
            this.id = id;
        }

        /**
         * Id of the node. Should be unique. Won't check for uniqueness for now.
         */
        int id;

        @Override
        public String toString() {
            return "Vertex{" +
                    "id=" + id +
                    '}';
        }
    }

    /**
     * Represent a directed edge in the graph.
     */
    static class Edge {

        Edge(Vertex x, Vertex y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        /**
         * Weight of the edge.
         */
        int w;

        /**
         * First vertex.
         */
        Vertex x;

        /**
         * Second vertex.
         */
        Vertex y;
    }

    static class Graph {

        /**
         * Map between a Vertex and all it's outgoing edges.
         */
        Map<Vertex, List<Edge>> adjacencyList = new HashMap<Vertex, List<Edge>>();

        Graph(Edge... edges) {
            for (Edge e : edges) {
                if (adjacencyList.get(e.x) == null) {
                    adjacencyList.put(e.x, new LinkedList<Edge>());
                }
                adjacencyList.get(e.x).add(e);
            }
        }
    }

    /**
     * Do a Breadth First Search on a {@link Graph} starting with a given {@link Vertex}.
     *
     * @return a {@code List} of {@link Vertex}es processed in the order of bfs.
     */
    static List<Vertex> bfs(Graph g, Vertex start) {

        if (g == null) {
            throw new IllegalArgumentException("Input graph must not be null.");
        }

        final List<Vertex> returnList = new LinkedList<Vertex>();

        final Queue<Vertex> toVisit = new LinkedList<Vertex>();
        toVisit.add(start);

        while (!toVisit.isEmpty()) {

            final Vertex currentVertex = toVisit.remove();

            returnList.add(currentVertex);

            final List<Edge> edges = g.adjacencyList.get(currentVertex);

            if (edges != null) {
                for (final Edge e : edges) {
                    if (!returnList.contains(e.y) && !toVisit.contains(e.y)) {
                        toVisit.add(e.y);
                    }
                }
            }
        }

        //  Start with a node
        //  Iterate through all it's neighbours
        //  Do the thing you want to do on them and put them in the queue

        return returnList;
    }

    public static void main(String[] args) {

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        Edge e1 = new Edge(v1, v2, 1);
        Edge e2 = new Edge(v1, v5, 2);
        Edge e3 = new Edge(v5, v4, 3);
        Edge e4 = new Edge(v4, v3, 4);
        Edge e5 = new Edge(v5, v1, 5);

        Graph g = new Graph(e1, e2, e3, e4, e5);

        System.out.println(bfs(g, v1));
    }


}
