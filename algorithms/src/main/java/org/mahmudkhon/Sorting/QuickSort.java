package org.mahmudkhon.Sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    //[4, 2, 6, 1, 3]

    public static void main(String[] args) {
        ArrayList<Integer>arrayList=new ArrayList<>(List.of(4,2,6,1,3));
        sort(arrayList,0,arrayList.size()-1);
        System.out.println(arrayList);
    }

    public static void sort(ArrayList<Integer>arrayList, int low, int high){
        if (low < high) {
            int pivot = pivots(arrayList, low, high);

            sort(arrayList, low, pivot-1);
            sort(arrayList, pivot + 1, high);
        }
    }

    public static int pivots(ArrayList<Integer>arrayList, int low, int high){
        int pivot= arrayList.get(high);
        int j=low;
        int i=j-1;
        for(;j<high;j++){
            if(arrayList.get(j)<pivot){
                i++;
                int temp=arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j,temp);
            }
        }
        i++;
        int temp=arrayList.get(i);
        arrayList.set(i,pivot);
        arrayList.set(high,temp);

        return i;

    }
}
