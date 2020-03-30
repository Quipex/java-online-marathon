package sprint01;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static float doubleNumber(double number) {
        return (float) number * 2;
    }

    public static int century(int year) {
        return (int) Math.ceil(year / 100.0);
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        for (String digit : String.valueOf(number).split("")) {
            sum += Integer.parseInt(digit);
        }
        return sum;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400f == 0) {
            return true;
        }
        if (year % 100f == 0) {
            return false;
        }
        return year % 4f == 0;
    }
}
