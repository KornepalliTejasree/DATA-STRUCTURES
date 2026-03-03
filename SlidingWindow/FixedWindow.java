package SlidingWindow;

import java.util.Scanner;

public class FixedWindow {
    public static void main(String[] args) {
        int n=4;
        int arr[]={1,2,3,4};
        System.out.println("Enter size of the window:");
        int k=2;//2
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int left=0;
        int right=k-1;
        int max=0;
        while(right<n-1){
            sum-=arr[left];
            left++;
            right++;
            sum+=arr[right];
            max=Math.max(sum,max);
        }
        System.out.println(max);
    }
}
