package Recursion;

public class ArrayIsSorted {
    public static boolean isSorted(int arr[],int i,int j){
        if(j==arr.length){
            return true;
        }
        return arr[i]<arr[j] && isSorted(arr, i+1, j+1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,3};
        System.out.println(isSorted(arr, 0, 1));
    }
}
