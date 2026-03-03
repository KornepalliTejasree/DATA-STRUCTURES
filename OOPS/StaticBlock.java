package OOPS;

public class StaticBlock {
    static int a=5;
    static int b;
    static{
        System.out.println("I am inside static block");
        b=a*5;
    }
    //innerclasses
    static class Test{
         String name;
        Test(String name){
            this.name=name;
        }
    }
    public static void main(String[] args) {
        System.out.println(StaticBlock.a);
        System.out.println(b);
        StaticBlock obj=new StaticBlock();
        System.out.println(obj.b);
        b=b+23;
        System.out.println(obj.b);
        Test t1=new Test("Teja");
         System.out.println(t1.name);
        Test t2=new Test("Hema");
        System.out.println(t2.name);
    }
}
