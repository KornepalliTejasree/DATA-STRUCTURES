package Recursion;

import java.util.ArrayList;

public class binaryPermutes {
    public static void main(String[] args) {
        String arr[]={"011","101"};
        ArrayList<String> list=new ArrayList<>();
        for(String i:arr){
            list.add(i);
        }
        int n=arr[0].length();
       System.out.println( generateAllStrings(n, list,""));
    }
    public static String generateAllStrings(int n,ArrayList<String> list,String p){
        if(n==0 ){
            if(!list.contains(p)){
            return p;
            }
            return "";
        }
       String left= generateAllStrings(n-1, list, p+"0");
       if(!left.equals("")){
        return left;
       }
        String right=generateAllStrings(n-1, list, p+"1");
        if(!right.equals("")){
            return right;
        }
       return "";
    }
}
