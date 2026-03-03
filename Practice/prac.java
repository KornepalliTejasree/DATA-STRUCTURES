package Practice;

import java.util.ArrayList;
import java.util.Arrays;

public class prac {
    static int counting=0;
    static boolean found=false;
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public static void main(String[] args) {
    String s="baccad";
    skip("", s);
    skipApple("", "djijapplekfoi", "apple");
    subsetsubsequence("", "abc");
    ArrayList<String> l=returnsubsetsubsequence("", "abc");
    System.out.println(l);
    int arr[]={1,2,3};
    withoutRecursionSubsets(arr);
    System.out.println(list);
    permutations("", "1234",9);
    permutationsArray(arr, 0);
    System.out.println("New permutations");
    permu("", "1234");
    }
    public static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        if(c!='a'){
            skip(p+c, up.substring(1));
        }
        else{
            skip(p, up.substring(1));
        }
    }
    public static void skipApple(String p,String up,String pat){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        if(up.startsWith(pat)){
            skipApple(p, up.substring(p.length()), pat);
        }
        else{
            skipApple(p+up.charAt(0), up.substring(1), pat);
        }
    }
    public static void subsetsubsequence(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        subsetsubsequence(p+c, up.substring(1));
        subsetsubsequence(p, up.substring(1));

    }
    public static ArrayList<String> returnsubsetsubsequence(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> l=new ArrayList<>();
            l.add(p);
            return l;
        }
        char c=up.charAt(0);
        ArrayList<String> l1=returnsubsetsubsequence(p+c, up.substring(1));
        ArrayList<String> l2=returnsubsetsubsequence(p, up.substring(1));
        l1.addAll(l2);
        return l1;
    }
    
    public static void withoutRecursionSubsets(int arr[]){
        list.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
           int n=list.size();
            for(int j=0;j<n;j++){
                 ArrayList<Integer> l=new ArrayList<>(list.get(j));
                l.add(arr[i]);
                list.add(l);
            }
        }
    }
   
    public static void permutations(String p,String up,int n){
        if(found)return;
        if(up.isEmpty()){
            counting=counting+1;
            if(n==counting){
                 System.out.println("Required permutaion is: "+p);
                 found=true;
            }
            return ;
        }
        char c=up.charAt(0);
        for(int i=p.length();i>=0;i--){
            String start=p.substring(0,i);
            String end=p.substring(i);
            permutations(start+c+end, up.substring(1),n);
        }
        
    }
    public static void permutationsArray(int arr[],int fi){
        if(fi==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=fi;i<arr.length;i++){
            swap(arr,i,fi);
            permutationsArray(arr, fi+1);
            swap(arr,i,fi);
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void countWays(int n){
        
    }
    public static void permu(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String start=p.substring(0, i);
            String end=p.substring(i);
            permu(start+c+end, up.substring(1));
        }
    }
    
}
