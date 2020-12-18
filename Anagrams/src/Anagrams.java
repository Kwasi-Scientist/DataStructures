//By Kwasi Osae-Kwapong
//CS570 HW Assignment 6

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Anagrams{


    //data fields for Anagram class
    final Integer[] primes ={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101}; // list of first 26 prime numbers
    Map<Character, Integer> letterTable = new HashMap<>(); //Hashtable containing alphabet to prime number mapings
    Map<Long, ArrayList<String>> anagramTable = new HashMap<>(); //Hashtable containing hascode saved as long to ArrayList of anagrams mapping



    //methods for Anagrams 

    /** Anagram Constructor
    Creates list of Anagrams and adds to anagramTable Hashtable */
    public Anagrams(){
        //test code
        //ArrayList<String> anagrams = new ArrayList<>();
        //build letterTable
        buildLetterTable();


    }




    /**buildLetterTable
    Creates alphabet to prime number letterTable hashtable */
    private void buildLetterTable(){
        //letter table takes letter:prime number

        //list alphabet
        ArrayList<Character> alpha = new ArrayList<>();
        //String c;
        //loop through alphabet 
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(int j = 0; j< alphabet.length; j++){
        char c = alphabet[j];
        Integer prime = primes[j];

        letterTable.put(c, prime);            
        }
    }
    /**myHasCode
     * Takes a string and converts it to hashcode using lettertable
     * Returns long that is the same for each anagram of a word
     */
    private Long myHashCode(String s ){
        //convert string to character array
        char[] thing = s.toLowerCase().toCharArray();
        //init hash
        long hash = 1;

        for (int i=0;i<thing.length;i++){
            //init hash value to 1
            //long hash = 1;
            Character c = thing[i];
            Integer prime = letterTable.get(c);
            hash = hash*prime;

            //get prime number from letter table

        }
        
        return hash;
        
    }

    /**addWord
    computes hashcode of String s and adds to hashtable
     */
    private void addWord(String s){
        //compute hashcode of String s
        Long hashcode = myHashCode(s);
        //create ArrayList
        ArrayList<String> anagrams = new ArrayList<>();
        //search for string in anagramsTable

        //if haschode of string is in anagramTable 
        if (anagramTable.containsKey(hashcode) ){ 
            //get the arraylist contatining anagrams
            //anagrams = anagramTable.get(hashcode);
            anagrams = anagramTable.getOrDefault(hashcode, anagrams);
            //add string to anagrams list 
            anagrams.add(s);
            //put the anagrams arraylist back into dict
            //anagramTable.put(hashcode, anagrams);
            //else if String s.length() > anagramtable element 
        } else {
            //if not found create new arraylist
            anagrams = new ArrayList<>();
            //add string to arraylist anagrams
            anagrams.add(s);
        }
        
        //add hashcode and string to anagramTable
        anagramTable.put(hashcode, anagrams);

    }


    /**processFile
     * processes input file and builds the hashtable anagramTable
     */
    private void processFile(String s) throws IOException {
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while((strLine = br.readLine()) != null){
            this.addWord(strLine);
        }
        br.close();
    }

    /**getMaxEntries
     * returns a list of the largest number of anagrams
     */
    private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries(){
        //find hashcode with largest number of anagrams
        ArrayList<Map.Entry<Long, ArrayList<String>>> results = new ArrayList<>();
       
        int size = 0;
        long maxHash = 0;
        int wordLen = 0;
        //iterate through all values in anagramTable
        for (Map.Entry<Long,ArrayList<String>> entries: anagramTable.entrySet()){
            if (entries.getValue().size() > size){
                size = entries.getValue().size();                
            }
            if (entries.getKey() > maxHash){
                maxHash = entries.getKey();
            }

        }
        System.out.println("size: " +size);
        System.out.println("maxHash: " + maxHash);
        for (Map.Entry<Long, ArrayList<String>> entry: anagramTable.entrySet()){
            if (entry.getValue().size() == size){
                results.add(entry);
            }
        }
        
        return results;
    }






    public static void main (String[] args){
        //test anagrams and buildLetterTable
        Anagrams ana = new Anagrams();
        //ana.buildLetterTable();

        //main from hw  
        final long startTime = System.nanoTime();
        try{
            ana.processFile("words.txt");
        } catch (IOException e1){
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = ana.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime/1000000000);
        System.out.println("Time: " + seconds);
        System.out.println("Key of max anagram: " +maxEntries.get(0).getKey());
        System.out.println("List of max anagrams: " +maxEntries);
        System.out.println("Length of List of max anagrams: " + maxEntries.get(0).getValue().size());


        // Anagrams ana2 = new Anagrams();
        // // System.out.println(ana.letterTable);
        // // //Character c = "b";
        // // //System.out.println(ana.letterTable.get(c));
        //  String test = "alerts";//hashcode 236294978
        //  String test2= "del"; //hashcode 2442
        //  String test3 ="abel";//hashcode 2442
        //  String test4 = "resalt";
        //  String test5= "stelar"; //23620478
        // // String test2 = "oBo";
        // // String test3= "bad";
        //  System.out.println("test: "+ ana.myHashCode(test));
        //  System.out.println("test5: " + ana.myHashCode(test5));
        //  long num = 236204078;
        //  long num2 = 2442;
        //  System.out.println(ana.anagramTable.get(num));
        //  //System.out.println(ana.anagramTable.containsValue(test));
        //  //System.out.println(ana.anagramTable.size());
        //  System.out.println(ana.letterTable);


        

        // ana.addWord(test);
        // ana.addWord(test2);
        // ana.addWord(test3);
        // System.out.println(ana.anagramTable);
        // System.out.println(ana.getMaxEntries());

    }

}