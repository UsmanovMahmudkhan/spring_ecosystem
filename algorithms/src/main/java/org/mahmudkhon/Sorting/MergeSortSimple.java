package org.mahmudkhon.Sorting;

import java.util.Arrays;

public class MergeSortSimple {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3};

        //sort(numbers);
        int[] sortedNumbers = sort(numbers);

        System.out.println(Arrays.toString(sortedNumbers));
    }

    static int[] sort(int[] numbers) {
        // This is where a one-element array stops.
        // Example: sort([38]) immediately returns [38].
        if (numbers.length <= 1) {
            return numbers;
        }

        int middle = numbers.length / 2;

        // Make two REAL smaller arrays.
        int[] left = Arrays.copyOfRange(numbers, 0, middle);
        int[] right = Arrays.copyOfRange(numbers, middle, numbers.length);

//        System.out.print("left: ");
//        for (int i:left){
//            System.out.print(i+" ");
//        }

//        System.out.print("Right: ");
//        for (int i:right){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        sort(left);
//        sort(right);
        
      //   First finish sorting left. Then finish sorting right.
      //   Finally, merge their returned sorted arrays.
        return  merge(sort(left), sort(right));
    }

    static int[] merge(int[] left, int[] right) {
        // Make a new array that will hold the answer.
        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        // As long as BOTH arrays still have an item, take the smaller one.
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        // Copy anything left over. Only one of these loops will do work.
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }
}
