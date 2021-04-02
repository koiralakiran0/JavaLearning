import java.util.Scanner;

/*
first level practice for Functional Interfaces
*/
public class App {
    public static void main(String[] args) {
        final String fString = "Enter first number";
        final String sString = "Enter second number";
        final String rString = "%s %s and %s will give %s\n";
        Scanner scanner = new Scanner(System.in);
        AddCalculator addCalculator = (n1, n2) -> n1 + n2;
        SubtractCalculator subtractCalculator = (n1, n2) -> n1 - n2;
        MultiplyCalculator multiplyCalculator = (n1, n2) -> n1 * n2;
        DivideCalculator divideCalculator = (n1, n2) -> n1 / n2;
        boolean repeat = true;
        double firstNum, secondNum;

        while(repeat) {
            System.out.println("****************************\nSelect(1,2,3 or 4) \n1. Add\n2.Subtract\n3.Multiply\n4.Divide\n\n **Select 0 to quit**");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                repeat = false;
            } else if (choice == 1) {
                System.out.println(fString);
                firstNum = Double.parseDouble(scanner.nextLine());
                System.out.println(sString);
                secondNum = Double.parseDouble(scanner.nextLine());
                System.out.printf(rString, "Adding", firstNum, secondNum, addCalculator.add(firstNum, secondNum));
            } else if (choice == 2) {
                System.out.println(fString);
                firstNum = Double.parseDouble(scanner.nextLine());
                System.out.println(sString);
                secondNum = Double.parseDouble(scanner.nextLine());
                System.out.printf(rString, "Subtracting",firstNum, secondNum, subtractCalculator.subtract(firstNum, secondNum));
            } else if (choice == 3) {
                System.out.println(fString);
                firstNum = Double.parseDouble(scanner.nextLine());
                System.out.println(sString);
                secondNum = Double.parseDouble(scanner.nextLine());
                System.out.printf(rString, "Multiplying",firstNum, secondNum, multiplyCalculator.multiply(firstNum, secondNum));
            } else if (choice == 4) {
                System.out.println(fString);
                firstNum = Double.parseDouble(scanner.nextLine());
                System.out.println(sString);
                secondNum = Double.parseDouble(scanner.nextLine());
                System.out.printf(rString, "Dividing",firstNum, secondNum, divideCalculator.divide(firstNum, secondNum));
            } else {
                System.out.println("Try again");
            }
        }
        scanner.close();
        
    }
    
}

@FunctionalInterface
interface AddCalculator {
    double add(double first, double second);
}

@FunctionalInterface
interface SubtractCalculator {
    double subtract(double first, double second);
}

@FunctionalInterface
interface MultiplyCalculator {
    double multiply(double first, double second);
}

@FunctionalInterface
interface DivideCalculator {
    double divide(double first, double second);
}
