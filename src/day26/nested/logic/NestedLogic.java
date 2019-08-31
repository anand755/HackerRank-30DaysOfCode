package day26.nested.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLogic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] actualDate = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int actualDay = actualDate[0];
        int actualMonth = actualDate[1];
        int actualYear = actualDate[2];

        int[] dueDate = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int dueDay = dueDate[0];
        int dueMonth = dueDate[1];
        int dueYear = dueDate[2];

        int totalFine = 0;
        if (actualYear == dueYear) {

            if (actualMonth == dueMonth) {
                totalFine = 15 * (actualDay - dueDay);
                totalFine = totalFine > 0 ? totalFine : 0;
            } else {
                totalFine = 500 * (actualMonth - dueMonth);
                totalFine = totalFine > 0 ? totalFine : 0;
            }
        } else {
            if (actualYear > dueYear) {
                totalFine = 10000;
            } else {
                totalFine = 0;
            }

        }
        System.out.println(totalFine);
    }
}
