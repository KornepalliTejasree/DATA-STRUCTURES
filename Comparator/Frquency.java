package Comparator;

import java.util.ArrayList;
import java.util.*;

public class Frquency {
    public static void main(String[] args) {
        int arr[]={1,1,2,2,2,3,3,4};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        //System.out.println(list);
        Collections.sort(list,(a,b)->{
            if(a.getValue()!=b.getValue()){
                return b.getValue()-a.getValue();
            }
            else if(a.getValue()==b.getValue()){
                return b.getKey()-a.getKey();
            }
            return b.getKey()-a.getKey();
        });
        System.out.println(list);
    }
}
