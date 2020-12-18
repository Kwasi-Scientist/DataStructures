//By Kwasi Osae-Kwapong


package Treap;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
//import java.util.ArrayList;



public class Treap<E extends Comparable<E>>{

    private static class Node<E extends Comparable<E>> {
        //data fields
        //key for the search
        
        public E data;
        //random heap priority
        public int priority;
        public Node<E> left;
        public Node<E> right;

        //constructor
        //creates new node with data and priority
        public Node(E data, int priority){
            //creates new node with data
            
            //set data and priority
            this.data = data;
            this.priority = priority;
            this.left = null;
            this.right = null;
            //handle for missing data 
            if (this.data == null){
                throw new NullPointerException(); 
            }
        }
        //Performs right rotation
        //returns reference to root of result 
        public Node<E> rotateRight2(){
            Node<E> n1 = this.left;
            Node<E> n2 = n1.right;
            n1.right = this;
            this.left = n2;
            return n1;
        }
        public Node<E> rotateLeft2(){
            Node<E> n1 = this.right;
            Node<E> n2 = n1.left;
            n1.left = this;
            this.right = n2;
            return n1;
        }
        public Node<E> rotateRight(){
            //init root 
           
            Node<E> root = this; 
            
            //init temp node and set it to root.left
            Node<E>temp = this.left; //q
            //Node<E>temp = root.left;
            //set root.left to value of temp.right
            
            this.left = temp.right; //r
           
            //set temp.right to root
            temp.right = root;
            //set root to temp
            root = temp;


            return root;
        }
        //Performs left rotation
        public Node<E> rotateLeft(){
            //init root
            
            Node<E> root = this;
            //init temp and set to root.right
            Node<E> temp = this.right;
            
            //set root.right to temp.left
            this.right = temp.left;
            //root.right = temp.left;
            //set temp.rigtht to root
            temp.right = root;
            //set root to temp
            root = temp;

            return root;


        }
        //prints (data, priority) pair for a given node
        @Override
        public String toString(){
            return "("+ data.toString() + "," + priority + ")";

        }

    }

    //data fields for treap class
    private Random priorityGenerator;
    private Node<E> root;
    //private ArrayList<Node<E>> order;
    //Constructors
    //creates empty treap and init priorityGenerator
    public Treap(){
        //create empty treap
        this.root = null;
        //init priorityGenerator
        Random priorityGenerator = new Random();

    }

    public Treap(long seed){
        //create empty treap
        this.root=null;
        //init priorityGenerator
        Random priorityGenerator = new Random(seed);
    }



    //adds newNode to treap via key and priority
    //adds to preserve binary search tree 
    public boolean add(E key, int priority){
        Node<E> newNode = new Node(key, priority);
        //init stack to store path
        Stack<Node<E>> path = new Stack<>();

        boolean success= false;

        //if root is null
        if(root == null){
            //set this.root to newNode
            this.root=newNode;
            //add root to stack
            path.push(root);
            return true;
        }
        //set currentNode to root
        Node<E> currentNode = root;
        //set parentnode to null
        Node<E> parentNode =null;
        while(root!=null){
            parentNode = currentNode;
            path.push(parentNode);
            //if key less than currentNode.data
            if(key.compareTo(currentNode.data)<0){
                //move to left subtree
                currentNode = currentNode.left;
                //if left subtree empty
                if(currentNode==null){
                    //add new node 
                    parentNode.left = newNode;
                    //add new Node to stack
                    path.push(parentNode.left);
                    break;
                    
                }
               
                if(currentNode !=null){
                    success = true;
                    //reheap(currentNode, path);
                }
            } else {
                //move to right subtree
                currentNode =currentNode.right;
                if(currentNode ==null){
                    //add newnode
                    parentNode.right = newNode;
                    //add newnode to stack
                    path.push(parentNode.right);
                    break;
                    
                }
                
                if (currentNode != null){
                    success=true;
                    //reheap(currentNode, path);
                }
            }
        }
        System.out.println("path: " + path);
        reheap(newNode, path);
        //balance2(newNode,path);
        


        return true;
    }


    //adds new node to treap based on key value as leaf of treap. New node is assigned random priority.
    public boolean add(E key){
        //init priorityGenerator and new node
        Random priorityGenerator = new Random();
        int pg = priorityGenerator.nextInt(100);
        Node<E> newNode = new Node(key, pg);
        //init stack to store path
        Stack<Node<E>> path = new Stack<>();
        Deque<Node<E>> familyTree = new LinkedList<Node<E>>();

        boolean success= false;

        //if root is null
        if(root == null){
            //set this.root to newNode
            this.root=newNode;
            //add root to stack
            path.push(newNode);
            return true;
        }
        //set currentNode to root
        Node<E> currentNode = root;
        //set parentnode to null
        Node<E> parentNode =null;
        while(root!=null){
            parentNode = currentNode;
            path.push(parentNode);            
            familyTree.add(parentNode);
            //if key less than currentNode.data
            if(key.compareTo(currentNode.data)<0){
                //move to left subtree
                currentNode = currentNode.left;
                //if left subtree empty
                if(currentNode==null){
                    //add new node 
                    parentNode.left = newNode;

                    //add new Node to stack
                    path.push(newNode);
                    familyTree.add(newNode);
                    break;
                
                }
                //just added
                if(currentNode !=null){
                    success = true;
                    path.push(currentNode);
                    //return true;
                }
            } else {
                //move to right subtree
                currentNode =currentNode.right;
                if(currentNode ==null){
                    //add newnode
                    parentNode.right = newNode;
                    //add newnode to stack
                    path.push(newNode);
                    familyTree.add(newNode);
                    break;
                }
                
                if (currentNode != null){
                    success=true;
                    path.push(currentNode);
   
                }
            }

        }

        reheap(newNode, path);

   
 
        return true;
    }

    public Node<E> reheap(Node<E> node, Stack<Node<E>> path){

        while(!path.isEmpty()){
            //childNode
            Node<E> parentNode = path.pop();
            //ParentNode 
            Node<E> childNode = node; //path.pop();
            //compare node to child node
            Node<E> grandParentNode = path.pop();
         //   while(parentNode.priority< childNode.priority){
           //     if (childNode == parentNode.left){
            if (parentNode.priority <childNode.priority && childNode ==parentNode.left){
                
                
                grandParentNode.right= parentNode.rotateRight2();
                
                //parentNode = parentNode.rotateRight2();
                //childNode = parentNode.rotateRight2();
                reheap(grandParentNode, path);
               //parentNode = parentNode.rotateRight2();
            //} else {
                
            

            } else if (parentNode.priority < childNode.priority && childNode ==parentNode.right) {
                //Node<E> grandParentNode = path.pop();
                grandParentNode.left = parentNode.rotateLeft2();
                //childNode = parentNode.rotateLeft2();
                reheap(grandParentNode, path);
               // parentNode =parentNode.rotateLeft2();
            }
        }
    


        return node; 
    }

    // public Node<E> balance2(Node<E> currentNode, Stack<Node<E>> familyTree){
    //     //pop familytree nodes to parent
    //     Node<E> parentNode = familyTree.pop();
    //     //loop as long as parentnode.priority is less than currentNode.priority
    //     while(parentNode.priority<currentNode.priority){
    //         //if currentnode is the left child rotate right
    //         if(parentNode.left == currentNode){
    //             Node<E> temp = parentNode.rotateRight();

    //             if(parentNode == root){
    //                 root = temp;
    //             }

            
    //         //if there are still elements in familyTree
    //         if (!familyTree.isEmpty()){

    //             Node<E> grandParentNode = familyTree.lastElement();

    //             if(grandParentNode.left == parentNode){
    //                 parentNode = familyTree.pop();
    //                 parentNode.left = temp;
    //             } else {
    //                 parentNode =familyTree.pop();
    //                 parentNode.right = temp;
    //             }
    //          } 
    //         }
    //         //if currentNode is right child of parent rotate left
    //         if (parentNode.right == currentNode){
    //             Node<E> temp = currentNode.rotateLeft();

    //             if(parentNode == root){
    //                 root = temp;
    //             }
    //             if (!familyTree.isEmpty()){

    //                 Node<E> grandParentNode = familyTree.lastElement();
    
    //                 if(grandParentNode.right == parentNode){
    //                     parentNode = familyTree.pop();
    //                     parentNode.right = temp;
    //                 } else {
    //                     parentNode =familyTree.pop();
    //                     parentNode.left = temp;
    //                 }

    //         }
    //         }
    //     }
    //     return currentNode;
    // }



    // public Node<E> balance(Node<E> node,Stack<Node<E>> familyTree){
    //     //traverse through the tree
    //     //Node<E> currentNode = root;
    //         //move left
    //         //currentNode = currentNode.left;

    //     while(!familyTree.isEmpty()){
    //         Node<E> root = familyTree.pop();

    //     //check if root not null
    //     if (root == null){
    //         //there is nothing to balance
    //         return null; 
    //     }

        
    //     //compare priority
    //     //compare data of parent to the children
    //     //if left child and data is greater than parent data 
    //     //use a stack to keep track of parents and grandparents
    //     //after
    //     if (root.left!=null) {
    //         if (root.priority < root.left.priority){
    //             root.rotateRight();
    //             //call balance on left
    //        // balance(root.left);
    //     }
    // } else if (root.right!=null){
    //     if (root.priority > root.right.priority){
    //         root.rotateLeft();
    //             //call balance on right
    //        // balance(root.right);
    //     }
    //  } 
    // }
    
    //     return root;
    // }



    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    //Delete helper function that calls delete(Node<E> localRoot, E item)
    //returns ull
    public E delete(E key) {
        root = delete(root, key);
        return null;
    }
    //deletes target item from treap if found
    private Node<E> delete(Node<E> localRoot, E item) {
        E deleteReturn= null;
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }


    //find helper function that calls find(Node<E> root, E key) recursive function
    public boolean find(E key){
        return find(root, key);
    }
    //finds target key if in treap
    private boolean find(Node<E> root, E key){
        //if key not found
        if (root == null){
            return false;
        }
        //compare key with data field at root
        int compResult = key.compareTo(root.data);
        //if key found
        if (compResult ==0){
            return true;
            //check left subtree
        } else if (compResult <0){
            return find(root.left, key);
            //check right subtree
        } else {
            return find(root.right, key);
        }
    }
    //carries out a Preorder traversal 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    //PreOrder Traverse: root, TL, TR
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
        for (int i= 1; i < depth; i++){
            sb.append("   ");
        }
        if (node == null){
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth+1, sb);
            preOrderTraverse(node.right, depth+1, sb);
        }
    }



public static void main(String[] args){
    System.out.println("Hello, World!");
    String data1 = "T";
    int priority = 10;
    //Treap<Node<Integer>> T = new Treap<>();
    Treap<String> T= new Treap<>();
    //Treap<Node<Integer>> T = new Treap<>();
    int data = 0;
    Node<String> root = new Node<>(data1, priority);
    Treap<String> unbalanced = new Treap<>();



    String data2 = "q";
    String data3 ="u";
    String data4= "a";
    String data5 = "r";
    String data6 = "z";
    String data7 = "h";
    
    int data8= 8;
    int data9 = 9;
    int data10=10;
    int data11 =11;
    int data12 =12;
    int data13=13;

    //unbalanced treap
    // unbalanced.add("t", 8);
    // unbalanced.add("q", 9);
    // unbalanced.add("a", 2);
    // unbalanced.add("r", 0);
    // unbalanced.add("u", 7);
    // // unbalanced.add("x", 4);
    // // unbalanced.add("b", 3);
    // // unbalanced.add("z",1);
    // System.out.println(unbalanced.toString());
    // //System.out.println(balance(unbalanced.root));
    // System.out.println("find"+ unbalanced.find("q"));
    
    Treap<String> T3 = new Treap<>();
    T3.add("p", 99);
    T3.add("g",80);
    T3.add("a",60);
    T3.add("j", 65);
    T3.add("i", 93);
    T3.add("u", 75);
    T3.add("r", 40);
    T3.add("z", 47);
    T3.add("w", 32);
    T3.add("v", 21);
    T3.add("x", 25);
    System.out.println(T3.toString());
    Node<String> i = new Node<String>("i", 93);
    System.out.println(T3.find("i"));
    

    // Treap<String> T2 = new Treap<>();
    // T2.add(data1);
    // T2.add(data2);
    // T2.add(data3);
    // T2.add(data4);
    // T2.add(data5);
    // T2.add(data6);
    // T2.add(data7);
    //System.out.println(T2.toString());
    //T2.delete(data6);
    //System.out.println(T2.toString());

    //System.out.println(showTree);
    //System.out.println(lastTree);

}

}