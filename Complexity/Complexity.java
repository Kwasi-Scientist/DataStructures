//By Kwasi Osae-Kwapong
//Homework 2 Complexity for CS570
//09/23/2020

import java.lang.Math;

public class Main {

    public static void main(String[] args){

        Complexity complex = new Complexity();
        complex.method1(4);
        complex.method2(2);
        complex.method3(128);
        complex.method4(16);
        complex.method5(65536);
        complex.method6(9);
        
        


    }
}




public class Complexity{

public static void method0(int n) {
    int counter = 0;
    for (int i =0; i< n; i++){
        System.out.println("Counter " + counter);
        counter++;

    }
}


public static void method1(int n){
    //O(n^2)
    int counter= 0;
    for (int i =0; i<n; i++){
        //System.out.println("Counter: " + counter);
        //counter++;
        for (int j =0; j<n; j++){
            System.out.println("Method 1 Counter: " + counter);
            counter++;
        }
    }
}

public static void method2(int n){
    //O(n^3)
    int counter = 0;
    for (int i=0; i<n; i++){
        //System.out.println("Counter: " + counter);
        //counter++;
        for (int j = 0;j<n;j++){
            //System.out.println("Counter: "+ counter);
            //counter++;
            for (int k =0; k<n;k++){
                System.out.println("Method 2 Counter: " + counter);
                counter++;
            }
        }
    }
}


public static void method3(int n){
    //O(logn)
    int counter = 0;
    for (int i =n ; i > 1; i/=2){
        
        System.out.println("Method X n: " + n);
        System.out.println("Method X Count: " + counter);
        System.out.println("Method X i: " + i);
        n /=2;
        counter++;
        
    }
}

public static void method4(int n){
    //O(nlogn)
    int counter = 0;

    for(int i =n; i > 1; i /=2){
        for (int j =1; j < n; j++){
            System.out.println("Method 4 j: " + j);
            System.out.println("Method 4 Counter: " + counter);
            counter++;
        }
        System.out.println("Method 4 i: "+ i);
        System.out.println("Method 4 Counter: " + counter);
        counter++;


    }
}

public static void method5(int n ){
    //O(log log n)
    int counter = 0; 
     
    ///for(double i = n; i>1; i = Math.sqrt(1))
    for (double i = n; i>2; i = Math.sqrt(i)){
        System.out.println("Method 5 i: "+ i);
        System.out.println("Method 5 Counter: "+ counter);
        counter++;
        // for (int k = i; k > 1; k/=2){
        //     System.out.println("Method 5 k: " + k);
        //     System.out.println("Method 5 Counter: "+ counter);
        //     counter++; 
        // }
    }

}

public static int method6(int n){
    //O2^n
    int counter = 0;
    counter++;
    if (n <= 1){
        System.out.println("Method 6 Counter: " + counter);
        return n;
    }
    return method6(n-2) + method6(n -1);



    

}

}

