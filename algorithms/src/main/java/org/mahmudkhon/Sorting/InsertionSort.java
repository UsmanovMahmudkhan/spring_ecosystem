package org.mahmudkhon.Sorting;


import java.util.Random;
import java.util.random.RandomGenerator;

public class InsertionSort {

    public static void main(String[] args) {
        int arr[]= new Random().ints(100,4,100).toArray();

        for(int i=1;i< arr.length;i++){
            var key=arr[i];
            var left=i-1;

            while(left>=0 && key<arr[left]){
                arr[left+1]=arr[left];
                left--;
            }

            arr[left+1]=key;

        }

        for(int i:arr){
            System.out.print(i+" ");
        }
    }


}
