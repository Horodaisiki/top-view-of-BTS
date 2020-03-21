import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
        Node head=new Node(root.data);
        build(root,head);
        print(head);
    }
    public static void print(Node root){
        while(root.left!=null){
            root=root.left;
        }
        while(root!=null){
            System.out.printf("%d ",root.data);
            root=root.right;
        }
    }
    public static void build(Node root,Node head){
        if(root.left!=null){
            if(head.left==null){
                Node neww=new Node(root.left.data);
                head.left=neww;
                head.left.right=head;
                build(root.left,head.left);
            }else{
                build(root.left,head.left);
            }
        }
        if(root.right!=null){
            if(head.right==null){
                Node neww=new Node(root.right.data);
                head.right=neww;
                head.right.left=head;
                build(root.right,head.right);
            }else{
                build(root.right,head.right);
            }
        }
        
    }
    // public static void queue(Node root,listNode head){
    //     head.list.append(root);
    //     if(root.left!=null){
    //         if(head.left!=null){

    //         }
    //     }
    // }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}