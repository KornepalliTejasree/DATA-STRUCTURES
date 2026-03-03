package OOPS;

public class Animal {
    int sno;
    String name;
    int age;
    Animal(int sno,String name,int age){
        this.sno=sno;
        this.name=name;
        this.age=age;
    }
    Animal(){
        this.sno=1;
        this.name="Rocky";
        this.age=3;
    }
    static void greeting(){
        System.out.println("Hello from Animal class");
    }
}
