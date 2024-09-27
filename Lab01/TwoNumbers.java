import java.util.Scanner;
public class TwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number a: ");
        double a = sc.nextDouble();
        System.out.print("Enter number b: ");
        double b = sc.nextDouble();
        System.out.println("Sum of two numbers is: " + (a+b));
        System.out.println("Difference of two numbers is: " + (a-b));
        System.out.println("Product of two numbers is: " + (a*b));
        if (b == 0) {
            System.out.println("Cannot divide by 0");
        } else {
            System.out.println("Quotient of two numbers is: " + (a/b));
        } sc.close();
    }
}
