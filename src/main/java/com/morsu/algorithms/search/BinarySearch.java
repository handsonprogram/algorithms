package com.morsu.algorithms.search;

public class BinarySearch {
    public static int search(int[] array, int x) {
        return search(array, x, 0, array.length);
    }

    public static int search(int[] array, int key, int fromIndex, int toIndex) {

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = array[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};

        int result = BinarySearch.search(input,7);

        System.out.println(result);
    }
}
