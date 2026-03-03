package Recursion;

import java.util.Arrays;

public class RecursionArray {
    static void printpermute(int arr[],int fi){
        if(fi==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=fi;i<arr.length;i++){
            swap(arr,fi,i);
            printpermute(arr, fi+1);
            swap(arr,fi,i);
        }
    }
    static void swap(int arr[],int fi,int i){
        int temp=arr[fi];
        arr[fi]=arr[i];
        arr[i]=temp;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        printpermute(arr, 0);
    }
}
