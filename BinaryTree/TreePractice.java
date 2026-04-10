package BinaryTree;
import java.util.*;
class TreePractice{
 static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
 }
 public static Node buildTree(int arr[]){
   if(arr.length==0 || arr[0]==-1){
    return null;
   }
   Queue<Node> q=new LinkedList<>();
   Node node=new Node(arr[0]);
   q.add(node);
   int i=1;
   while(i<arr.length){
    Node curr=q.poll();
    if(arr.length>i && arr[i]!=-1){
        curr.left=new Node(arr[i]);
        q.add(curr.left);
    }
    i++;
    if(arr.length>i && arr[i]!=-1){
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
        return ;
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
public static void levelOrder(Node root){
    if(root==null){
        return;
    }
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            Node curr=q.poll();
            System.out.print(curr.data+" ");

            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        System.out.println();
    }
}
public static int height(Node root){
    if(root==null){
        return 0;
    }
    int left=height(root.left);
    int right=height(root.right);
    return Math.max(left,right)+1;
}
public static boolean balanced(Node root){
     if(root==null){
        return true;
     }
     int left=height(root.left);
     int right=height(root.right);
     if(Math.abs(left-right)>1){
        return false;
     }
    return balanced(root.left) && balanced(root.right);
}
static int max=0;
public static int diameter(Node root){
    if(root==null){
        return 0;
    }
    int left=height(root.left);
    int right=height(root.right);
    max=Math.max(left+right,max);
    diameter(root.left);
    diameter(root.right);
    return max;
}
public static void main(String[] args) {
    int arr[]={1,2,3,4,5,-1,6};
    Node root=buildTree(arr);
    preorder(root);
    System.out.println();
    inorder(root);
    System.out.println();
    postorder(root);
    System.out.println();
    levelOrder(root);
    System.out.println(height(root));
    System.out.println(balanced(root));
}
}