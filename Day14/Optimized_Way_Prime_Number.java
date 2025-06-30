

public class Optimized_Way_Prime_Number {
    public static void main(String[] args) {
        
        int n=3;
        int count =0;

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                count++;
                if(n/i != i) {
                    count++; // Count the corresponding divisor
                }
            }
        }
        if(count==2){
            System.out.println(n+" is a prime number.");
        }else{
            System.out.println(n+" is not a prime number.");
        }
    }
}
