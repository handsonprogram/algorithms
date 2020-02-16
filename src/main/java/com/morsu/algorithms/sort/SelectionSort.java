package com.morsu.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i <= array.length-2; i++) {
            int minIndex = minimumIndex(array, i+1, array.length-1);
            swap(array, i, minIndex);
        }
    }

    private static int minimumIndex(int[] array, int low, int high) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = low; i <= high; i++) {
            if ( array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {10,6,2,7,8,5};
        SelectionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
