package Recursion;

import java.util.*;

public class SubsetsWithoutRec {
    public static List<List<Integer>> rec(int arr[]){
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            int n=list.size();
        for(int j=0;j<n;j++){
            List<Integer> l=new ArrayList<>(list.get(j));
            l.add(arr[i]);
            list.add(l);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
       
        if (arr.length > 20) {
    throw new IllegalArgumentException("Input too large");
}
 List<List<Integer>> list=rec(arr);
        System.out.println(list);
    }
}
