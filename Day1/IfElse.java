public class IfElse {
    public static void main(String[] args){

        // Example of If-Else statement in Java
        int age = 20;

        if(age >=18){
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        // Example of If-Else-If statement in Java
        int marks = 85;
        if(marks >= 90){
            System.out.println("Grade: A");
        } else if(marks >= 80){
            System.out.println("Grade: B");
        } else if(marks >= 70){
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D");
        }

        // Increase the code readability by using a variable to store the grade

        char grade;

        if(marks >= 90){
            grade = 'A';
        } else if(marks >= 80){
            grade = 'B';
        } else if(marks >= 70){
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("Grade: " + grade);

        // Example of shorthand if-else (ternary operator) in Java
        String result = (age >= 18) ? "You are an adult." : "You are a minor.";
        System.out.println(result);
    }

}
