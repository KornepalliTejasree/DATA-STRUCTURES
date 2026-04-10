package Recursion;
class Example{
    public static void hello(int val){
        if(val==0){
            return;
        }
        System.out.println("hello");
        hello(val-1);
    }
    public static void main(String[] args) {
        hello(2);
    }
}