//By Kwasi Osae-Kwapong
//Little Endian Bit Order is used in this program
/**To see use of all BinaryNumber constructors please execute the program by passing
an integer, a string, and not passing anything to the initialization of BinaryNumber
on line 17
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;



public class Main {
    public static void main(String[] args){
       
        BinaryNumber binary = new BinaryNumber("10110");
       
        Menu menu = new Menu();
        menu.showMenu();
  
    
        
        int input = menu.takeInput();
   
        if (input == 1){
            System.out.println(binary.getLength());
        }
        if(input ==2){
            System.out.println("Please enter index of digit you would like to get.");
            int place = menu.takeInput();
            System.out.println(binary.getDigit(place));
        }
        if(input ==3){
            System.out.println(binary.toDecimal());
        }
        if(input == 4){
            System.out.println("how many places would you like to shift the binary number?");
            int amount = menu.takeInput();
            binary.shiftR(amount);

        }
        if(input ==5){
            BinaryNumber userBinary = new BinaryNumber();
            binary.add(userBinary);
            System.out.println(binary.binary);
            
        }
       
        

    }
}

public class Menu {
    public void showMenu(){
        System.out.println("\nPlease select one of the following options:" +
        "\n1) Get Length of binary number" +
        "\n2) Get Digit of binary number"+
        "\n3) Convert binary number to decimal"+
        "\n4) Format binary Number"+
        "\n5) Add binary numbers");
    }

    public int takeInput(){
        Scanner scanner = new Scanner(System.in);
        int input;
        input = scanner.nextInt();
        return input;
    }


}

public class BinaryNumber{
    //attributes 
    private int length;
    public List<Integer> binary;
    private boolean overflow;


    //Constructors
    public BinaryNumber(){
        System.out.println("Please enter a binary number by entering one digit at a time, and then pressing Enter. End your input by entering any letter and then pressing Enter");
        Scanner scanner = new Scanner(System.in);
        List<Integer> binary = new ArrayList<Integer>();
        //String var = in.next();
        //int var;
        
        // Integer input = scanner.nextInt();
        // //convert Integer Input to String and find length
        // int length = String.valueOf(input).length();

        // String inputS = String.valueOf(input);
        // int[] digits = input;

        // for(int i =0; i < digits.length; i++){
        //     binary.add(digits[i]);
        // }

        while(scanner.hasNextInt()) {
            binary.add(scanner.nextInt());
        }
        //scanner.close();

        this.binary = binary;
        this.length = binary.size();
    }
    public BinaryNumber(int length){
        this.length = length;
        List<Integer> binary = new ArrayList<>();
        
        System.out.println("Your binary Number is: ");
        for (int i =0; i < length; i ++) {
            System.out.print("0");
            binary.add(0);
            this.binary = binary;
        }

     }
    public BinaryNumber(String str){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a binary number");
        
        List<Integer> binary = new ArrayList<>();
        for (int i =0; i < str.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
            binary.add(digit);
            this.binary = binary;
        }
        //binary.add(str.)

    }
    //Methods
    public int getLength(){
        System.out.println("\nThe length of the binary number is: ");
        this.length = binary.size();
        return this.binary.size();
        
    }

    public int getDigit(int index){
        if (index > this.length){
            System.out.println("Index out of range.");
        
        }// loop through this.binary.get()
        
        int val =0;
        try{val =this.binary.get(index);
        }catch(IndexOutOfBoundsException e){
        System.out.println("Index out of range.");  
        }
        System.out.println("Digit retrieved is: ");
        return val;
    }

    public int toDecimal(){
        //Converts Binary to decimal in little Endian notation
        //iterate through this.binary
        //** for i in binary:
        int sum = 0;
        
        for (int i =0; i< this.length; i++){
            sum += binary.get(i) *Math.pow(2, i);
            //System.out.println("sum" + sum);
        }
        System.out.println("The decimal number is: ");
        return sum;
    }

    public void shiftR(int amount){
        String str = "0";
       // this.binary = binary.asList();
        String binaryFormatted = String.join(",",binary.toString());

        System.out.print(str.repeat(amount)+ binaryFormatted);
}
           // System.out.print(binary.get(i));
    public void add(BinaryNumber aBinaryNumber){
        //add is performed on the BinaryNumber calling it

        int carry = 0;
    
        //first compare lengths of BinaryNumbers
        if (this.length != aBinaryNumber.length){
            System.out.println("The binary numbers are of different lengths");
            this.overflow = true;
  
        }

        //Addition if same lenth
        
        if (this.length == aBinaryNumber.length){
        for (int i =0; i < this.length; i++){
           // int carry = 0;
            
            int sum = this.binary.get(i) + aBinaryNumber.binary.get(i);

            if (sum ==2){
                if (carry ==0){
                    carry =1;
                    this.binary.set(i,0);
                } else {
                    this.binary.set(i,1);
                }
            }

            if (sum ==1 ){
                if (carry ==1){
                    this.binary.set(i, 0);
                } else{
                    this.binary.set(i,1);
                }

                }
            if (sum == 0){
                if (carry ==1){
                    this.binary.set(i,1);
                    carry =0;
                } else {
                    this.binary.set(i,0);
                }
            }
            if( i == this.length && carry ==1){
                System.out.println("Overflow Detected");
                this.overflow = true;
            }
        

            }
            }
        }

        public void clearOverflow(){
            this.overflow = false;
        }
    }
       
    
    



