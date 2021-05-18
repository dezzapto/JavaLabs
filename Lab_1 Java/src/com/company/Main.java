package com.company;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        System.out.println("Введите положительное число от 2 до 100 ");
        Scanner s = new Scanner(System.in);
        int n = 0;
        for(int i = 0 ; 2 > i || n > 100; ){
            n = s.nextInt();
            i = n;
            if(2 > i || n > 100)
                System.out.println("Число должно быть положительным от 2 до 100");
        }
        System.out.println("Вы ввели " + n);

        for (int p = 2; p < n; p++) {
            boolean ans = IsPrime(p);
            if(ans == true)
                System.out.println(p + " ");
        }

    }
    public static boolean IsPrime(int n){


        for (int i = 2; i < n; i++)
            if(n % i == 0)
                return false;
        return true;
    }

}