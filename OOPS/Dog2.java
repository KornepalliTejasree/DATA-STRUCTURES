package OOPS;

public class Dog2 extends Dog1 {
    Dog2(){
        super();
    }
    public static void main(String[] args) {
        Dog2 dog=new Dog2();
        System.out.println(dog.sno);
        System.out.println(dog.name);
        System.out.println(dog.age);
        System.out.println(dog.nickName);
      //Multilevel  
    }//Animal
    //  |
    //  ^
    // Dog1
    // |
    // ^
    // Dog2
}
