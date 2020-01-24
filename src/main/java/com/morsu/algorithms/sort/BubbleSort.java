package com.morsu.algorithms.sort;

import java.util.Arrays;

/**
 * O(n*n)
 */
public class BubbleSort {

    public void sort(int[] arr) {
        int lastElement = arr.length - 1;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for ( int i = 0; i < lastElement; i++) {
                if ( arr[i] > arr[i+1] ) {
                    sorted = false;
                    swap(arr, i, i+1);
                }
            }
            lastElement--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] inputArr = {5,3,10,2,60};
        System.out.println(String.format("Input Array: %s",Arrays.toString(inputArr)));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(inputArr);
        System.out.println(String.format("Output sorted Array: %s",Arrays.toString(inputArr)));

    }

}
