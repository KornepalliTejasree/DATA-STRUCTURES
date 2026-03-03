package BinarySearchTree;

public class Deletions {
    class Node{
        int val;
        Node left;
        Node right;
        Node(int v){
            this.val=v;
        }
    }
    public Node insert(Node node,int val){
        if(node==null){
            return new Node(val);
        }
        if(node.val<val){
            node.right=insert(node.right, val);
        }
        else{
            node.left=insert(node.left, val);
        }
        return node;
    }
    public static void delete0Childs(Node root,int target){
        if(root==null){
            return;
        }
       if(root.val>target){
            if(root.left.val==target) root.left=null;
            else delete0Childs(root.left, target);
       }
       else{
            if(root.right.val==target) root.right=null;
            else delete0Childs(root.right, target);
       }
    }
    public static void delete1childs(Node root,int target){
        if(root==null) return;
        if(root.val>target){
            if(root.left != null && root.left.val==target){
                if(root.left.right==null && root.left.left==null){
                    root.left=null;
                }
                else if(root.left.left==null || root.left.right==null){
                        if(root.left.left==null){
                            root.left=root.left.right;
                        }
                        else{
                            root.left=root.left.left;
                        }
                }

        }
        else{
            delete1childs(root.left, target);
        }
    }
    else{
         if(root.right != null && root.right.val==target){
                if(root.right.right==null && root.right.left==null){
                    root.right=null;
                }
                else if(root.right.left==null || root.right.right==null){
                        if(root.right.left==null){
                            root.right=root.right.right;
                        }
                        else{
                            root.right=root.right.left;
                        }
                }

        }
        else{
            delete1childs(root.right, target);
        } 
      
    }
    }
    public static void delete2childs(Node root,int target){
        if(root==null) return;
        if(root.val>target){

        }
    }
    public static void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        display(root.right);
         System.out.print(root.val);
    }
    public static void main(String[] args) {
        int arr[]={10,5,15,7};
        Deletions d=new Deletions();
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=d.insert(root,arr[i]);
        }
        display(root);
        System.out.println();
     
        delete1childs(root,5);
           display(root);
    }
}
