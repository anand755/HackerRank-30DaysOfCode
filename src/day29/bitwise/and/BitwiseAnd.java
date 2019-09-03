package day29.bitwise.and;

import java.util.Arrays;
import java.util.Scanner;

public class BitwiseAnd {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] resultArr = new int[t];
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            if (((k - 1) | k) > n && k % 2 == 0) {
                resultArr[tItr] = (k - 2);

            } else {
                resultArr[tItr] = (k - 1);
            }
        }
        Arrays.stream(resultArr).forEach(System.out::println);

        scanner.close();
    }
}
