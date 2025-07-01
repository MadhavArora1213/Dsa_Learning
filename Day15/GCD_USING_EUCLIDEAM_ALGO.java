
public class GCD_USING_EUCLIDEAM_ALGO {
    public static void main(String[] args) {
        
        int a = 56;
        int b = 98;

      while(a>0 && b>0){
        if(a>b){
            a = a % b;
        }else{
            b = b % a;
        }
      }
      if(a == 0)
      {
        System.out.println("GCD is: " + b);
        }
        else{
            System.out.println("GCD is: " + a);
        }
    }

}
