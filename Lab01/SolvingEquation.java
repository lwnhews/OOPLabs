import java.util.Scanner;
public class SolvingEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable.");
        System.out.println("2. System of first-degree equations with two variables.");
        System.out.println("3. Second-degree equation with one variable.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                solveFirstDegreeEquation(sc);
                break;
            case 2:
                solveSystemOfFirstDegreeEquations(sc);
                break;
            case 3:
                solveSecondDegreeEquation(sc);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        sc.close();
    }

    private static void solveFirstDegreeEquation(Scanner sc) {
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        if (a == 0) {
            System.out.println("Coefficient a cannot be 0.");
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    private static void solveSystemOfFirstDegreeEquations(Scanner sc) {
        System.out.print("Enter coefficient a11: ");
        double a11 = sc.nextDouble();
        System.out.print("Enter coefficient a12: ");
        double a12 = sc.nextDouble();
        System.out.print("Enter coefficient b1: ");
        double b1 = sc.nextDouble();
        System.out.print("Enter coefficient a21: ");
        double a21 = sc.nextDouble();
        System.out.print("Enter coefficient a22: ");
        double a22 = sc.nextDouble();
        System.out.print("Enter coefficient b2: ");
        double b2 = sc.nextDouble();
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
        }
    }

    private static void solveSecondDegreeEquation(Scanner sc) {
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();
        if (a == 0) {
            System.out.println("Coefficient a cannot be 0.");
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The solution is x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}
