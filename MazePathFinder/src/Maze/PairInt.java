package Maze;

import java.util.*;

public class PairInt{
    //add x and y data fields
    private int x;
    private int y; 
    

    //define methods

    public PairInt(int x, int y){
        //add to stack
        //create new object and dd to stack
        // Stack<Integer> s = new Stack<>();
        // Object p = new Object();
        // //Stack<String> S = new Stack<>();

        // PairInt p1 = (PairInt) p;
        
        // s.push(p1.x);
        // s.push(p1.y);
       // PairInt p = new PairInt(x, y);

        //Stack<PairInt> p = new Stack<>();
        this.x = x;
        this.y = y;
    }
    //implement getter methods
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    //implement setter methdos
    public void setX(int x){
        this.x = x;

    }
    public void setY(int y){
        this.y = y;
    }
    public boolean equals(Object p){
        //throw exception if p is null
        PairInt p1 = (PairInt) p;
        if(this.x == p1.x && this.y == p1.y){
            return true;
        }else {
            return false;
        }
        
    }
    public String toString(){
        String x = Integer.toString(this.x);
        String y = Integer.toString(this.y);

        return "(" + x + "," + y + ")";

    }
    public PairInt copy(){
        PairInt p2 = new PairInt(this.x, this.y);
        return p2;

    }
}