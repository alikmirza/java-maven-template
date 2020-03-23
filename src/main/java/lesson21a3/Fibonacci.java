package lesson21a3;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int p1 = 0;
        int p2 = 1;

        System.out.print("Up to : " + n + ": ");

        while (p1 <= n)
        {
            System.out.print(p1 + " + ");

            int sum = p1 + p2;
            p1 = p2;
            p2 = sum;
        }
    }
}
