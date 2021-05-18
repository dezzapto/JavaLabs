package com.company;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.lang.String;
import java.util.Collections;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int a, b, c, result;
        String str, str1;
        boolean res;


        System.out.println("Choose any task from 1 to 10");
        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();

        switch (choose) {
            case (1):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                System.out.println("Enter c");
                scan = new Scanner(System.in);
                c = scan.nextInt();

                result = solution(a, b, c);

                System.out.println("Result is " + result);
                break;
            case (2):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                result = findZip(str);

                System.out.println("Result is " + result);
                    break;
            case (3):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Result is " + checkPerfect(a));
                break;
            case (4):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                str = flipEndChars(str);

                System.out.println("Result is " + str);
                break;
            case (5):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Result is " + isValidHexCode(str));
                break;
            case (6):
                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                int nums[] = new int[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums[i] = scan.nextInt();
                }

                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                int nums1[] = new int[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums1[i] = scan.nextInt();
                }

                System.out.println("Result is " + same(nums, nums1));
                break;
            case (7):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Result is " + isKaprekar(a));
                break;
            case (8):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

               str = longestZero(str);

                System.out.println("Result is " + str);
                break;
            case (9):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                result = nextPrime(a);

                System.out.println("Result is " + result);
                break;
            case (10):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                System.out.println("Enter c");
                scan = new Scanner(System.in);
                c = scan.nextInt();

                System.out.println("Result is " + rightTriangle(a, b, c));
                break;
                }
        }

    private static int solution(int a, int b, int c) {
        int num = 0;
        double discriminant = b*b - 4*a*c;
        if (discriminant == 0) {
            num = 1;
        } else if (discriminant < 0) {
            num = 0;
        } else {
            num = 2;
        }
        return num;
    }

    private static int findZip(String s) {
        if (s.lastIndexOf("zip") != s.indexOf("zip") && s.indexOf("zip") != -1)
            return s.lastIndexOf("zip");
        return -1;
    }

    public static boolean checkPerfect(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                result += i;
            if (result > n)
                return false;
        }
        return (result == n);
    }

    public static String flipEndChars(String s) {
        if(s.length()<2)
            return "Incompatible.";

        if(s.charAt(0)==s.charAt(s.length()-1))
            return "Two's a pair.";

        char[] chars = s.toCharArray();
        char a = chars[0];
        chars[0] = chars[s.length()-1];
        chars[s.length()-1] = a;
        return String.valueOf(chars);
    }

    public static boolean isValidHexCode(String s) {

        return s.matches("#[a-fA-F0-9]{6}");
    }

    private static boolean same(int[] a1, int[] a2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int k: a1) {
            set1.add(k);
        }

        for (int l: a2) {
            set2.add(l);
        }

        return set1.size() == set2.size();
    }

    private static boolean isKaprekar(int x) {
        String result = String.valueOf((int) Math.pow(x, 2));
        int num1, num2 = 0;
        if (result.length() == 1)
            num1 = 0;
        else {
            num1 = Integer.parseInt(result.substring(0, (int) (result.length() / 2)));
            num2 = Integer.parseInt(result.substring((int) (result.length() / 2)));
        }
        return (num1 + num2 == x);
    }

    private static String longestZero(String s) {
        try {
            String[] split = s.split("1+");
            Arrays.sort(split);
            return split[split.length-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    private static int nextPrime(int num) {
        boolean prime = true;
        int next = num;
        while (true) {
            prime = true;
            for (int i = 2; i < next - 1; i++) {
                if (next % i == 0) prime = false;
            }
            if (prime) return next;
            next++;
        }
    }

    public static boolean rightTriangle(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        return (Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) == arr[2]);
    }

}
