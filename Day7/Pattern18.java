public class Pattern18 {
    public static void main(String[] args) {
        int N = 5; // You can change this value for more rows

         for(int i=0;i<N;i++){
          
          // Inner loop for printing the alphabets from
          // A + N -1 -i (i is row no.) to A + N -1 ( E in this case).
          for(char ch =(char)(int)('A'+N-1-i);ch<=(char)(int)('A'+N-1);ch++){
              
              System.out.print(ch + " ");
          }
          
          // As soon as the letters for each iteration are printed, we move to the
          // next row and give a line break otherwise all letters
          // would get printed in 1 line.
          System.out.println();
      }
    }
}
