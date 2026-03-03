package BinaryTree;
import java.util.*;
public class BasicTree {
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
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void InOrder(Node root){
        if(root==null){
            return;
        }
       
        InOrder(root.left);
         System.out.print(root.data+" ");
       InOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){
        if(root==null)return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
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
        if(root==null)return 0 ;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public static boolean balanced(Node root){
        if(root==null) return true;
        int a=height(root.left);
        int b=height(root.right);
        if(Math.abs(a-b)>1){
            return false;
        }
        return balanced(root.left) && balanced(root.right);
    }
   static int max=0;
    public static int diameter(Node root){
        if(root==null) return 0;
        int a=height(root.left);
        int b=height(root.right);
        max=Math.max(a+b,max);
        diameter(root.left);
        diameter(root.right);
        return max;
    }
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root==null){
            return null;
        }
        if(root==p || root==q)return root;
        if(p==null || q==null) return null;
        if(p!=null && q!=null){
            return root;
        }
        return lowestCommonAncestor(root.left, p, q);
    }
    public static void main(String[] args) {
        int arr[]={5,6,3,2,1};
        Node node=buildTree(arr);
        preOrder(node);
        System.out.println();
        levelOrder(node);
        System.out.println(height(node));
        System.out.println(balanced(node));
        System.out.println(diameter(node));
    }
}
