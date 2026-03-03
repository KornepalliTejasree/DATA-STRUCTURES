package Recursion;
import java.util.*;
public class TowersOfHanoi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        tower(3, "S", "H", "D");
    }
    public static void tower(int n,String src,String help,String dest){
        if(n==1){
           System.out.println("Transfer disk "+n+" from "+src+" "+dest);
            return;
        }
        tower(n-1, src,dest,help);
         System.out.println("Transfer disk "+n+" from "+src+" "+dest);
        tower(n-1, help, src, dest);
       
    }
}
