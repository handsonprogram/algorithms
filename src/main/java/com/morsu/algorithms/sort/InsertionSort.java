package com.morsu.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j -1;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 10, 12, 1, 5, 6};
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
