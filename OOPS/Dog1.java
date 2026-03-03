package OOPS;

public class Dog1 extends Animal{
    String nickName;
    Dog1(int sno,int age,String name,String nickName){
        super(sno,name,age);
        this.nickName=nickName;
    }
    Dog1(){
        super();
        nickName="Balu";
    }
    
    public static void main(String[] args) {
       Dog1 dog= new Dog1();
        System.out.println(dog.age);
        //System.out.println(dog.greeting);
        dog.greeting();//static methods can be inherited but cannot be overriden
    }
}
