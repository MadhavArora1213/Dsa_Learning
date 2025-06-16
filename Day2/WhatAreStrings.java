
public class WhatAreStrings{

    public static void main(String[] args) {

        //String data type
        String str = "Hello";
        String str1 = "World";

        System.out.println("String: " + str);

        // length() method
        System.out.println("Length of string: " + str.length());

        // toUpperCase() method
        System.out.println("Uppercase String:" + str.toUpperCase());

        // toLowerCase() method
        System.out.println("Lowercase String:" + str.toLowerCase());

        // indexOf() method
        System.out.println("Index of 'e': " + str.indexOf('e'));

        //Concatenation By + operator
        System.out.println("Concatenated String: " + str + " " + str1);

        //Concatenation By concat() method
        System.out.println("Concatenated String using concat(): " +str.concat(str1));

        // Special Characters

        String special = "Hello\"World\"";
        System.out.println("Special Characters String: " + special);
    }
}
