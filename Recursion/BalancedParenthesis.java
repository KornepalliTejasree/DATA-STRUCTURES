package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        generate("", n*2);
        System.out.println("chatgpt");
        generate("", 0, 0, n);
    }
    public static void generate(String p,int n){
        if(n==0){
            if(isBalanced(p)){
                System.out.println(p);
            }
            return;
        }
        generate(p+"(", n-1);
        generate(p+")", n-1);
    } 
    public static boolean isBalanced(String p){
        if(p.isEmpty())return true;
        Stack<Character> st=new Stack<>();
        char c[]=p.toCharArray();
        for(char i:c){
            if(i=='('){
                st.push('(');
            }
            else if(i==')' ){
                if(st.isEmpty())return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }
    static void generate(String p, int open, int close, int n) {
        if (p.length() == 2 * n) {
            System.out.println(p);
            return;
        }

        if (open < n) {
            generate(p + "(", open + 1, close, n);
        }

        if (close < open) {
            generate(p + ")", open, close + 1, n);
        }
    }
}

