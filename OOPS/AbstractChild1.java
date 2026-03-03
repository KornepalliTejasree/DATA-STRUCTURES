package OOPS;

public class AbstractChild1 extends AbstractClass {
    void getAge(){
        System.out.println("12");
    }
    void getName(){
        System.out.println("Teja");
    }
    void greeting(){
        super.greet();
    }
    void childMethod(){
        System.out.println("Child specific method");
    }
    void help(){
        System.out.println("I don't need any help.");
    }
    public static void main(String[] args) {
        AbstractChild1 obj=new AbstractChild1();
        AbstractClass obj1=new AbstractChild1();
        
        obj.childMethod();
        System.out.println(obj1.age);
        System.out.println(obj.age);
        obj.help();
        obj1.help();
        obj.getAge();
        obj.getClass();
        obj.getName();
        System.out.println(obj instanceof AbstractClass);
        System.out.println("From Parent");
        AbstractClass.greet();
        System.out.println("From child super");
        obj.greeting();
    }
}
