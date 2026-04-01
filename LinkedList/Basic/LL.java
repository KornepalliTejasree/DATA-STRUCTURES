package LinkedList.Basic;

import java.util.*;

public class LL {
    static class Node{
        int data;
        Node next;
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    static class LinkedLists{
       static Node head=null;
        public static void addFirst(int data){
            Node node=new Node(data, null);
            node.next=head;
            head=node;
        }
        public static void addLast(int data){
            if(head==null){
                addFirst(data);
                return;
            }
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            Node node=new Node(data,null);
            temp.next=node;
        }
        public static void addAtSpecificPos(int data,int pos){
            if(pos==0){
                addFirst(data);
                return;
            }
            Node node=new Node(data, null);
            int count=0;
            Node temp=head;
            while(temp!=null && count<pos-1){
                count++;
                temp=temp.next;
            }
            if(temp!=null){
            node.next=temp.next;
            temp.next=node;
            }
        }
        public static void deleteAtFirst(){
            if(head==null){
                System.out.println("List is Empty");
                return;
            }
            head=head.next;
        }
        public static void deleteAtLast(){
            if(head==null){
                System.out.println("List is Empty");
                return;
            }
            Node temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
        public static void deleteAtSPecificPos(int pos){
            if(head==null){
                System.out.println("List is Empty");
                return;
            }
            int count=0;
            Node temp=head;
            if(pos==0){
                deleteAtFirst();
                return;
            }
            while(temp!=null && count<pos-1){
                count++;
                temp=temp.next;
            }
            if(temp==null || temp.next==null){
                System.out.println("Index out of bounds");
                return;
            }
            if(temp!=null){
            temp.next=temp.next.next;
            }

        }
        public static void findMiddleOfLinkedlist(){
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            System.out.println(slow.data);
        }
        public static void reverse(){
            Node currNode=head.next;
            Node prevNode=head;
            while(currNode!=null){
                Node nextNode=currNode.next;
                //update
                currNode.next=prevNode;
                prevNode=currNode;
                currNode=nextNode;
            }
            head.next=null;
            head=prevNode;
        }
       public static boolean detectLoop(){
        if (head==null ||head.next==null) {
            return false;
        }
        Map<Node,Boolean> map=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            if(map.containsKey(temp))return true;
            map.put(temp, true);
            temp=temp.next;
        }
        return false;
       }
        public static void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data);
                if(temp.next!=null)System.out.print("->");
                temp=temp.next;
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        //LinkedLists list=new LinkedLists();
       int arr[]={1,2,3,6,4,1,5};
        for(int i=0;i<arr.length;i++){
            LinkedLists.addFirst(arr[i]);
        }
        LinkedLists.addAtSpecificPos(0, 6);
        LinkedLists.display();
        LinkedLists.deleteAtSPecificPos(6);
        LinkedLists.display();
        LinkedLists.findMiddleOfLinkedlist();
        LinkedLists.reverse();
        LinkedLists.display();
        System.out.println(LinkedLists.detectLoop());
    }
}
