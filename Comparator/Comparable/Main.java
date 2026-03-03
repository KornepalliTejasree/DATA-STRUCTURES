package Comparator.Comparable;

public class Main {
    public static void main(String[] args) {
        Student st=new Student(12, 99, "Teja");
        Student st1=new Student(13, 100, "Hema");
        if (st.compareTo(st1)<0) {
            System.out.println("Hema is the topper");
        }
        if(st.name.compareTo(st1.name)<0){
            System.out.println("Teja is smaller");
        }
        else{
            System.out.println("Hema is smaller");
        }
    }
}
