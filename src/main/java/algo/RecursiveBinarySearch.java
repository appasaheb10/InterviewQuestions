package algo;

import java.util.Scanner;

// Binary Search in Java

class RecursiveBinarySearch {
    static  int binarySearch(int array[], int element, int low, int high) {

        // Repeat until the pointers low and high meet each other
        if (low <= high) {

            // get index of mid element
            int mid = low + (high - low) / 2;

            // if element to be searched is the mid element
            if (array[mid] == element)
                return mid;

            // if element is less than mid element
            // search only the left side of mid
            if (array[mid] < element)
               return binarySearch(array, element, mid + 1,high);

                // if element is greater than mid element
                // search only the right side of mid
            else
               return binarySearch(array, element, low,mid - 1);
        }

        return -1;
    }

    public static void main(String args[]) {

        int arr[] = {10,20,30,40,50,60,70,80};

        System.out.println(binarySearch(arr,30, 0, arr.length-1));

    }
}