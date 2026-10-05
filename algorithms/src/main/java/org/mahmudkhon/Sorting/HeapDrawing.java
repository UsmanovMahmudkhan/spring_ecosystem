package org.mahmudkhon.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HeapDrawing {
    public static void main(String[] args) {
        ArrayList<Integer>array=new ArrayList<>(List.of(1,12,9,5,6,10));
        sort(array);
    }

    public static void sort(ArrayList<Integer>array){
        int size=array.size();

        System.out.println(array);

        for(int i=size/2-1;i>=0;i--){
            heapify(array,size,i);
        }

        System.out.println(array);

        for(int i=size-1;i>=0;i--){
            int temp=array.get(0);
            array.set(0, array.get(i));
            array.set(i,temp);

            heapify(array,i,0);
        }

        System.out.println(array);
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
            int temp=arrayList.get(largest);
            arrayList.set(largest,arrayList.get(index));
            arrayList.set(index,temp);

            heapify(arrayList,size,largest);
        }
    }
}