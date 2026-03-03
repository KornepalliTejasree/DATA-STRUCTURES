package  Practice;



public class TransposeAMatrix {
    public static void main(String[] args) {
        int arr[][]={{1,2},{3,4}};
        int arr1[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr1[i][j]=arr[j][i];
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
               System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
     
      reverse(arr1);
       System.out.println("After ");
      for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
               System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void reverse(int arr[][]){
        
      for(int i=0;i<arr.length;i++){
        int left=0;int right=arr.length-1;
        while(left<right){
            int temp=arr[i][left];
            arr[i][left]=arr[i][right];
            arr[i][right]=temp;
            left++;
            right--;
        }
      }
        
    }
}
