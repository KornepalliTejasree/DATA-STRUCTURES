package TwoPointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[]={1,1,2,3,3,4,4,5,5};
        int left=0;
        int right=1;
        while(right<arr.length){
            if(arr[left]!=arr[right]){
                System.out.println(arr[left]);
                left=right;
                
            }
            right++;
        }
        System.out.println(arr[left]);
        //array changing
        System.out.println("Array changing");
        left=0;
        right=1;
        while(right<arr.length){
            if(arr[left]!=arr[right]){
                left++;
                arr[left]=arr[right];
                
            }
            right++;
        }
        for(int i = 0; i <= left; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
