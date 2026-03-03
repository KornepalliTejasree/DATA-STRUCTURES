package Comparator.Comparable;

import java.util.*;

public class NewStudent{
    int marks;
    String name;
    NewStudent(int m,String n){
        this.marks=m;
        this.name=n;
    }
    public String toString(){
        return this.name+" ";
    }
    public static void main(String[] args) {
        NewStudent teja=new NewStudent(99, "Teja");
        NewStudent hema=new NewStudent(100, "Hema");
        NewStudent Amma=new NewStudent(98, "Amma");
        NewStudent Nanna=new NewStudent(98, "Nanna");
        NewStudent[] arr={teja,hema,Amma,Nanna};
        Arrays.sort(arr,new Comparator<NewStudent>(){

            @Override
            public int compare(NewStudent o1, NewStudent o2) {
              if(o1.marks!=o2.marks){
                return o1.marks-o2.marks;
              }
              else {
               return o1.name.compareTo(o2.name);
              }
            
            }
            
        });
        System.out.println(Arrays.toString(arr));
    }
}