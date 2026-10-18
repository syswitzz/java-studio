import java.util.*;


class Cal {
    public static int add(int a, int  b){
        return a + b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int divide (int a, int b){
        if (b!=0) {
            return a / b;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public static int subtract(int a, int b){
        return a - b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.println("--------------------");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid choice! Please select 1-5.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            
            if(choice > 4 || choice < 1) break;

            // Taking user inputs
            System.out.print("\nEnter number A: ");
            int a = scanner.nextInt();

            System.out.print("Enter number B: ");
            int b = scanner.nextInt();
            
            System.out.print("\n\nResult: ");

            switch (choice) {
                case 1:
                    System.out.printf("%d + %d = %d\n\n", a, b, Cal.add(a, b));
                    break;
                case 2:
                    System.out.printf("%d - %d = %d\n\n", a, b, Cal.subtract(a, b));
                    break;
                case 3:
                    System.out.printf("%d * %d = %d\n\n", a, b, Cal.multiply(a, b));
                    break;
                case 4:
                    try {
                        System.out.printf("%d / %d = %d\n\n", a, b, Cal.divide(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }

            scanner.nextLine();
            System.out.print("Press ENTER to continue.");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}