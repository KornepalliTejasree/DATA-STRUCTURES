package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DiceTargets {
    public static void main(String[] args) {
        dice("",4) ;
        ArrayList<String> s=returnDice("", 4);
        System.out.println(s);
    }
    public static void dice(String s,int target){
        if(target==0){
            System.out.println(s);
            return;
        }
        for(int i=1;i<=target && i<=6;i++){
            dice( s+i,target-i);
        }
    }
    public static ArrayList<String> returnDice(String s,int target){
        if(target==0){
            ArrayList<String> l=new ArrayList<>();
            l.add(s);
            return l;
        }
         ArrayList<String> ll=new ArrayList<>();
        for(int i=1;i<=target && i<=6;i++){
            ArrayList<String> list =returnDice( s+i,target-i);
           ll.addAll(list);
        }
        return ll;
    }
}
