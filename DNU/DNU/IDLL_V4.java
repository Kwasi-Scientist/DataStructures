
//By Kwasi Osae-Kwapong

import java.util.*;





// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assert.*;


//Questions for office hours
//Creating empty dll through constructor
//for add() how to reference the dll callign add
//for all the methods referencing the dll calling the method

//public class IDLList Test



public class IDLList<E> {


    public static void main (String[] args){
        //instantiate new DLL
        IDLList<String> dll = new IDLList<String>();
        //IDLList<String> dllNoTail = new IDLList<String>();

        //Create nodes
        Node<String> node1 = new Node<String>("Node 1");
        Node<String> node2 = new Node<String>("Node 2");
        Node<String> node3 = new Node<String>("Node 3");
        Node<String> node4 = new Node<String>("Node 4");
        Node<String> node5 = new Node<String>("Node5");
        Node<String> node6 = new Node<String>("JaneWay");
       //StarTrek Voyager Characters
        String JaneWay = "JaneWay";
        String Tuvok = "Tuvok";
        String EnsignKim = "Ensign Kim";
        String Nelix = "Nelix";
        
        //assign head and point nodes to next node
        dll.head = node1;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node4.prev= node4;
        dll.tail = node5;

        

        //instantiate index
        dll.indices = new ArrayList<Node<String>>();
        //Populate indices list with node references
        Node<String> nodeRef = dll.head;
        while (nodeRef !=null){
            dll.indices.add(nodeRef);
            nodeRef = nodeRef.next;
        }
        dll.size = dll.indices.size();
        
        //print dll and indices
        System.out.println("dll: " + dll);
        System.out.println("Dll Size: " + dll.size());

        //testing add(E elem)
        dll.add(JaneWay);
        System.out.println("DLL after add: " + dll);
        System.out.println("Dll size: " + dll.size());
        
 

        //Testing add(int index, E elem);
        dll.add(4, Tuvok);
        System.out.println("DLL after add: " + dll);
        System.out.println("Dll size: " + dll.size());

        //testing add(int index, E elem) with out of range index;
        dll.add(-1,Nelix);
        System.out.println("DLL after add: " +dll);
        System.out.println("DLL Size: " + dll.size());

        //Testing getHead
        System.out.println("getHead: " + dll.getHead());

        //Testing get
        System.out.println("get : " + dll.get(4));

        //Testing getLast
        System.out.println("getLast: " + dll.getLast());

        //Testing append
        System.out.println("append: " + dll.append(EnsignKim));
        System.out.println("DLL after append: " + dll);
        System.out.println("dll Size after append: " + dll.size());

        //testing remove()
        System.out.println("Remove: " + dll.remove());
        System.out.println("dll after remove: "+ dll);
        System.out.println("dll Size after remove: " + dll.size());

        //Testing removeAt(int index)
        System.out.println(dll.removeAt(1));
        System.out.println("dll After removeAt: " + dll);
        System.out.println("dll Size after removeAt: " + dll.size());

        //Testing removeAt(int index) index out of range
        System.out.println(dll.removeAt(-1));
        System.out.println("dll After attempted removeAt: " + dll);
        System.out.println("dll Size after attempted removeAt: " + dll.size());

        //Testing removeAt(int index) index 0
        System.out.println(dll.removeAt(0));
        System.out.println("DLL after removeAt: " + dll);
        System.out.println("DLL size: "+ dll.size());


        //Testing removeLast()
        System.out.println("dll after removeLast: " + dll.removeLast());
        System.out.println("dll: " + dll);
        System.out.println("dll size: " + dll.size());

        //Testing removeLast() where dll has no tail set
        

        //Testing remove(E elem)
        System.out.println("dll after remove: " + dll.remove(node4.data));      
        System.out.println("DLL: " + dll);

    }
    // @Test
    // public void testAdd(){
    //     String Janeway = "Janeway";
    //     dll.add(JaneWay);
    //     System.out.println("DLL after add: " + dll);
    //     System.out.println("Dll size: " + dll.size());
    // }

    //init attributes of DLList class
    private int size = 0;
    Node<E> head = null;
    Node<E> tail = null;
    private ArrayList<Node<E>> indices;

    //IDLList Constructor
    public IDLList(){
        //IDLList<E> dll = new IDLList<E>();
        this.head = null;
        this.tail = null; 
        indices = new ArrayList<Node<E>>();
    }

    public boolean add(E elem){
        //Handle for empty DLL
        if (this.head == null){
            //set elem to head.data
            this.head.data = elem;
            //set elem to tail.data
            this.tail.data = elem;
            //add elem to indices
            indices.add(this.head);
            //increment size
            this.size = this.indices.size(); 

        }
        //else 
        //Create new node
        Node<E> newNode = new Node<E>(elem);
        //assign elem to newnode.data
        newNode.data = elem;
        //newNode -> currentHead
        newNode.next = indices.get(0);
        // NewNode <- CurrentHead
        indices.get(0).prev  = newNode;
        //set head to new node
        this.head = newNode;
        //add to indices
        this.indices.add(0, newNode);
        //adjust size
        this.size= indices.size();
        return true;


    }


    public boolean add(int index, E elem){

        //handle edge cases where add is done on empty linked list and when index is wrong

        //if index is out of range
        try{

        //get index from indices array list and assign to variable
        Node<E> temp = indices.get(index);
        //create new node
        Node<E> newNode = new Node<E>(elem);
        newNode.data = elem;
        //  0      1     2     3
        // node1 node2 node3 node4
        // node1 -> Janeway
        indices.get(index-1).next = newNode;
        //Janeway->node2
        newNode.next = indices.get(index);
        //node1 <- Janeway 
        newNode.prev = indices.get(index).prev;
        // janeway <- node2
        indices.get(index).prev = newNode;
        //add newNodw address to indices ArrayList
        indices.add(index, newNode);
        //adjust size
        this.size = this.indices.size();
        //return boolean
        return true;
    }
    catch (IndexOutOfBoundsException e){
        System.out.println("Index is out range. Please select index within range.");
    }
    return false;
    }

    //Returns object at position index from the head
    public E get(int index){

        return this.indices.get(index).data;
    }

    //returns object at head
    public E getHead(){
         return this.head.data;
     }
    //returns object at tail
    public E getLast(){
        // if (this.tail == null){
        //     Node<E> currentNode = new Node<E>();
        //     //loop through DLL
        //     while(currentNode != null){
        //         currentNode = currentNode.next;
        //         if (currentNode.next == null){
        //             //set current node to tail
        //             this.tail = currentNode;
        //             //return currentNode
        //             return currentNode;
        //         }
        //     }
        // }

        return this.tail.data;

        
    }

    public int size(){
        return this.size;
    }
    //removes and returns the element at head
    public E remove(){
        E tempString;
        //init temp 
        Node<E> temp = new Node<E>();
        //set head.next.prev to null
        this.head.next.prev = null;
        //set head.prev to temp
        temp.next = this.head;
        //set head.next to head
        this.head= this.head.next;

        //update indices
        this.indices.remove(0);
        //update size
        this.size = this.indices.size();

        return temp.next.data;
    }
    //removes and returns the element at the index
    public E removeAt(int index){
        //handle for index = 0

        // }
        //if index out of range 
        try {

        
        //  0      1     2     3
        // node1 node2 node3 node4
        //point index.prev.next to index.next
        this.indices.get(index).prev.next = this.indices.get(index).next;
        //point index.next.prev. to index.prev
        this.indices.get(index).next.prev = this.indices.get(index).prev;
        //init temp
        Node<E> temp = new Node<E>();
        temp = this.indices.get(index);
        //update indices
        this.indices.remove(index);
        //update size
        this.size = this.indices.size();
        return temp.data;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index out of range. Please select index within range.");
            
        } catch (NullPointerException e) {
            System.out.println("To remove index 0 call .remove()");
        }
        Node<E> temp = new Node<E>(null);
        return temp.data;

    }
    //removes and returns element at tail
    public E removeLast(){
        if (this.tail !=null){
            //create new node
            Node<E> temp = new Node<E>();
            //tail.prev.next to null
            this.tail.prev.next = null;
            //temp.prev to tail
            temp.prev = this.tail;
            //this.tail.next = temp;
            //assign tail to tail.prev
            this.tail = this.tail.prev;
            //tail.prev to null
            this.tail.prev = null;
            //update index
            this.indices.remove(this.indices.size()-1);
            //update size
            this.size = this.indices.size();
            
            
            return temp.prev.data;
        }
        //else
        // init currentNode
        Node<E> currentNode = new Node<E>();
        Node<E> temp = new Node<E>();
        //point currentNode to head
        currentNode = this.head;
        //loop through DLL
        while (currentNode != null){
            currentNode = currentNode.next;
            //When at the end of the DLL
            if (currentNode.next == null){
                temp.next = currentNode;
                //assign tail to currentNode.prev
                this.tail = currentNode.prev;
                currentNode.prev.next = null;
                return temp.next.data;
            }
        }
        return tail.data;

    }
    //removes the first occurence of elem in the list and returns true. 
    //returns false if elem not in list
    public boolean remove(E elem){
        Node<E> currentNode = new Node<E>();
        //set current node to head
        currentNode = this.head;
        //loop through DLL
        while (currentNode != null){
            //if currentNode.data equals elem
            if(currentNode.data == elem){
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;

                return true;
            }
            currentNode = currentNode.next;
        }
        //else
        return false;
    }

    // adds elem as the last element of linkedlist
    public boolean append(E elem){
        //create new node
        Node<E> newNode = new Node<E>(elem);
        newNode.data = elem;
        //point prev of newNode to tail
        newNode.prev = this.tail;
        //point current tail to newNode
        this.tail.next = newNode;
        //set tail to new Node
        this.tail = newNode;
        //add elem to indices
        this.indices.add(indices.size()-1, tail);
        //update size
        this.size= this.indices.size();

        return true;
    }




    //Create String representation of DLL
    @Override
    public String toString(){
        
        //create temp variable to create string representation of Node
        String temp= "";
        //create reference to head
        Node<E> nodeRef = head;
        //loop through nodes untill node is null
        while(nodeRef != null){
            temp = temp + nodeRef.data;
            //If nodeRef.next add a comma and space
            if (nodeRef.next !=null){
                temp = temp + ", ";
            }
            //traverse nodes
            nodeRef = nodeRef.next;
        }
        return temp;

    }

    private static class Node<E> {

        E data;
        Node<E> next;
        Node<E> prev;

        private Node(){
            this.data = null;
        }


        //Node contructor
        private Node(E elm){
            //Question: should this have a next pointing to something?
            //Question: why can you not create new object
            //Node<E> nodelet = new Node<E>(E elm);
            this.data = elm;
            //this.next =null;

        }
        //Node Contstructor
        private Node(E elm, Node<E> prev, Node<E> next){
            //Node<E> nodeling = new Node<E>();
            this.next = next;
            this.prev =prev;
        }

    }

    
}