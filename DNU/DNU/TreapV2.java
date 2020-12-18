package Treap;

import java.util.Random;



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
            //Node<E> newNode = new Node<E>(data, priority);
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
        // public Node<E> rotateRight(){


        // }
        //Performs left rotation
        // public Node<E> rotateLeft(){

        // }
        //prints (data, priority) pair for a given node
        @Override
        public String toString(){
            return "("+ data.toString() + "," + priority + ")";

        }

    }

    //data fields for treap class
    private Random priorityGenerator;
    private Node<E> root;

    //Constructors
    //creates empty treap and init priorityGenerator
    public Treap(){
        //create empty treap

        //Node<E> root = new Node<>();
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

    public boolean add(E key){
        Random priorityGenerator = new Random();
        boolean success = add(key, priorityGenerator.nextInt(100));
        return success;

    }

    public boolean add(E key, int priority){
        //first check if node is in tree
        boolean found = find(key);
        //if found 
        if (found){
            return false;
        }

        //create new node with key as data
        Random priorityGenerator = new Random();
        //int temp = priorityGenerator.nextInt(100);
        //Node<E> newNode = new Node<E>(key, temp);
        Node<E> newNode = new Node<E>(key, priority);
        Node<E> tempNode = new Node<E>(key,temp);
        
        //insert newNode as leaf at position depending on key
        //if root is null add new node
        if (this.root == null){
            //set node to root
            this.root = newNode;
            return true;
            //if key is less than root.data
        }else if (key.compareTo(this.root.data) <0){
            // if root.left check children 
            if (root.left){
                while (root.left!= null)
            }
            root.left = add(root.left, key);//newNode;
            return true;
            //if key and root.data are equal
        } else if (key.compareTo(this.root.data) == 0){
            return false;
        } else if(key.compareTo(this.root.data)>0){
            root.right =newNode;
            return true;
        }
        return false;
        


    }

    // public boolean add(E key, int priority){


    // }


    //methods
    //inserts given element on to treap

    public boolean find(E key){
        return find(root, key);
    }

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
    int priority = 1;
    //Treap<Node<Integer>> T = new Treap<>();
    Treap<String> T= new Treap<>();
    //Treap<Node<Integer>> T = new Treap<>();
    //Node<Integer> node1 = new Node<>(data, priority);
    String data2 = "q";
    String data3 ="u";
    String data4= "a";
    String data5 = "r";
    String data6 = "z";
    String data7 = "h";

    
    //T.add(node1);
    System.out.println("one" +T.add(data1));
    System.out.println(T.add(data2));
    System.out.println(T.add(data3));
    System.out.println(T.add(data4));
    System.out.println(T.add(data5));
    System.out.println(T.add(data6));
    System.out.println(T.add(data7));
    System.out.println(T.toString());
    }

}