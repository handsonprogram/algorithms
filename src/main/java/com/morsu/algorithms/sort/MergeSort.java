package com.morsu.algorithms.sort;

import java.util.Arrays;

/**
 * Time -> o(n log n) worse case
 * Space -> o(n)
 */
public class MergeSort {
    public static void sort(int[] array) {
        sort(array, new int[array.length], 0, array.length-1);
    }

    private static void sort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) /2;
        sort(array, temp, leftStart, middle);
        sort(array, temp,middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart)/2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    public static void main(String[] args) {
        int[] input = {10,6,5,2,1,11,50, 45, 22};

        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
