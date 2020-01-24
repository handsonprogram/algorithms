package com.morsu.algorithms.sort;

import java.util.Arrays;

/**
 * Average case: O(n log n)
 * Worst case O(n2)
 */
public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);

        sort(array, left, index-1);
        sort(array, index, right);
    }

    private int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while(array[right] > pivot) {
                right--;
            }

            if ( left <=right ) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] inputArray = {5,2,10,11,3,7,4,3};

        System.out.println(String.format("Input Array is: %s", Arrays.toString(inputArray)));
        QuickSort quickSort  = new QuickSort();
        quickSort.sort(inputArray);
        System.out.println(String.format("Sorted Array is: %s", Arrays.toString(inputArray)));


    }
}
