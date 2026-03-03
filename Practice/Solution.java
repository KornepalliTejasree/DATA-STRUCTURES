package Practice;
import java.util.*;
class Solution {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String s="";
        char c[]=licensePlate.toCharArray();
        String maxMatch="";
        int minLength=Integer.MAX_VALUE;
        Arrays.sort(c);
        for(char i:c){
            if(Character.isLetter(i))s+=i;
        }
        s=s.toLowerCase();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<words.length;i++){
            int count=0;
            boolean vis1[]=new boolean[words[i].length()];
            boolean vis2[]=new boolean[s.length()];
            for(int j=0;j<s.length();j++){
           int n=0;
           while(n<words[i].length()){
            if(s.charAt(j)==words[i].charAt(n) && vis1[n]==false){
                vis2[j]=true;
                vis1[n]=true;
                break;
            }
            n++;
           }
            }
            for(boolean bool:vis2){
                if(bool==true)count++;
            }
           if(max<count){
            if(minLength>words[i].length()){
                max=count;
                minLength=words[i].length();
                maxMatch=words[i];
            }
            else{
                max=count;
                maxMatch=words[i];
                minLength=words[i].length();
            }
           }
           if(max==count){
            if(minLength>words[i].length()){
                max=count;
                minLength=words[i].length();
                maxMatch=words[i];
                return maxMatch;
            }
            else{
                max=count;
                maxMatch=words[i];
                minLength=words[i].length();
            }
           }
        }
       return maxMatch;
    }
    public static void main(String[] args) {
        String words[]={"looks","pest","stew","show"};
        String lice="1s3 456";
        System.out.println(shortestCompletingWord(lice, words));
    }
}