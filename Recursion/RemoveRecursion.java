package Recursion;

public class RemoveRecursion {
    public static void main(String[] args) {
        remove("abbacdd","");

    }
    public static void remove(String up,String p){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char c=up.charAt(0);
        if(!p.contains(c+""))p+=c;
        remove(up.substring(1), p);
    }
}
