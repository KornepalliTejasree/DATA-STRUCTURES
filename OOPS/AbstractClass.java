package OOPS;

abstract class AbstractClass {
    int age=19;
    AbstractClass(){
        System.out.println("I am an Abstract class");
    }
    void help(){
        System.out.println("I will provide help to you.");
    }
    abstract void getName();
    abstract void getAge();
    static void greet(){
        System.out.println("Hello from Parent");
    }
}
