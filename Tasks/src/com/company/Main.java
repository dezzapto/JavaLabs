package com.company;
import java.math.BigInteger;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        int a, b, c, result;
        String symb;
        boolean res;

        System.out.println("Choose any task from 1 to 10");
        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();

        switch (choose) {
            case  (1):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                result = remainder(a, b);

                System.out.println("Result is " + result);
                break;
            case (2):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                result = triAria(a, b);

                System.out.println("Result is " + result);
                break;
            case (3):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                System.out.println("Enter c");
                scan = new Scanner(System.in);
                c = scan.nextInt();

                result = animals(a, b, c);

                System.out.println("Result is " + result);
                break;
            case (4):
                System.out.println("Enter prob");
                scan = new Scanner(System.in);
                float prob = scan.nextFloat();

                System.out.println("Enter prize");
                scan = new Scanner(System.in);
                float prize = scan.nextFloat();

                System.out.println("Enter pay");
                scan = new Scanner(System.in);
                float pay = scan.nextFloat();

                res = profitableGamble(prob, prize, pay);

                System.out.println("Result is " + res);
                break;
            case (5):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                System.out.println("Enter N");
                scan = new Scanner(System.in);
                c = scan.nextInt();

                String answ = operation(a, b, c);

                System.out.println("Result is " + answ);
                break;
            case (6):
                System.out.println("Enter char or string");
                scan = new Scanner(System.in);
                symb = scan.nextLine();

                BigInteger acsii = ctoa(symb);

                System.out.println("ACSII is " + acsii);
                break;
            case (7):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                result = addUpTo(a);

                System.out.println("Result is " + result);
                break;
            case (8):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter b");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                result = nextEdge(a, b);

                System.out.println("Result is " + result);
                break;
            case (9):
                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

               int nums[] = new int[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums[i] = scan.nextInt();
                }

                result = sumOfCubes(nums);

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

                res = abcmath(a, b, c);
                System.out.println("Result is " + res);
                break;
           // default:
              //  КодВыбораПоУмолчанию;
              //  break;
        }
    }

    public static int remainder(int a, int b) {
        int result = a % b;
        return result;
    }

    public static int triAria(int a, int b) {
        int result = (a * b) / 2;
        return result;
    }

    public static int animals(int a, int b, int c) {
        int result = (a * 2) +(b * 4) + (c * 4);
        return result;
    }

    public static boolean profitableGamble(float prob, float prize, float pay) {
        if((prob * prize) > pay)
            return true;
        else
            return false;
    }

    public static String operation(int a, int b, int N) {
        String result = "none";

        if(a + b == N)
            result = "added";
        else if (a - b == N)
            result = "substracted";
        else if (a * b == N)
            result = "multiplicated";
        else if (a / b == N)
            result = "divided";
        return result;
    }

    public static BigInteger ctoa(String symb) {
        StringBuilder sb = new StringBuilder();
        for(char c : symb.toCharArray())
            sb.append((int)c);
        BigInteger mInt = new BigInteger(sb.toString());
            return mInt;
    }

    public static int addUpTo(int a) {
        int result = 0;

        for(int i = 1; i <= a; i++){
            result = result + i;
        }

        return result;
    }

    public static int nextEdge(int a, int b) {
        int result = a + b - 1;
        return result;
    }

    public static int sumOfCubes(int nums[]) {
        int result = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++){
            result = result + pow(nums[i], 3);
        }

        return result;
    }
    public static int pow(int value, int powValue) {
        return (int) Math.pow(value, powValue);
    }

    public static boolean abcmath(int a, int b, int c) {
        int result = a;

        for(int i = 0; b < i; i++){
            result = result + c;
        }

        if(result % c == 0)
        return true;
        else
            return false;
    }

}
