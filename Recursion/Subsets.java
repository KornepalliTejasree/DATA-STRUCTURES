package Recursion;
import java.util.*;
public class Subsets {
    public static void subset(String process,String unprocessed){
        if(unprocessed.isEmpty()) {
            System.out.println(process);
            return; 
        }
        subset(process+unprocessed.charAt(0), unprocessed.substring(1));
        subset(process, unprocessed.substring(1));
    }
    public static ArrayList<String> subsets(String process,String unprocessed){
        if(unprocessed.isEmpty()) {
           ArrayList<String> l=new ArrayList<>();
           l.add(process);
            return l;
        }
        ArrayList<String> left=subsets(process+unprocessed.charAt(0), unprocessed.substring(1));
        ArrayList<String> right=subsets(process, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }
    
    public static void main(String[] args) {
        String s="abc";
        subset("", s);
        ArrayList<String> l=subsets("", s);
        System.out.println(l);
    }
}
