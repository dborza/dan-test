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

        final Sorter sorter = new MergeSort();

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

    private static class MergeSort implements Sorter {

        public int[] sort(int[] input) {

            if (input == null) {
                throw new IllegalStateException("Input array is null. Cannot merge sort.");
            }

            if (input.length == 1) {
                return new int [] { input [0] };
            }

            final int middle = input.length / 2;

            int [] left = copyOf(input, 0, middle - 1);
            int [] right = copyOf(input, middle, input.length - 1);

            return merge(sort(left), sort(right));
        }

        /**
         * Given two sorted input arrays, merged them into a resulting sorted array.
         * @param a
         *          First sorted input array.
         * @param b
         *          Second sorted input array.
         * @return
         *          Resulting sorting array.
         */
        private static int [] merge (int [] a, int [] b) {

            if (a == null || b == null) {
                throw new IllegalStateException("One of the input arrays is null. Cannot merge sort.");
            }

            int [] result = new int [a.length + b.length];

            int ib = 0;
            int ir = 0;

            for (int ia = 0; ia < a.length; ia ++) {
                while (b[ib] <= a[ia]) {
                    result[ir] = b[ib];
                    ir ++;
                    ib ++;
                }
                result[ir] = a[ia];
                ir ++;
                ia ++;
            }

            while (ib < b.length) {
                result[ir] = b[ib];
                ir ++;
                ib ++;
            }

            return result;
        }

        public int [] copyOf(int [] input, int start, int stop) {
            int [] result = new int [stop - start + 1];

            for (int ir = 0; ir < result.length; ir ++) {
                result[ir] = input[start + ir];
            }

            return result;
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
