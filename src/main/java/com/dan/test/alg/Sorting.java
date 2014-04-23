package com.dan.test.alg;

import java.util.Arrays;

/**
 * Created by gborza on 23/04/2014.
 */
public class Sorting {

    /**
     * Generic interface for a sorting algorithm.
     */
    private static interface Sorter {

        /**
         * Sort an input array.
         * @param input
         *      The input array.
         * @return
         *      The sorted array (might be or might not be the same reference as the input array).
         */
        int [] sort (int [] input);
    }

    public static void main (String [] args) {

        final int [] input = { 1, 3, -3, 10, 11, 10, -100, 14, 100, 34 };

        final Sorter sorter = new SelectionSorter();

        System.out.println(Arrays.toString(sorter.sort(input)));
    }

    /**
     * Implementation of the Selection Sort algorithm respecting the {@link Sorter} contract.
     */
    private static class SelectionSorter implements Sorter {

        public int[] sort(int[] input) {

            if (input == null) {
                throw new IllegalStateException("Input array is null.");
            }

            for (int i = 0; i < input.length - 1; i ++) {
                int j = i + 1;
                while (j < input.length) {
                    if (input[j] < input[i]) {
                        swap(input, i, j);
                    }
                    j ++;
                }
            }

            return input;
        }

    }

    /**
     * Swap elements i and j of an array.
     *
     * @param arr
     *          The input array.
     * @param i
     *          First element.
     * @param j
     *          Second element.
     */
    private static void swap(int [] arr, int i, int j) {
        final int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
