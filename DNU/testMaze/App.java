package Maze;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        TwoDimGrid m = new TwoDimGrid(5, 5);
        //m.TwoDimGrid(5,5);
        Maze maze = new Maze(m);
        maze.findMazePath();
    


    }
}
