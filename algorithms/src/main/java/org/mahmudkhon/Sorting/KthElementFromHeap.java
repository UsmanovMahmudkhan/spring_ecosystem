package org.mahmudkhon.Sorting;

import java.util.ArrayList;
import java.util.List;

public class KthElementFromHeap {

    //Given an integer array nums and an integer k, return the k largest elements in descending order
    //Input:
    //nums = [3,2,1,5,6,4]
    //k = 2
    //
    //Output:
    //[6,5]

    public static void main(String[] args) {
       sort(new ArrayList<>(List.of(7,10,4,3,20,15)),3);
    }

    public static void sort(ArrayList<Integer>arrayList, int k){
        int size=arrayList.size();
        for(int i=size/2-1;i>=0;i--){
            heapify(arrayList,size,i);
        }

        int heapsize=size-1;

        for(int i = 0; i < k; i++){
            System.out.print(arrayList.get(0)+" ");

            int temp=arrayList.get(0);
            arrayList.set(0,arrayList.get(heapsize));
            arrayList.set(heapsize,temp);

            heapsize--;

            heapify(arrayList,heapsize,0);

        }




//        for(int i=size-1;i>=0;i--) {
//            if(k>0) {
//                System.out.print(arrayList.get(i) + " ");
//                k--;
//            }
//        }
    }

    public static void heapify(ArrayList<Integer>arrayList,int size, int index){
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
