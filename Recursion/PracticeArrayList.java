package  Recursion;
import java.util.*;
public class PracticeArrayList{
        //Return all numbers from 1 to N
    public static ArrayList<Integer> allNumbersFrom1Ton(int n,ArrayList<Integer> list,int i){
        if(n+1==i){
            return list;
        }
        list.add(i);
        return allNumbersFrom1Ton(n, list,i+1);
    }
    public static ArrayList<Integer> returnDigits(int n,ArrayList<Integer> list){
        if(n==0) return list;
        
        returnDigits(n/10, list);
        list.add(n%10);
        return list;
    }
    public static ArrayList<Integer> returnEvenDigits(int arr[],ArrayList<Integer> list,int index){
        if(index==arr.length){
            return list;
        }
        if(arr[index]%2==0){
            list.add(arr[index]);
        }
       return returnEvenDigits(arr, list,index+1);
    }
    public static ArrayList<Character> returnAllCharacters(String s,ArrayList<Character> list,int i){
        if(i==s.length()){
            return list;
        }
        list.add(s.charAt(i));
       return returnAllCharacters(s, list, i+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(allNumbersFrom1Ton(n, new ArrayList<>(),1));
        System.out.println(returnDigits(n, new ArrayList<>()));
        int arr[]={1,2,3,4,5,6};
        System.out.println(returnEvenDigits(arr,new ArrayList<>(), 0));
        System.out.println(returnAllCharacters("abcd", new ArrayList<>(), 0));
        sc.close();
    }
}