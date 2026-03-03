package OOPS;
import java.util.*;
 public class BasicProgramming {
    static class Student{
        int sno;
        String name="Arjun";
        int marks;
        String college="Mohan Babu University";
        Student(int sno,String name,int marks){
            this.sno=sno;
            this.name=name;
            this.marks=marks;
        }
        Student(){
            this(12,"lala",90);
        }
        Student(Student other){
            this.name=other.name;
            this.sno=other.sno;
            this.marks=other.marks;
        }
        void greeting(){
            System.out.println("Hello miss/mister "+name);
        }
        @Override
        protected void finalize() throws Throwable {
            // TODO Auto-generated method stub
            System.out.println("Object is destroyed");
        }
    }

    public static void main(String[] args) {
        Student st=new Student(1,"Arjun",65);
       
        Student[] students=new Student[5];
        System.out.println(Arrays.toString(students));
        st.greeting();
        System.out.println(st.marks+" "+st.name+" from "+st.college);
        Student randamPerson=new Student(st);
        System.out.println(randamPerson.name);
        Student lala=new Student();
        System.out.println(lala.name);
        int a=10;
       final int b=20;
       //b=b+2; you cant do this

        swap(a,b);
        System.out.println(a+" "+b);
        Student s1;
        for(int i=1;i<1000000;i++){
            s1=new Student();
        }
    }
    static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a+" "+b);
    }
}
