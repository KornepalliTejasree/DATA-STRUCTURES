package Recursion;
import java.util.*;
public class PermutationStr {
    public static void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
         char c=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0, i);
            String s=p.substring(i);
            permutations(f+c+s, up.substring(1));
        }
    }
    public static ArrayList<String> permutationList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char c=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i);
            ans.addAll(permutationList(first+c+second, up.substring(1)));
        }
        return ans;
    }

    public static void main(String[] args) {
        permutations("", "abc");
        System.out.println(permutationList("", "abc"));
    }
}
