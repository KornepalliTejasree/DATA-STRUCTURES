package Arrays;
import java.util.*;
public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n=4;
        int m=4;
        int srow=0;
        int scol=0;
        int erow=n-1;
        int ecol=n-1;
        ArrayList<Integer> list=new ArrayList<>();
        //top
        while(srow<=erow && scol<=ecol){
        for(int i=scol;i<=ecol;i++){
            list.add(matrix[srow][i]);
        }
        //right
        for(int i=srow+1;i<=erow;i++){
            list.add(matrix[i][ecol]);
        }
        //bottom
        for(int i=ecol-1;i>=scol;i--){
            list.add(matrix[erow][i]);
        }
        //left
        for(int i=erow-1;i>srow;i--){
            list.add(matrix[scol][i]);
        }
        srow++;
        scol++;
        erow--;
        ecol--;
    }
    System.out.println(list);
    }
}
