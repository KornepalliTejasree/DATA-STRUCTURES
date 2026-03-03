package Arrays;
import java.util.*;
public class Practice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //Rotation
        //Left
        System.out.println("Enter the number of rotations");
        int k=sc.nextInt();
        k=k%n;
        reverse(arr, 0, n-1);
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        reverse(arr, 0, n-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, k-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("sum is");
        System.out.println(sumSubArrays(arr));
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
    //SubArrays
    
    public static int sumSubArrays(int arr[]){
        int maxSum=0;
        for(int i=0;i<arr.length-1;i++){
            int sum=arr[i];
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                maxSum=Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
