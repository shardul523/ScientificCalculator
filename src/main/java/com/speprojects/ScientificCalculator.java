package com.speprojects;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ScientificCalculator {

    private Scanner scanner;

    public ScientificCalculator() {
        scanner = new Scanner(System.in);
    }

    private double squareRoot(double x) {
        if (x < 0) 
            throw new IllegalArgumentException("Cannot compute square root of a negative number");
        return Math.sqrt(x);
    }

    private long factorial(int x) {
        if (x < 0) 
            throw new IllegalArgumentException("Cannot compute the factorial of a negative number");

        long fact = 1;

        for (int i = 2; i <= x; i++) fact *= i;

        return fact;
    }

    private double naturalLog(double x) {
        if (x <= 0) 
            throw new IllegalArgumentException("Cannot compute the natural logarithm of a negative number");

        return Math.log(x);
    }

    private double power(double x, double b) {
        return Math.pow(x, b);
    }

    private void displayMenu() {
        System.out.println("\n==== Scientific Calculator ====");
        System.out.println("1. Square Root (√x)");
        System.out.println("2. Factorial (x!)");
        System.out.println("3. Natural Logarithm (ln(x))");
        System.out.println("4. Power Function (x^b)");
        System.out.println("5. Exit");
        System.out.println("============================");
    }

    private void handleSquareRoot() {
        System.out.print("Enter the number to calculate the square root of: ");
        
        try {
            double x = scanner.nextDouble();
            double sqrt = squareRoot(x);
            System.out.println("Square root of " + x + " = " + sqrt);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number to be calculate the square root.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleFactorial() {
        System.out.print("Enter the number to calculate the factorial of: ");
        
        try {
            int x = scanner.nextInt();
            long fact = factorial(x);
            System.out.println("Factorial of " + x + " = " + fact);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number to be calculate the factorial.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleNaturalLog() {
        System.out.print("Enter the number to calculate the natural logarithm of: ");
        
        try {
            double x = scanner.nextDouble();
            double log = naturalLog(x);
            System.out.println("Natural Logarithm of " + x + " = " + log);
        } catch (InputMismatchException e) {
            System.out.println("Enter a number to be calculate the natural logarithm.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handlePower() {
        try {
            System.out.print("Enter the base number: ");
            double x = scanner.nextDouble();
            System.out.print("Enter the exponent: ");
            double b = scanner.nextDouble();
            double pow = power(x, b);
            System.out.println(x + " raised to the power " + b + " = " + pow);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number to compute power.");
            scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        boolean exited = false;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        handleSquareRoot();
                        break;

                    case 2:
                        handleFactorial();
                        break;

                    case 3:
                        handleNaturalLog();
                        break;

                    case 4:
                        handlePower();
                        break;

                    case 5:
                        exited = true;
                        break;
                
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }

        } while (!exited);

        scanner.close();
    }

    public static void main(String[] args) {
        new ScientificCalculator().run();
    }
}
