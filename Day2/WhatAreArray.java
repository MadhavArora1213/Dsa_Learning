public class WhatAreArray {
    public static void main(String[] args) {
        
        // Array data type

        String[] fruits ={
            "Apple",
            "Banana",
            "Cherry",
            "Date",
            "Elderberry"
        };

        System.out.println(fruits[2]); // Accessing an element by index

        fruits[2] = "Mango"; // Modifying an element
        System.out.println("After modification: " + fruits[2]);

        // Length of the array
        System.out.println("Length of an array: " + fruits.length);

        // Looping through the array

        for(int i=0; i<fruits.length;i++){
            System.out.println(fruits[i]);
        }

        // for each loop
        for(String i:fruits){
            System.out.println(i);
        }


        // Multidimensional array
        String[][] matrix = {
            {"A1", "B1", "C1"},
            {"A2", "B2", "C2"},
            {"A3", "B3", "C3"}
        };
        System.out.println("Multidimensional Array Element: " + matrix[1][2]); // Accessing an element in a 2D array
        System.out.println("Length of first row: " + matrix[0].length); // Length of the first row

        // Looping through a multidimensional array
        for(String[] row:matrix){
            for(String col:row){
                System.out.println(col);
            }
        }

        // Looping through a multidimensional array with indices
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[i].length;++j){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
