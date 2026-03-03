package SlidingWindow;
import java.util.*;
public class binn {
    
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:arr){
            list.add(i);
        }
        int sum=0;
        while(list.size()>1){
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<list.size()-1;i++){
             sum=list.get(i)+list.get(i+1);
             l.add(sum%10);
             sum=0;
        }
        System.out.println(l);
        list=l;
        }
        System.out.println(list.get(0));
    }
}
