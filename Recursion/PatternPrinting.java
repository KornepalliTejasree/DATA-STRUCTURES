package Recursion;

import java.util.Scanner;

public class PatternPrinting {
    public static void print(int n){
    if(n==0)return;
    for(int i=0;i<n;i++){
        System.out.print("*"+" ");
    }
    System.out.println();
    print(n-1);
    }
    public static void print2(int n){
    if(n==0)return;
     print2(n-1);
    for(int i=0;i<n;i++){
        System.out.print("*"+" ");
    }
    System.out.println();
   
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        print(n);
        print2(n);
        sc.close();
    }
}
