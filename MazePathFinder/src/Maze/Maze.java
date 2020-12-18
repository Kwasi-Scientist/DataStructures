// By Kwasi Osae-Kwapong

//


package Maze;

import java.util.*;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
        // COMPLETE HERE FOR PROBLEM 1
        
        //edge case
        //if x, y is out of bounds
        //Note x cannot be greater than number of columns
        //y cannot be freater than number of rows
        if (x < 0 || y <0 || x >=maze.getNCols() || y >=maze.getNRows()){
            return false;
        }
        //if current cell x,y color is not background
        //if (!maze.getColor(x,y).equals(BACKGROUND))
        else if (!maze.getColor(x, y).equals(NON_BACKGROUND)){
            return false;
        }
        //if current cell color is black and has already been visited return false
        // else if (maze.getColor(x,y).equals(TEMPORARY)){
        //     return false;
        // }
        //if current cell is exit cell change color to path color
        //note: exit cell is (.getNRows-1, .getNcols-1)
        //possibly change to x,y
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, PATH);
            return true;
        } else {
            //Attempt to find a path from each neighbor
            //tentatively mark cell on path

            //current cell is considered part of path
            //Change cell to path color
            maze.recolor(x, y, PATH);
            if ( //explore neighbors and see if part of the path
                //recursive call
                //check right neighbor
                findMazePath(x+1, y) 
                //check neighbor above
                || findMazePath(x, y + 1) 
                //check left
                || findMazePath(x -1,y) 
                //check bottom neighbor
                || findMazePath(x, y-1)){
                
                return true;
            } else {
                // if dead end recolor black
                maze.recolor(x,y, TEMPORARY); 
                return false;
            }
        }
    }

    // ADD METHOD FOR PROBLEM 2 HERE


    //Stack based implementation of findaMazePath
    //@Params - result - the list of successful paths recorded
    //@Param - trace - is the trace of the currrent path being explored

    // public void findMazePathStackBased3(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace){
    //     if(x<0 || x>maze.getNCols() -1 || y<0 || y > maze.getNRows() -1 
    //         || maze.getColor(x,y) ==BACKGROUND||maze.getColor(x,y) ==TEMPORARY){
    //         return;
    //     } else if (x == maze.getNCols()-1 && y==maze.getNRows()-1){
    //         trace.push(new PairInt(x,y));
    //         result.add(new ArrayList<>(trace));
    //         trace.pop();
    //         maze.recolor(x,y, NON_BACKGROUND);
    //         return;
    //     } else {
    //         maze.recolor(x,y, TEMPORARY);
    //         trace.push(new PairInt(x,y));
    //         findMazePathStackBased3(x-1, y, result, trace);
    //         findMazePathStackBased3(x, y-1, result, trace);
    //         findMazePathStackBased3(x+1, y, result, trace);
    //         findMazePathStackBased3(x, y+1, result, trace);
    //         trace.pop();
    //         maze.recolor(x,y, NON_BACKGROUND);
    //         return;

    //     }

    // }

    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace){

        //PairInt pairs = new PairInt(x,y);
        //trace.push(pairs);

        //if x,y not on path
        if (x < 0 || y <0 || x >maze.getNCols() -1 || y >maze.getNRows()-1 || maze.getColor(x,y).equals(BACKGROUND) || maze.getColor(x,y).equals(TEMPORARY)){

            //throw new IllegalArgumentException("X or Y is out of bounds");
            //trace.pop();

            return;
        } 
        //if x and y equals the exit sqaure
        else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            //CHANGE color to path = green
                //maze.recolor(x, y, PATH);
                //create new oair int object
                //PairInt pair = new PairInt(x,y);
                //push pair to trace
                trace.push(new PairInt(x,y));
                //add trace to result
                result.add(new ArrayList<>(trace));
                //ArrayList<PairInt> list = new ArrayList<PairInt>();
                
                //Stack<PairInt> traceTemp = new Stack<>();
                //System.out.println("Trace" + trace);

                //empty stack
                trace.pop();
                maze.recolor(x,y, NON_BACKGROUND);
                //end recursion
                return;
            

        } else {
            //recursive case 
            //PairInt pair2 = new PairInt(x,y);
            //trace.push(new PairInt(x,y));
            //System.out.println("trace" + trace);

            //change current cell to PATH color
            maze.recolor(x,y,TEMPORARY);
            //if x and y are on the grid
            trace.push(new PairInt(x,y));

            findMazePathStackBased(x-1, y, result, trace);
            findMazePathStackBased(x, y-1, result, trace);
            findMazePathStackBased(x+1, y, result, trace);
            findMazePathStackBased(x, y+1, result, trace);

            trace.pop();
            //trace.push(pairs);
            //change current cell to non_background for backtracking
            maze.recolor(x,y, NON_BACKGROUND);
            return;
        }

    }



    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y){
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        Stack<PairInt> trace = new Stack<>();
        //findMazePathStackBased3(0, 0, result, trace);
        findMazePathStackBased(0, 0, result, trace);
        //findMazePathStackBased(0,0, result, trace);
        //System.out.println("trace" + trace);
        //System.out.println("Result" + result);
        return result;


    }
    
    // ADD METHOD FOR PROBLEM 3 HERE

    ArrayList<PairInt> findMazePathMin(int x, int y){

        ArrayList<ArrayList<PairInt>> paths = findAllMazePaths(0,0);
        int index = 0;
        for (int i =0; i<paths.size(); i++){
            int size = maze.getWidth() * maze.getHeight();
            
            if (paths.get(i).size() < size){
                size = paths.get(i).size();
                index = i;
            }
            
            //if (paths.get(i).size() > paths.get(i+1).size())
        }
        return paths.get(index);

    }
    

    /*<exercise chapter="5" section="6" type="programming" number="2">*/
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
    /*</exercise>*/

    /*<exercise chapter="5" section="6" type="programming" number="3">*/
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    /*</exercise>*/
}
/*</listing>*/


