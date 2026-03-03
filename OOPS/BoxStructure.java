package OOPS;

public class BoxStructure extends Box{
    double weight;
    BoxStructure(){
        this.weight=-1;
    }
    BoxStructure(double l,double w,double b,double weight){
        super(l,w,b);
        this.weight=weight;
        
    }
   static void hell(){
    System.out.println("Welcome to the boxstructure");
   }
    public static void main(String[] args) {
        BoxStructure box=new BoxStructure();
        System.out.println(box.l+" "+box.weight);
        Box b=new BoxStructure(12,32,2,9);//if hell method is present in the boxstructure then that will be executed otherwise 
        //box hell() will be excuted and we cannot access the things that are in boxstructure whereas we can access the things that are in box class.
       b.hell();//i you override a static method it doesn't work and parent class static method is called.You can inherit but you cannot override.
    }
}
