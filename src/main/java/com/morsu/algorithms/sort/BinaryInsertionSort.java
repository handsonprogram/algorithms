package com.morsu.algorithms.sort;

import com.morsu.algorithms.search.BinarySearch;

import java.util.Arrays;

public class BinaryInsertionSort {

    public static void sort(int[] array) {


        for ( int i = 1; i < array.length; i++) {
            int x = array[i];
            int j = Math.abs(BinarySearch.search(array, x,0, i) +1);
            System.arraycopy(array,j,array,j+1,i-j);
            array[j] = x;
        }
    }

    public static void main(String[] args) {
        int[] array = {37,23,0,17,12,72,31,46,100,88,54};
        BinaryInsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
