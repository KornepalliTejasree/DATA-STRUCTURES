package BinarySearchTree;

public class BasicTree {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(root.data<val){
           root.right= insert(root.right, val);
        }
        else{
           root.left= insert(root.left, val);
        }
        return root;
    }
    public static void display(Node root){
        if(root==null ) return;
       
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
         
    }
    public static void main(String[] args) {
        BasicTree tree=new BasicTree();
        int arr[]={1,2,3,4,5,6};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=tree.insert(root, arr[i]);
        }
        display(root);
        
    }
}
