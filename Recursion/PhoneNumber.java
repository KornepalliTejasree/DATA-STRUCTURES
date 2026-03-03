package Recursion;

import java.util.ArrayList;

public class PhoneNumber {
    public static void pad(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){
            char c=(char)('a'+i);
            pad(p+c,up.substring(1));
        }
    }
    public static ArrayList<String> returnPad(String p,String up){
        if(up.isEmpty()){
           ArrayList<String> list=new ArrayList<>();
           list.add(p);
            return list;
        }
        int digit=up.charAt(0)-'0';
        ArrayList<String> li=new ArrayList<>();
        for(int i=(digit-1)*3;i<digit*3;i++){
            char c=(char)('a'+i);
           li.addAll(returnPad(p+c,up.substring(1)));
        }
        return li;
    }
    public static void main(String[] args) {
        String s="12";
        pad("", s);
        System.out.println(returnPad("", s));
    }
}
