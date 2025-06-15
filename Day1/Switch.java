

public record Switch() {

    public static void main(String[] args) {
        // int day;

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a number between 1 and 7 : ");
        // day = sc.nextInt();

        // switch (day) {
        //     case 1:
        //         System.out.println("Monday");
        //         break;
        //     case 2:
        //         System.out.println("Tuesday");
        //         break;
        //     case 3:
        //         System.out.println("Wednesday");
        //         break;
        //     case 4:
        //         System.out.println("Thursday");
        //         break;
        //     case 5:
        //         System.out.println("Friday");
        //         break;
        //     case 6:
        //         System.out.println("Saturday");
        //         break;
        //     case 7:
        //         System.out.println("Sunday");
        //         break;
        //     default:
        //         System.out.println("Invalid day");
        // }
        // sc.close();

        final int x =10;
        final int y = 20;

        switch(x+y){
            case 20:
                System.out.println("x + y is 20");
                break;
            case 30:
                System.out.println("x + y is 30");
                break;
            case 40:
                System.out.println("x + y is 40");
                break;
            default:
                System.out.println("x + y is not 20, 30 or 40");
                break;
            
        }
    }

}
