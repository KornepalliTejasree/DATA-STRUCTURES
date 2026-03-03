package Comparator;

import java.util.*;

public class MapFrequency {
    public static void main(String[] args) {
        int arr[]={1,2,3,2,2,3,1,1,1,3,4};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        System.out.println(list);
        Collections.sort(list,(a,b)->{
            if(a.getValue()!=b.getValue()){
                return b.getValue()-a.getValue();
            }
            else{
                return b.getKey()-a.getKey();
            }
        }
    );
    for(Map.Entry<Integer,Integer> i:list){
        int num=i.getValue();
        while(num>0){
            System.out.print(i.getKey()+" ");
            num--;
        }
       
    }
    }
}
