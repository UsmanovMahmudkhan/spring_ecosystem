package org.mahmudkhon.Sorting;

import java.util.ArrayList;
import java.util.List;

public class HeapFirstExercise {

    //Input: nums = [5,2,3,1]
    //Output: [1,2,3,5]

    public static void main(String[] args) {
        sort(new ArrayList<>(List.of(5,2,3,1)));

    }
    public static void sort(ArrayList<Integer>arrayList){
        int size=arrayList.size();

        System.out.println(arrayList);

        for(int i=size/2-1;i>=0;i--){
            heapify(arrayList,size,i);
        }

        for(int i=size-1;i>=0;i--){
            int temp=arrayList.get(0);
            arrayList.set(0, arrayList.get(i));
            arrayList.set(i,temp);
            heapify(arrayList,i,0);
        }

        System.out.println(arrayList);
    }

    public static void heapify(ArrayList<Integer>arrayList,int size,int index){

        int largest=index;
        int left=index*2+1;
        int right=index*2+2;

        if(left<size && arrayList.get(left)>arrayList.get(largest)){
            largest=left;
        }

        if(right<size && arrayList.get(right)>arrayList.get(largest)){
            largest=right;
        }

        if(largest!=index){
            int temp=arrayList.get(index);
            arrayList.set(index,arrayList.get(largest));
            arrayList.set(largest,temp);

            heapify(arrayList,size,largest);
        }


    }
}

