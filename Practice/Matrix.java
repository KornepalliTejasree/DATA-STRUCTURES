package Practice;
import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
               
            }
        }
       int m=sc.nextInt();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[m][i];
        }
        for(int i=0;i<n;i++){ 
            sum+=arr[i][m];
        }
       System.out.println(sum-arr[n-1][m]);
    }
}
