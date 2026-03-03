package Comparator;

import java.util.ArrayList;
import java.util.*;


class BasicComparator{
    int rollno;
    String name;
    int marks;
    BasicComparator(int rollno,String name,int marks){
        this.rollno=rollno;
        this.name=name;
        this.marks=marks;
    }
}
class Student implements Comparator<BasicComparator>{
    public int compare(BasicComparator a,BasicComparator b){
        //return b.rollno-a.rollno;//descending
        // return b.marks-a.marks // descending
        // return a.name.comapareTo(b.name);ascending
        if(a.name.length()!=b.name.length()){
            return a.name.length()-b.name.length();
        }
        return a.name.compareTo(b.name);
    }
}
class Main{
    public static void main(String[] args) {
        ArrayList<BasicComparator> list=new ArrayList<>();
        list.add(new BasicComparator(1, "teja", 100));
        list.add(new BasicComparator(10, "hema", 80));
        list.add(new BasicComparator(13, "jeja", 60));
        list.add(new BasicComparator(11, "sreeja", 80));
        list.add(new BasicComparator(12, "priya", 85));
        list.add(new BasicComparator(111, "gowtham", 100));
        Collections.sort(list,new Student());
        for(BasicComparator b:list){
            System.out.println(b.rollno+" "+b.name+" "+b.marks);
        }
    }
}