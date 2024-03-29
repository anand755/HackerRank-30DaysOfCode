package day19.interfaces;

import java.util.Scanner;

public class Interfaces {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }

}

class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                result = result + (n / i);
            }
        }

        return result;
    }
}

interface AdvancedArithmetic {
    int divisorSum(int n);
}