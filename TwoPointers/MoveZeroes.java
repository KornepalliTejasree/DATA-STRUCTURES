package TwoPointers;
import java.util.*;
public class MoveZeroes {
    public static void main(String[] args) {
        int left=0;
        int right=0;
        int arr[]={1,0,2,0,3,2,2,0,0,6,0,0,1,2};
        while(right<arr.length){
            if(arr[right]!=0){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
            }
            right++;
           
        }
        System.out.println(Arrays.toString(arr));
    }
}
