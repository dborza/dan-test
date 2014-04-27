package com.dan.test.alg;

import java.util.Arrays;

/**
 * Implementation of Dijkstra's algorithm.
 *
 * {@see http://en.wikipedia.org/wiki/Dijkstra's_algorithm}.
 *
 * Created by gborza on 27/04/2014.
 */
public class Dijkstra {

    /**
     * Adjacency matrix of the graph.
     */
    private static int [][] g = {
            {0, 2, 3, 4, 0},
            {5, 0, 2, 3, 4},
            {4, 5, 0, 2, 3},
            {3, 4, 5, 0, 2},
            {2, 3, 4, 5, 0}
    };

    public static void main (String [] args) {

        final int start = 0;

        System.out.println(Arrays.toString(dijk(g, start)));
    }

    /**
     * Apply Dijkstra's algorithm to an input graph starting at a given vertex index.
     *
     * @return An array consisting of the distances between the start vertex and each vertex.
     */
    public static int [] dijk(int [] [] g, int start) {

        //  d[i] is the minimum distance between "start" vertex and "i"
        final int [] d = new int [g.length];

        for (int i = 0; i < d.length; i ++) {
            if (g[start][i] > 0) {
                d[i] = g[start][i];
            } else {
                d[i] = Integer.MAX_VALUE;
            }
        }

        //  For all the nodes
        for (int i = 0; i < d.length - 1; i ++) {
            //  For all their neighbours
            for (int j = 1; j < d.length; j ++) {
                if (g[i][j] > 0) {
                    if (d[i] > d[j] + g[i][j]) {
                        d[i] = d[j] + g[i][j];
                    }
                }
            }
        }

        return d;
    }


}
