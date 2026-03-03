package Recursion;
import java.util.*;
public class NextPermutation {
    public static void permute(int arr[]){
        int j=-1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                j=i;
                break;
            }
        }
        if(j==-1) {
            Arrays.sort(arr);
            return;
        }
        int subIndex=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[j]){
                subIndex=i;
                break;
            }
        }
        swap(arr,subIndex,j);
        reverse(arr,j+1,arr.length-1);

    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void reverse(int arr[],int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    } 
    public static void main(String[] args) {
        int arr[]={2,1,5,4,3,0,0,0};
        permute(arr);
        System.out.println(Arrays.toString(arr));
    }
}
