package day29.bitwise.and;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BitwiseAndMyApproach {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] resultArr = new int[t];
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            resultArr[tItr] = getMaxAnd(n, k);
        }
        scanner.close();
        Arrays.stream(resultArr).forEach(System.out::println);
    }

    private static int getMaxAnd(int n, int k) {
        int[] arrN = IntStream.rangeClosed(1, n).toArray();
        int allPossibility = 1 << n;
        int maxBitAnd = 0;
        for (int i = 0; i < allPossibility; i++) {

            if (isOnlyTwoBitSet(i)) {

                int iR = getRightMostSetBitIndex(i); //Get right most set bit
                int iL = getLeftMostSetBitIndex(i);//Get left most set bit

                int currBitAnd = arrN[iR] & arrN[iL];

                if (currBitAnd < k && currBitAnd > maxBitAnd) {
                    maxBitAnd = currBitAnd;
                }
            }
        }
        return maxBitAnd;
    }

    private static boolean checkIsSetBit(int number, int index) {
        return ((number & (1 << index)) == (1 << index));
    }

    private static boolean isOnlyTwoBitSet(int number) {
        int setBitCount = 0;
        for (int i = 0; i < 31; i++) {
            if (checkIsSetBit(number, i)) {
                setBitCount++;
            }
        }
        return (setBitCount == 2);
    }

    private static int getRightMostSetBitIndex(int number) {
        int setIndex = 0;

        for (int i = 0; i < 31; i++) {
            if (checkIsSetBit(number, i)) {
                setIndex = i;
                break;
            }
        }
        return setIndex;
    }

    private static int getLeftMostSetBitIndex(int number) {
        int setBitIndex = 0;

        for (int i = 30; i >= 0; i--) {
            if (checkIsSetBit(number, i)) {
                setBitIndex = i;
                break;
            }
        }
        return setBitIndex;
    }
}
