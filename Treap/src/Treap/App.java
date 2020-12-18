package Treap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        E data = "123";
        int priority = 1;
        Treap T = new Treap();
        Node<Integer> node1 = new Node<>(data, priority);
        T.add(node1);

        
        
    }
}
