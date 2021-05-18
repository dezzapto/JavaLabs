package com.company;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        int a, b, c, result;
        String str, str1;
        boolean res;


        System.out.println("Choose any task from 1 to 10");
        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();

        switch (choose) {
            case  (1):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                str = repeat(str, a);

                System.out.println("Result is " + str);
                break;
            case (2):
                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                int nums[] = new int[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums[i] = scan.nextInt();
                }

                result = differenceMaxMin(nums);

                System.out.println("Result is " + result);
                break;
            case (3):
                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                int nums2[] = new int[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums2[i] = scan.nextInt();
                }

                System.out.println("Result is " + isAvgWhole(nums2));
                break;
            case (4):
                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                int nums3[] = new int[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums3[i] = scan.nextInt();
                }

                str = Arrays.toString(cumulativeSum(nums3));

                System.out.println("Result is " + str);
                break;
            case (5):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                result = getDecimalPlaces(str);

                System.out.println("Result is " + result);
                break;
            case (6):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                result = fibonacci(a);

                System.out.println("Result is " + result);
                break;
            case (7):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Result is " + isValid(str));
                break;
            case (8):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter second string");
                scan = new Scanner(System.in);
                str1 = scan.nextLine();

                System.out.println("Result is " + isStrangePair(str, str1));
                break;
            case (9):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter second string");
                scan = new Scanner(System.in);
                str1 = scan.nextLine();

                System.out.println("Prefix is " + isPrefix(str, str1));
                System.out.println("Suffix is " + isSuffix(str, str1));
                break;
            case (10):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                result = boxSeq(a);

                System.out.println("Result is " + result);
                break;
        }
    }

    public static String repeat(String str, int n) {

        int len = str.length();
        int totl = len * n;
        char[] arr = str.toCharArray();
        char[] newArr = new char [totl];
        int count = 0;

        for(int i = 0; i < len; i++){

            for(int j = 0; j < n; j++) {
                newArr[count] = arr[i];
                count++;
            }

        }

        String answ = new String(newArr);

        return answ;
    }

    public static int differenceMaxMin(int nums[]) {
        int result, min = nums[0], max = nums[0];
        int len = nums.length;

        for(int i = 0; i < len; i++){
            if(nums[i] < min)
                min = nums[i];
            if(nums[i] > max)
                max = nums[i];
        }
        result = max - min;

        return result;
    }

    public static boolean isAvgWhole(int nums[]) {
        int len = nums.length;
        double sum = 0;

        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
        }
        sum = sum / len;

        if(sum % 1 == 0)
        return true;
        else
            return false;
    }

    public static int[] cumulativeSum(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i+1; j++) {
                res[i] += nums[j];
            }
        }
        return res;
    }

    private static int getDecimalPlaces(String s) {
        String[] splitted = s.split("\\.");
        try {
            return splitted[1].length();
        } catch (Exception e) {
            return 0;
        }
    }
    private static int fibonacci(int k) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        for (int i = 3; i <= k+1; i++) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }
    private static boolean isValid(String s) {

        return s.matches("[0-9]{5}");
    }

    private static boolean isStrangePair(String s1, String s2) {
        if (s1.equals("") || s2.equals("")){
            return true;
        } else if (s1.charAt(0)== s2.charAt(s2.length()-1) && s2.charAt(0) == s1.charAt(s1.length()-1)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isSuffix(String s1, String s2) {

        return s1.endsWith(s2.substring(1));
    }

    private static boolean isPrefix(String s1, String s2) {

        return s1.startsWith(s2.substring(0, s2.length()-2));
    }

    private static int boxSeq(int i) {
        int s = 0;
        for (int step = 1; step <= i; step++) {
            if (step % 2 != 0)
                s += 3;
            else
                s -= 1;
        }
        return s;
    }

}
