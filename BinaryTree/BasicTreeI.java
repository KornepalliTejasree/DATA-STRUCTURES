 package BinaryTree;
 import java.util.*;
 public class BasicTreeI{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
  public static Node BuildTree(int arr[]){
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
  public static void preorder(Node root){
    if(root==null){
        return;
    }
    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
  }
  public static void inorder(Node root){
    if(root==null){
        return;
    }
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  public static void postorder(Node root){
    if(root==null){
        return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data+" ");
  }
  public static int height(Node root){
    if(root==null){
        return 0;
    }
    return 1+Math.max(height(root.left),height(root.right));
  }
  public static boolean isBalanced(Node root){
    if(root==null){
        return true;
    }
    int left=height(root.left);
    int right=height(root.right);
    if(Math.abs(left-right)>1)return false;
    return true;
  }
  static int max=0;
  public static int diameter(Node root){
    if(root==null){
        return 0;
    }
    int left=height(root.left);
    int right=height(root.right);
    max=Math.max(max,left+right);
    return max;
  }
  public static void main(String args[]){
    max=0;
    int arr[]={1,2,3,4,5,0,-1};
    Node node=BuildTree(arr);
    System.out.println("Inorder");
    inorder(node);
    System.out.println("Preorder");
    preorder(node);
    System.out.println("PostOrder");
    postorder(node);
    System.out.println("Height of the tree: "+height(node));
    System.out.println(isBalanced(node));
    System.out.println("Diameter:"+diameter(node));
  }
}