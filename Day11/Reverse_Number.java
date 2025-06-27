public class Reverse_Number {
    public static void main(String[] args) {
        int n=7789;
        int Reverse_Number=0;
        while(n>0){
            int lastDigit =n%10;
            n =n/10;
            Reverse_Number = Reverse_Number * 10 + lastDigit; 
        }
        System.out.println("The reversed number is: " + Reverse_Number);
    }
}
