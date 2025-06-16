public class ForLoop {
    public static void main(String[] args){


        // for loop

        for(int i=1;i<11;i++){
            System.out.println("I am at rank " + i + " in the b.tech cse.");
        }

        // nested for loop

          for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + i + ", j = " + j);
                // Nested loop code
            }
        }

        // customizing for loop

        for (int i = 1; i <= 25; i += 5) {
            System.out.println("i = " + i);
        }
    }
}
