package Practice;

import java.util.Arrays;

public class Rotation {
    public static void main(String[] args) {
        int arr[]={3,1,2,8};
        int n=arr.length;
        int k=12;
        k=k%n;
        reverse(0, n-1, arr);

        reverse(0, k-1, arr);
       
        reverse(0, n-1, arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int i,int j,int arr[]){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    } 
}
