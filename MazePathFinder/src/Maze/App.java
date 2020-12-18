//import Maze;
package Maze;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        TwoDimGrid m = new TwoDimGrid(6, 6);
        //m.TwoDimGrid(5,5);
        Maze maze = new Maze(m);
        System.out.println(maze.findAllMazePaths(5,5));
        MazeTest test = new MazeTest(m);
        //test.solve();
    


    }
}
