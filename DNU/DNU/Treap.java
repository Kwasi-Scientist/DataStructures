
import java.util.Random;



public class Treap<E>{

    private static class Node<E> {
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
            Node<E> newNode = new Node<E>(data, priority);
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
        public Node<E> rotateRight(){

        }
        //Performs left rotation
        public Node<E> rotateLeft(){

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

    //methods
    //inserts given element on to treap
    public boolean add(E key){
        //create new node with key as data
        Random priorityGenerator = new Random();


        Node<E> newNode = new Node<E>(key, 1);
        //if key in treap return false
        //if tree is empty/root is null return false
        if(this.root==null){
            return false;
            // if root.data equals key return root.data
        } else if (this.root.data == key){
            return false;
            //if key is less than target.data search left subtree
        } else if (key < root.left.data){
            //else search right subtree
        } else {

        }

    }

    private boolean find(Node<E> root, E key){
        

    }

    
}