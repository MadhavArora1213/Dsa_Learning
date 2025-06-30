

public class Prime_Number {
    public static void main(String[] args) {
        
        int count = 0;
        int n = 36; // Example number to check for primality

        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==2){
            System.out.println(n+" is a prime number.");
        }else{
            System.out.println(n+" is not a prime number.");
        }
    }
}
