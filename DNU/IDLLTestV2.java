



public class IDLLTestV2{
    

    public static void main(String[] args){// IDLListTest(){
                
                //instantiate new DLL
                IDLList<String> dll = new IDLList<String>();

                //add nodes
                dll.add("Node1");
                dll.add("Node2");
                dll.add("Node3");
                dll.add("Node4");
                dll.add("Node5");
                System.out.println("DLL: " + dll);
                //Create nodes
                // Node<String> node1 = new Node<String>("Node 1");
                // Node<String> node2 = new Node<String>("Node 2");
                // Node<String> node3 = new Node<String>("Node 3");
                // Node<String> node4 = new Node<String>("Node 4");
                // Node<String> node5 = new Node<String>("Node5");
                // Node<String> node6 = new Node<String>("JaneWay");
               //StarTrek Voyager Characters
                String JaneWay = "JaneWay";
                String Tuvok = "Tuvok";
                String EnsignKim = "Ensign Kim";

                // dll.head = node1;
                // node1.next = node2;
                // node2.prev = node1;
                // node2.next = node3;
                // node3.prev = node2;
                // node3.next = node4;
                // node4.prev = node3;
                // node4.next = node5;
                // node4.prev= node4;
                // dll.tail = node5;
    }

    // public void initIndex(){
    //             //instantiate index
    //             dll.indices = new ArrayList<Node<String>>();
    //             //Populate indices list with node references
    //             Node<String> nodeRef = dll.head;
    //             while (nodeRef !=null){
    //                 dll.indices.add(nodeRef);
    //                 nodeRef = nodeRef.next;
    //             }
    //             dll.size = dll.indices.size();
    // }

    // public void printDLL(){
    //     System.out.println("dll: " + dll);
    //     System.out.println("Dll Size: " + dll.size);
    // }
    // @Test
    // public void testingAdd1(){
    //     //testing add(E elem)
    //     dll.add(JaneWay);
    //     System.out.println("DLL after add: " + dll);
    //     System.out.println("Dll size: " + dll.size);
    // }
    // @Test
    // public void testingAdd2(){
    //     //Testing add(int index, E elem);
    //     dll.add(4, Tuvok);
    //     System.out.println("DLL after add: " + dll);
    //     System.out.println("Dll size: " + dll.size);
    // }
    // @Test
    // public void testingGetHead(){
    //     //Testing getHead
    //     System.out.println("getHead: " + dll.getHead());
    // }
    // @Test
    // public void testingGet(){
    //     //Testing get
    //     System.out.println("get : " + dll.get(4));
    // }
    // @Test
    // public void testingAppend(){
    //     //Testing append
    //     System.out.println("append: " + dll.append(EnsignKim));
    //     System.out.println("DLL after append: " + dll);
    //     System.out.println("dll Size after append: " + dll.size());
    // }
    // @Test
    // public void testingRemove(){
    //     //testing remove()
    //     System.out.println("Remove: " + dll.remove());
    //     System.out.println("dll after remove: "+ dll);
    //     System.out.println("dll Size after remove: " + dll.size());
    // }

    // @Test 
    // public void testingRemoveAt(){
    //     //Testing removeAt(int index)
    //     System.out.println(dll.removeAt(1));
    //     System.out.println("dll After removeAt: " + dll);
    //     System.out.println("dll Size after removeAt: " + dll.size());
    // }
    // @Test
    // public void testingRemoveLast(){
    //      //Testing removeLast()
    //      System.out.println("dll after removeLast: " + dll.removeLast());
    //      System.out.println("dll: " + dll);
    //      System.out.println("dll size: " + dll.size());
    // }
        
    }
