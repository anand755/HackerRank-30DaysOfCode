package day28.regex.patterns.and.intro.to.databases;

import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegExPatternsAndIntroToDatabases {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> nameList = new ArrayList<>();


        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            if (isValidEmail(emailID)) {
                nameList.add(firstName);
            }
        }
        Collections.sort(nameList);
        nameList.forEach(System.out::println);

        scanner.close();
    }

    private static boolean isValidEmail(String emailID) {

        if (emailID.contains("@")) {
            String domain = emailID.split("@")[1];
            if (domain.equalsIgnoreCase("gmail.com")) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
