
// import java.util.Scanner;

// public class BasicInputOutput {

//     public static void main(String[] args) {
//         //output a simple message to the console with newline 

//         System.out.println("Hello, World!");

//         //output a simple message to the console without newline
//         System.out.print("Hello, World without newline! ");

// // Learn how to take input from the user by using Scanner class

//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter your name: ");
//         String name = sc.nextLine();

//         System.out.println("Hello, My name is " + name + ".");

//         System.out.println("Enter your age:");
//         int age = sc.nextInt();
//         System.out.println("I am " + age + " years old.");


  


//     }
// }



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BasicInputOutput {
    public static void main(String[] args) throws IOException {
        // Step 1: Create InputStreamReader
        InputStreamReader isr = new InputStreamReader(System.in);

        // Step 2: Create BufferedReader object
        BufferedReader br = new BufferedReader(isr);

        // Step 3: Read data
        System.out.println("Enter your favorite number:");
        String input = br.readLine();  // returns a string

        // Step 4: Convert string to integer
        int num = Integer.parseInt(input);

        // Step 5: Print it
        System.out.println("You entered: " + num);
    }
}
