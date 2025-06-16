
public class Function {

    static class Student {

        String name;
    }
     public static void changeName(Student s) {
        s.name = "Madhav";
    }

    public static void main(String[] args) {

        // Passing by value example
        int a = 5;
        changeValue(a);
        System.out.println("Value of a after function call: " + a); // This will still print 5

        // Passing by reference example
       Student s1 = new Student();
       s1.name = "John";
       changeName(s1);
       System.out.println("Student name after function call: " + s1.name); // This will print "Madhav"
    }

    public static void changeValue(int x) {
        x = 10;
    }
}
