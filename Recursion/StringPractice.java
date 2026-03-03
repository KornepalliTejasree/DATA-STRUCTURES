package Recursion;
import java.util.*;

public class StringPractice {
    public static String remove(String s,int index,StringBuilder st){
        if(index==s.length()) return st.toString();
        if(s.charAt(index)!='a')st.append(s.charAt(index));
        return remove(s, index+1, st);
    }
    public static String skipString(String s,StringBuilder st,int i,String pattern){
        if(i==s.length()) return st.toString();
        if(pattern.indexOf(s.charAt(i))!=-1){
        }
        else{
            st.append(s.charAt(i));
        }
        return skipString(s, st, i+1, pattern);
    }
    public static String skipApple(String up){
        if(up.isEmpty()) return "";
        if(up.startsWith("apple")) return skipApple(up.substring(5));
        else return up.charAt(0)+skipApple(up.substring(1));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String newStr=remove(s, 0, new StringBuilder());
        System.out.println(newStr);
        String str=skipString(s, new StringBuilder(), 0, "apple");
        String skip=skipApple(s);
        System.out.println("APle:"+skip);
        System.out.println(str);
    }
}
