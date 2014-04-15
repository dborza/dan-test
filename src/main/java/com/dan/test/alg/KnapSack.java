package com.dan.test.alg;

import java.util.Arrays;

/**
 * Solve the knapsack problem.
 *
 */
public class KnapSack {

    //  Weights of elements
    private static final int [] weightOfItems = new int [] { 3, 5, 7, 10 } ;

    //  Number of items taken for reach element
    private static final int [] numOfItemsTaken = new int [weightOfItems.length];

    //  The max weight that the sack can hold
    private static final int sackMaxW = 13;

    //  The maximum weight that we picked so far
    private static int maxWeightFoundSoFar = Integer.MIN_VALUE;

    private static int [] solution = new int [weightOfItems.length];

    private static void generateMaxSum(int currentWeight) {

        if (currentWeight > sackMaxW) {
            return;
        }

        if (currentWeight > maxWeightFoundSoFar) {
            maxWeightFoundSoFar = currentWeight;
            System.arraycopy(numOfItemsTaken, 0, solution, 0, numOfItemsTaken.length);
        }

        //  Just pick one more item for each element and go further
        for (int i = 0; i < weightOfItems.length; i ++) {
            numOfItemsTaken[i] ++;
            generateMaxSum(currentWeight + weightOfItems[i]);
            numOfItemsTaken[i] --;
        }

    }



    public static void main (String [] args) {

        generateMaxSum(0);

        System.out.println("Max sack weight: " + sackMaxW);
        System.out.println("Weights of each item: " + Arrays.toString(weightOfItems));
        System.out.println("Max found weight: " + maxWeightFoundSoFar);
        System.out.println("Weights for each item: " + Arrays.toString(solution));

    }

}
