package Stack;
import java.util.*;
public class InfixToPostFix {
    public static String infixtopostfix(String infix){
        String postfix="";
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<infix.length()){
            if(Character.isLetter(infix.charAt(i))){
                postfix+=infix.charAt(i);
               
            }
            else if(infix.charAt(i)=='('){
                st.push(infix.charAt(i));
            }
            else if(infix.charAt(i)==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    postfix+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(infix.charAt(i))<=priority(st.peek())){
                    postfix+=st.pop();
                }
                st.push(infix.charAt(i));
            }
            i++;
        }
        while(!st.isEmpty()){
            postfix+=st.pop();
        }
        return postfix;
    }
    public static int priority(char i){
        
        switch(i){
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            case '^':return 3;
        }
        return 0;
    }
    public static void main(String args[]){
        String s=infixtopostfix("a+b(-b)");
        System.out.println(s);
    }
}
