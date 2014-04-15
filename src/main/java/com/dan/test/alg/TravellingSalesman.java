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

    //  Keep track if element "i" was visited by inspecting the picked[i] value
    private static boolean [] picked = new boolean [n];

    //  Keep track of the element chosen at position "i" in permutation[i]
    private static int [] permutation = new int [n];

    private static int cost [] [] = new int [] [] {
            {0, 2, 3, 7},
            {2, 0, 4, 1},
            {11, 3, 0, 23},
            {1, 34, 11, 0}
    };

    //  Track the minimum sum of the permutations
    private static int minimumSum = Integer.MAX_VALUE;

    //  Track the minimum permutation
    private static int [] minimumPermutation = new int [n];

    private static void generatePermutations(int currentStep, int lastStep, int accumulatedSum) {

        if (accumulatedSum >= minimumSum) {
            return;
        }

        if (currentStep == lastStep) {
            accumulatedSum += cost[permutation[lastStep - 1]][permutation[0]];
            if (accumulatedSum < minimumSum) {
                minimumSum = accumulatedSum;
                System.arraycopy(permutation, 0, minimumPermutation, 0, permutation.length);
            }
            System.out.println(Arrays.toString(permutation));
        } else {
            for (int i = 0; i < lastStep; i ++) {
                if (picked[i] == false) {
                    int travelCost = currentStep == 0 ? 0 : cost[permutation[currentStep - 1]][i];
                    if (travelCost >= 0) {
                        picked[i] = true;
                        permutation[currentStep] = i;
                        generatePermutations(currentStep + 1, lastStep, accumulatedSum + travelCost);
                        picked[i] = false;
                    }
                }
            }
        }

    }

}
