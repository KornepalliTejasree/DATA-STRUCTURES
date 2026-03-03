package TwoPointers;


public class TwoSum {
    public static void main(String[] args) {
        int n=4;
        int arr[]={2,7,11,15};
        int left=0;
        int right=n-1;
        System.out.println("Enter target:");
        int target=9;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                System.out.println("["+left+","+right+"]");
                return;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
    }
}
