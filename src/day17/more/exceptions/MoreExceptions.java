package day17.more.exceptions;

import java.util.Scanner;

public class MoreExceptions {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}

class Calculator {
    static int power(int n, int p) {
        if (n < 0 || p < 0) {
            throw new ArithmeticException("n and p should be non-negative");
        } else {
            double ans = Math.pow(new Double(n), new Double(p));
            return (int) ans;
        }
    }
}
