package com.tzx.utils;

/**
 * Created by tanzhenxing on 17-4-26.
 */
public class Util {
    public static void swap(int[] a, int i, int j) {
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public static void println(int[] a) {
        System.out.print("[" + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print("," + a[i]);
        }
        System.out.println("]");
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(int num) {
        System.out.println(num);
    }
}
