package OOPS.Static;

public class staticEx {
    int a=19;
    void hello(){
        System.out.println("hello");
    }
    static void hi(){
        System.out.println("hi from static method");
    }
    static{//this will get executed right after running the program.
        System.out.println("I'm in static block");
    }
    //static mehtods should only contain the static stuff and if not you need create an object for the class to access the unstatic stuff.
    //Unstatic methods can contain static stuff.
    //you cannot use super() for static stuff.
    //you cannot override static stuff.
    //static blocks will only run once when the first object being created i.e.. when the class is loaded for the very first time.
    //outside classes cannot be static whereas inner classes can be static.
    static class Test{
        static String name;
        Test(String name){
            Test.name=name;
        }
    }
    //  static class Test{
    //      String name;
    //     Test(String name){
    //         this.name=name;
    //     }
    // }
    public static void main(String[] args) {
       // hello();//This method needs an object because it is non-static
        staticEx e=new staticEx();
        staticEx.hi();//static method does not needs an object and can be accessed through the class name.
        System.out.println(e.a);
        Test a=new Test("English");
      //  System.out.println(a.name);
        Test a1=new Test("E");
        System.out.println(a1.name);
        System.out.println(a.name);
    }
}
