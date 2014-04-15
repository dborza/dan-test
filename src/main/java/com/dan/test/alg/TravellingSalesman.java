package com.dan.test.alg;

import java.util.Arrays;

/**
 * Solve the travelling salesman problem.
 *
 * Created by gborza on 15/04/2014.
 */
public class TravellingSalesman {

    public static void main (String [] args) {
        generatePermutations(0, 4, 0);
        System.out.println("Minimum sum " + minimumSum);
        System.out.println("Minimum permutation " + Arrays.toString(minimumPermutation));
    }

    //  N is the number of elements when we generate the permutations
    private static final int n = 10;

    //  Keep track if element "i" was visited by inspecting the viz[i] value
    private static boolean [] viz = new boolean [n];

    //  Keep track of the element chosen at position "i" in elem[i]
    private static int [] elem = new int [n];

    private static int cost [] [] = new int [] [] {
            {0, 2, 3, 7},
            {2, 0, 4, 1},
            {11, 3, 0, 23},
            {1, 34, 11, 0}
    };

    private static int minimumSum = Integer.MAX_VALUE;

    private static int [] minimumPermutation = new int [n];

    private static void generatePermutations(int currentStep, int lastStep, int accumulatedSum) {

        if (accumulatedSum >= minimumSum) {
            return;
        }

        if (currentStep == lastStep) {
            accumulatedSum += cost[elem[lastStep - 1]][elem[0]];
            if (accumulatedSum < minimumSum) {
                minimumSum = accumulatedSum;
                System.arraycopy(elem, 0, minimumPermutation, 0, elem.length);
            }
            System.out.println(Arrays.toString(elem));
        } else {
            for (int i = 0; i < lastStep; i ++) {
                if (viz[i] == false) {
                    viz[i] = true;
                    elem[currentStep] = i;
                    generatePermutations(currentStep + 1, lastStep,
                            accumulatedSum + (currentStep == 0 ? 0 : cost[elem[currentStep - 1]][i]));
                    viz[i] = false;
                }
            }
        }

    }

}
