package Practice;

import java.util.Arrays;

public class setZero {
    public static void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    set(matrix,i,j);
                }
            }
        }
    }
    public static void set(int[][] matrix,int i,int j){
        for(int k=0;k<matrix.length;k++){
            for(int l=0;k<matrix[i].length;l++){
                if(k==i || k==j || l==i || l==j){
                    matrix[k][l]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][]  matrix = {
  {1,2,3},
  {4,0,5},
  {6,7,8}
        };
        setZeroes(matrix);
        System.out.println(Arrays.toString(matrix));
       
    }
}
