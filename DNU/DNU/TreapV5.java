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

    public Node<E> add(Node<E> localRoot, E item) {
        boolean addReturn = false;
        Random priorityGenerator = new Random();
        int pg = priorityGenerator.nextInt(100);
        if (localRoot == null) {
            // item is not in the tree insert it.
            addReturn = true;
            return new Node<>(item, pg);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    public boolean add2(E key){
        Random priorityGenerator = new Random();
        int pg = priorityGenerator.nextInt(100);
        Node<E> newNode = new Node(key, pg);

        if(root == null){
            this.root=newNode;
            return true;
        }
        Node<E> currentNode = root;
        Node<E> parentNode =null;
        while(true){
            parentNode = currentNode;
            if(key.compareTo(currentNode.data)<0){
                currentNode = currentNode.left;
                if(currentNode==null){
                    parentNode.left = newNode;
                    return true;
                }
            } else {
                currentNode =currentNode.right;
                if(currentNode ==null){
                    parentNode.right = newNode;
                    return true;
                }
            }
        }
    }

    public boolean add(E key){
        //first check if node is in tree
        boolean found = find(key);
        //if found 
        if (found){
            return false;
        }

        //create new node with key as data
        Random priorityGenerator = new Random();
        int temp = priorityGenerator.nextInt(100);
        Node<E> newNode = new Node<E>(key, temp);
        Node<E> currentNode;
        Node<E> parentNode;
        //currentNode = root;
        boolean success =false;
        
        //insert newNode as leaf at position depending on key
        //if root is null add new node
        if (this.root == null){
            //set node to root
        this.root = newNode;
        
        currentNode = root;
        return true;
        }
        //return true;
            //if key is less than root.data
        //currentNode = root;

        currentNode = root;
        parentNode=null;

        while (true){
            parentNode = currentNode;
            if (key.compareTo(currentNode.data) <0){
                //currentNode= currentNode.left;// last
                if(currentNode==null){
                   // currentNode.left = newNode;
                    parentNode.left = newNode;
                    //return true
                }
                 // check if currentNode added
                if (currentNode!=null){
                    //if true
                    success= true;
                    currentNode = currentNode.left;
                    return true;
                    }
                   // break;
            }else if (key.compareTo(currentNode.data)==0){
                success = false;
                break;
            }
             else if(key.compareTo(currentNode.data)>0){
                currentNode = currentNode.right;
                if(currentNode== null){
                    //currentNode.right= newNode;
                    parentNode.right = newNode;
                    //return true

                }
                    //root.right = newNode;
         
                
                //was new node added
                if (currentNode!=null){
                    success = true;
                    currentNode = currentNode.right;
                    return true;
                }
                //leave off at currentNode.right  
            // break;
            }
        }
        return true;

        // if(success ){
        //     //call reheap/ rotate right

        // }
        // if (this.root == null){
        //     //set node to root
        //     this.root = newNode;
        //     return true;
        //     //if key is less than root.data
        // }else if (key.compareTo(this.root.data) <0){
        //     root.left = newNode;
        //     return true;
        //     //if key and root.data are equal
        // } else if (key.compareTo(this.root.data) == 0){
        //     return false;
        // } else if(key.compareTo(this.root.data)>0){
        //     root.right =newNode;
        //     return true;
        // }
        // return false;
        


    } 


    // public boolean add(E key, int priority){


    // }


    

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
    int priority = 10;
    //Treap<Node<Integer>> T = new Treap<>();
    Treap<String> T= new Treap<>();
    //Treap<Node<Integer>> T = new Treap<>();
    int data = 0;
    Node<String> root = new Node<>(data1, priority);
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

    
    //T.add(node1);
    // System.out.println("one" +T.add2(data1));
    // System.out.println(T.add2(data2));
    // System.out.println(T.add2(data3));
    // System.out.println(T.add2(data4));
    // System.out.println(T.add2(data5));
    // System.out.println(T.add2(data6));
    // System.out.println(T.add2(data7));
    // System.out.println(T.toString());
    

    Treap<String> T2 = new Treap<>();
    
    Node<String> showTree = T2.add(root, data2);
    System.out.println(T2.add(showTree, data3));
    T2.add(root, data4);
    T2.add(root, data5);
    T2.add(root, data6);
    Node<String> lastTree = T2.add(root, data7);
    System.out.println(T2.toString());
    //System.out.println(showTree);
    //System.out.println(lastTree);

}

}