package org.mahmudkhon.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapPractice {
    public static void main(String[] args) {


        ArrayList<Integer>arrayList=new ArrayList<>();
        arrayList.add(50);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(35);

        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(left(2)));

        insert(arrayList,47);

        System.out.println(arrayList);
    }


    public static int left(int index){
        return index*2+1;
    }

    public static int right(int index){
        return index*2+2;
    }

    public static int parent(int index){
        return (index-1)/2;
    }

    public static void insert(ArrayList<Integer>arrayList,int number){
        arrayList.add(number);
        int i=arrayList.size()-1;

        while(i>0){
            int parent=(i-1)/2;

            if(arrayList.get(parent)>arrayList.get(i)){
                return;
            }
            int temp=arrayList.get(parent);
            arrayList.set(parent,arrayList.get(i));
            arrayList.set(i,temp);

            i=parent;
        }
    }

}
