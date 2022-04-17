package com.mumz.test;

import java.util.ArrayList;
import java.util.List;

public class Misc {

    static void test(){
        try {
            System.exit(1);
        } catch (Exception exp) {
            System.out.printf("Exception");
        } finally {
            System.out.printf("Finally");
        }
    }


    public static void main(String[] args) {
//        test();
        System.out.printf("%-15s %03d %n", "java", 100);
        System.out.printf("%-15s %03d %n", "cpp", 65);
        /*Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf("%15s", s1);
            //Complete this line
        }
        System.out.println("================================");*/

//        Thread thread = new Thread()

        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(null);
        System.out.println(stringBuilder.length());
    }
}
