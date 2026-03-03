package BinaryTree;
import java.util.*;
public class InvertTree {
   static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static Node insert(int arr[]){
        if(arr.length==0 || arr[0]==-1){
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        Node node=new Node(arr[0]);
        q.add(node);
        int i=1;
        while(i<arr.length){
            Node curr=q.poll();
            if(i<arr.length && arr[i]!=-1){
                curr.left=new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
            if(i<arr.length && arr[i]!=-1){
                curr.right=new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return node;
    }
    public static void print(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        print(root.left);
        print(root.right);
    }
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    public static void invertTree(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node curr=q.poll();
                l.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            list.add(l);
        }

    }
    public static void invert(Node root){
        if(root==null) return;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        Node root=insert(arr);
        print(root);
        invertTree(root);
       // System.out.println(list);
       ArrayList<Integer> newlist=new ArrayList<>();
       System.out.println(list.size());
       for(int i=0;i<list.size();i++){
        ArrayList<Integer> lists=new ArrayList<>(list.get(i));
      //  System.out.println(lists);
        Collections.reverse(lists);
      
        for(int j=0;j<lists.size();j++){
            newlist.add(lists.get(j));
        }
       }
       System.out.println(newlist);
         int newwarray[]=new int[arr.length];
       for(int i=0;i<newlist.size();i++){
        newwarray[i]=newlist.get(i);
       }
       
       Node newNode=insert(newwarray);
       print(newNode);
       
       list=new ArrayList<>();
       invert(root);
       invertTree(root);
       System.out.println(list);

    }
}
