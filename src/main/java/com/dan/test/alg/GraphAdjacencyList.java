package com.dan.test.alg;

import java.util.*;

/**
 * Test the graph as an adjacency list data structure.
 * <p/>
 * Created by gborza on 24/04/2014.
 */
public class GraphAdjacencyList {

    /**
     * A noVertexde in the graph.
     */
    static class Vertex {

        public Vertex(int v) {
            this.v = v;
        }

        /**
         * Value of the node (Usually not needed. Can be used as an id)
         */
        int v;
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

    public static void main(String[] args) {

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        Edge e1 = new Edge(v1, v2, 1);
        Edge e2 = new Edge(v2, v3, 2);
        Edge e3 = new Edge(v3, v4, 3);
        Edge e4 = new Edge(v4, v5, 4);
        Edge e5 = new Edge(v5, v1, 5);

        Graph g = new Graph(e1, e2, e3, e4, e5);
    }


}
