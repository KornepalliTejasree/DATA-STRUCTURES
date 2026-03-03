package Recursion;
import java.util.*;
public class SumTriangle {
    public static void construct(ArrayList<Integer> list){
        if(list.size()<1)return;
        
        ArrayList<Integer> l=new ArrayList<>();
        int sum=0;
        for(int i=1;i<list.size();i++){
            sum=list.get(i)+list.get(i-1);
            l.add(sum);
            sum=0;
        }
        construct(l);
        System.out.println(list);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:arr){
            list.add(i);
        }
        construct(list);
    }
}
