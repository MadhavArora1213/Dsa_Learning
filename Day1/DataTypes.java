public class DataTypes {
    public static void main(String[] args) {
      
        // byte data type
        byte b = 100; // 1 byte, range: -128 to 127
        System.out.println("Byte value: " + b);

        // short data type
        short s = 10000; // 2 bytes, range: -32,768 to 32,767
        System.out.println("Short value: " + s);

        // int data type
        int i = 100000; // 4 bytes, range: -2,147,483,648 to 2,147,483,647
        System.out.println("Integer value: " + i);

        // long data type
        Long l = 1000000000000L; // 8 bytes, range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        System.out.println("Long value: " + l);

        // float data type
        float f = 10.5f; // 4 bytes, range: approximately -3.40282347E+38 to 3.40282347E+38
        System.out.println("Float value: " + f);

        // double data type
        double d = 20.99; // 8 bytes, range: approximately -1.79769313486231570E+308 to 1.79769313486231570E+308
        System.out.println("Double value: " + d);

        // scientific notation
        double sci = 1.23E4; // 1.23 * 10^4 = 12300.0
        System.out.println("Scientific notation value: " + sci);



        // boolean data type
        boolean isTrue = true; // 1 bit, can be true or false
        System.out.println("Boolean Value: " + isTrue);

        // char data type
        char c = 'B'; // 2 bytes, single character
        System.out.println("Character value: " + c);

        char ch = 67;
        // ASCII value of 'C' is 67
        System.out.println("Character from ASCII value: " + ch);

        // String data type
        String str = "Hello, World!"; // not a primitive type, but widely used
        System.out.println("String value: " + str);
    }
}
