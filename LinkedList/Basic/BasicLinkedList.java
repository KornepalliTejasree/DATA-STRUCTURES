package LinkedList.Basic;
import java.util.*;
public class BasicLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    public static void addAtFirst(int val){
       Node node=new Node(val);
       node.next=head;
       head=node;
    }
    public static void addAtLast(int val){
        Node node=new Node(val);
        Node temp=head;
        if(head==null){
            head=node;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }
    public static void addAtSpecificPosition(int val,int pos){
        Node temp=head;
        Node node=new Node(val);
        if(pos==0){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            node.next=head;
            head=node;
            return;
        }
        int count=1;
        while(temp!=null && count<pos-1){
            temp=temp.next;
            count++;
        }
        if(temp==null){
            System.out.println("Index out of range");
            return;
        }
        node.next=temp.next;
        temp.next=node;
    }
    public static void deleteAtfirst(){
        if(head==null){
            System.out.println("Oops!! your list is empty");
            System.out.println("Please fill some values");
            return;
        }
        head=head.next;
    }
    public static void deleteAtLast(){
         if(head==null){
            System.out.println("Oops!! your list is empty");
            System.out.println("Please fill some values");
            return;
        }
        Node temp=head;
        if(temp.next==null){
            deleteAtfirst();
            return;
        }
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    public static void deleteAtSpecificPosition(int pos){
        if(head==null){
            System.out.println("Oops!! your list is empty");
            System.out.println("Please fill some values");
            return;
        }
        int count=1;
        Node temp=head;
        if(pos==1){
            deleteAtfirst();
            return;
        }

        while(temp.next.next!=null && count<pos-1){
            count++;
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            System.out.println("Enter a valid position ");
        }
        temp.next=temp.next.next;
    }
    public static void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print("->");
            }
            temp=temp.next;
        }
        System.out.println();
    }
    public static void reverse(){
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BasicLinkedList l=new BasicLinkedList();
        l.addAtLast(20);
        l.addAtFirst(15);
        l.display();
        l.addAtSpecificPosition(10, 1);
        l.display();
        l.deleteAtfirst();
        l.display();
        l.deleteAtLast();
        l.display();
        l.deleteAtSpecificPosition(2);
    }
}
