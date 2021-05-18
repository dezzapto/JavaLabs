package com.company;
import java.math.BigInteger;
import java.util.*;
import java.lang.String;
import java.lang.Character;

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
                System.out.println("Enter n");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Enter k");
                scan = new Scanner(System.in);
                b = scan.nextInt();

                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                str = essay(a, b, str);

                System.out.println("Result is " + str);
                break;
            case (2):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                str = Arrays.toString(split(str));

                System.out.println("Result is " + str);
                break;
            case (3):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                str = toCamelCase(str);
                str1 = toSnakeCase(str);

                System.out.println("Camel is " + str);
                System.out.println("Snake is " + str1);
                break;
            case (4):
                System.out.println("Enter array length");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                double nums[] = new double[a];

                for(int i = 0; i < a; i++){
                    System.out.println("Enter " + (i + 1) + " num of array");
                    scan = new Scanner(System.in);
                    nums[i] = scan.nextDouble();
                }

                str = overTime(nums);

                System.out.println("Result is " + str);
                break;
            case (5):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter second string");
                scan = new Scanner(System.in);
                str1 = scan.nextLine();

                System.out.println("Result is " + BMI(str, str1));
                break;
            case (6):
                System.out.println("Enter a");
                scan = new Scanner(System.in);
                a = scan.nextInt();

                System.out.println("Result is " + bugger(a));
            case (7):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Result is " + toStarShorthand(str));
                break;
            case (8):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter second string");
                scan = new Scanner(System.in);
                str1 = scan.nextLine();

                System.out.println("Result is " + doesRhyme(str, str1));
                break;
            case (9):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter second string");
                scan = new Scanner(System.in);
                str1 = scan.nextLine();

                System.out.println("Result is " + trouble(str, str1));
                break;
            case (10):
                System.out.println("Enter string");
                scan = new Scanner(System.in);
                str = scan.nextLine();

                System.out.println("Enter char");
                scan = new Scanner(System.in);
                Character end = scan.next().charAt(0);

                System.out.println("Result is " + countUniqueBooks(str, end));
                break;
        }
    }

    public static String essay(int n, int k, String text) {
        String[] words = text.split(" ");
        String currentString = "";
        String result = "";
        boolean added = false;
        if (n > words.length)
            return "err";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (currentString.replace(" ", "").length() + word.length() <= k)
                currentString += word + " ";
            else {
                result += currentString + "\n";
                currentString = word + " ";
            }
        }
        if (currentString.length() > 0) {
            result += currentString + "\n";
        }
        return result;
    }

    public static String[] split(String str) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int lastIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            else {
                count--;
            }
            if (count == 0) {
                list.add(str.substring(lastIndex, i + 1));
                lastIndex = i + 1;
            }
        }
        String[] strs = new String[list.size()];
        return strs = list.toArray(strs);
    }

    public static String toCamelCase(String str) {
        String []arr=str.split("_");
        String new_str=arr[0];
        for(int i=1;i<arr.length;i++) {
            new_str+=(arr[i].substring(0,1).toUpperCase()+arr[i].substring(1));
        }
        return new_str;
    }

    public static String toSnakeCase(String str) {
        String new_str="";
        for(int i=0;i<str.length()-1;i++) {
            if(str.substring(i,i+1).matches("[A-Z]")) {
                new_str=new_str + "_" + str.substring(i,i+1).toLowerCase();
            }else {
                new_str+=str.substring(i,i+1);
            }
        }
        new_str+=str.substring(str.length()-1);
        return new_str;
    }

    public static String overTime(double[] arr) {
        double sum=0.0;
        for(double i=arr[0]; i<arr[1]; i+=0.25){
            if(i<17){
                sum += 0.25 * arr[2];
            }else if(i>=17){
                sum += 0.25 * arr[2] * arr[3];
            }
        }
        return String.format("$%.2f", sum);
    }

    private static String BMI(String weight, String height) {
        String[] weig = weight.split(" ");
        String[] heig = height.split(" ");
        String result = "";

        double kilos = weig[1].equals("pounds") ? Double.parseDouble(weig[0]) * 0.453592 : Double.parseDouble(weig[0]);
        double meters = heig[1].equals("inches") ? Double.parseDouble(heig[0]) * 0.0254 : Double.parseDouble(heig[0]);

        double val = kilos / (meters * meters);
        val = Math.round(val * 10.0)/10.0;

        if (val < 18.5) result += val+" Underweight";
        if (val >= 18.5 && val <= 24.5) result += val + " Normal weight";
        if (val >= 25 && val <= 29.9) result += val + " Overweight";
        if (val >= 30) result += val + " Obesity";
        return result;
    }

    public static int bugger(int num) {
        int count = 0;

        while(Integer.valueOf(num).toString().toCharArray().length > 1){
            int newNum = 1;
            for(char c : Integer.valueOf(num).toString().toCharArray()){
                newNum *= Integer.valueOf(String.valueOf(c));
            }
            num = newNum;
            count += 1;
        }
        return count;
    }

    public static String toStarShorthand(String input) {
        String result = "";
        int count = 1;
        char currentChar = 'a';
        for (int i = 1; i < input.length(); i++) {
            currentChar = input.charAt(i - 1);
            if (currentChar == input.charAt(i)) count++;
            else {
                if (count > 1) result += currentChar + "*" + count;
                else result += currentChar;
                count = 1;
                if (i == input.length() - 1) result += String.valueOf(input.charAt(input.length() - 1));
            }
        }
        if (count != 1) result += currentChar + "*" + count;
        return result;
    }

    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.replaceAll("\\p{Punct}","");
        str2 = str2.replaceAll("\\p{Punct}","");
        char lastletter=str1.charAt(str1.length()-1);
        char lastletter1=str2.charAt(str2.length()-1);

        if (Character.toLowerCase(lastletter1)==Character.toLowerCase(lastletter))
            return true;
        else
            return false;
    }

    public static boolean trouble(String number1, String number2) {
        int count1 = 0;
        int count2 = 0;
        String currentChar = "";
        for (int i = 0; i < number1.length() - 1; i++) {
            currentChar = String.valueOf(number1.charAt(i));
            if (currentChar.equals(String.valueOf(number1.charAt(i + 1))))
                count1++;
            else count1 = 0;
            if (count1 == 2) {
                count2 = 0;
                for (int j = 0; j < number2.length(); j++) {
                    if (currentChar.equals(String.valueOf(number2.charAt(j))))
                        count2++;
                    else count2 = 0;
                    if (count2 == 2) return true;
                }
            }
        }
        return false;
    }

    public static int countUniqueBooks(String book, Character end) {
        Map<Character, Boolean> chars = new HashMap<Character, Boolean>();
        boolean parse = false;
        for (char c: book.toCharArray()) {
            if (parse && c != end) chars.put(c, true);
            if (c == end) {
                if (parse) parse = false;
                else parse = true;
            }
        }
        return chars.size();
    }

}
