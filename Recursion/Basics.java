package Recursion;

public class Basics {
    public static void print(int n){
        if(n==0) return;
        print(n-1);
        System.out.println(n);
    }
    public static int sum(int n,int s){
        if(n==0) return s;
        s=s+n%10;
        return sum(n/10,s);
    }
    public static int count(int n,int count){
        if(n==0) return count;
        if(n%10==0)count++;
        return count(n/10,count);
    }
    public static int reverse(int n,int rev){
        if(n==0) return rev;
        rev=rev*10+n%10;
        return reverse(n/10, rev);
    }
    public static String removeChar(String s,char i,StringBuilder sb){
        if(s.isEmpty())return sb.toString();
        if(i==s.charAt(0)){
           return removeChar(s.substring(1), i,sb);
        }
        else{
            sb.append(s.charAt(0));
            return removeChar(s.substring(1), i, sb);
        }
    }
    public static String replacePi(String s,StringBuilder sb,String pat){
        if(s.isEmpty()) return sb.toString();
        if(s.startsWith(pat)){
            sb.append(3.14);
            return replacePi(s.substring(pat.length()), sb, pat);
        }
        else{
            sb.append(s.charAt(0));
            return replacePi(s.substring(1), sb, pat);
        }
    }
    public static String skipApple(String s,StringBuilder sb){
        if(s.isEmpty()) return sb.toString();
        if(s.startsWith("apple")){
            return skipApple(s.substring(5), sb);
        }
        else{
            sb.append(s.charAt(0));
            return skipApple(s.substring(1), sb);
        }
    }
    public static boolean palindrome(String s,int l,int r){
        if(l>=r)return true;
        if( l<r && s.charAt(l)!=s.charAt(r)){
            return false;
        }
        return palindrome(s, l+1, r-1);
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length) return true;
        if(arr[i-1]>arr[i]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int findItem(int arr[],int i,int target){
        if(i==arr.length) return -1;
        if(arr[i]==target){
            return i;
        }
        return findItem(arr, i+1, target);
    }
    public static void findAllIdices(int[] arr, int i, int target) {
    if (i == arr.length) return;
    if (arr[i] == target) {
        System.out.print(i + " ");
    }
    findAllIdices(arr, i + 1, target);
}
    public static void main(String[] args) {
        int n=5;
        //print(n);
        System.out.println(sum(123, 0));
        System.out.println(count(100, 0));
        System.out.println(reverse(1234, 0));
        System.out.println(removeChar("bcaacd", 'a', new StringBuilder()));
        System.out.println(replacePi("pippppi", new StringBuilder(), "pi"));
        System.out.println(skipApple("aaappleaa", new StringBuilder()));
        System.out.println(palindrome("mam", 0, 2));
        int arr[]={9,2,3,8,3};
        System.out.println(isSorted(arr, 1));
        System.out.println(findItem(arr, 0, 3));
        findAllIdices(arr, 0, 3);
    }
}
