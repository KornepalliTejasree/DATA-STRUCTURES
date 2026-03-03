package Comparator.Comparable;

public class Student implements Comparable<Student> {
    int rollno;
    int marks;
    String name;
    Student(int rollno, int marks,String name){
        this.rollno=rollno;
        this.marks=marks;
        this.name=name;
    }

    @Override
    public int compareTo(Student o ) {
        int diff=(int)this.marks-o.marks;
       return diff;
    }
    
}
