package Maze;

import Maze.TwoDimGrid;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //MazeTest maze = new MazeTest();
        
        //MazeTest test = new MazeTest();
        
        Maze.TwoDimGrid m = new TwoDimGrid(5, 5);
        Maze maze = new Maze(m);
        maze.findMazePath();
    }
}
