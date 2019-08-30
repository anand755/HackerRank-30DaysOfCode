package day25.running.time.and.complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunningTimeAndComplexity {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(reader.readLine());
        int[] inputNumbers = new int[testCaseCount];
        Boolean[] isPrime = new Boolean[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            inputNumbers[i] = Integer.parseInt(reader.readLine());
            isPrime[i] = checkIsPrime(inputNumbers[i]);
        }
        Arrays.stream(isPrime).forEach(__ -> {
            if (__) System.out.println("Prime");
            else System.out.println("Not prime");
        });
    }

    private static boolean checkIsPrime(int inputNumber) {

        if (inputNumber <= 1) {
            return false;
        }

        //int upperLimit = (int) Math.sqrt(inputNumber);

        for (int i = 2; i * i <= inputNumber; i++) {
            if (inputNumber % i == 0)
                return false;
        }
        return true;
    }
}
