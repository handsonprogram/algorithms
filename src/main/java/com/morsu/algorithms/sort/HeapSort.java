package com.morsu.algorithms.sort;

import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] array) {
        int n = array.length;
        // Build heap (rearrange array)
        for ( int i = n/2 -1; i >=0; i--) {
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for (int i = n-1; i >= 0 ; i--) {
            // Move current root to end
            swap(array, 0, i);

            // Call max heapify on the reduced map
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child larger than root
        if ( l < n && array[l] > array[largest]) {
            largest = l;
        }

        // If right child is largest so far
        if ( r < n && array[r] > array[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            swap(array, i, largest);

            // recursively heapify affected sub-tree
            heapify(array, n, largest);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {19,2,3,25,11,10};
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
