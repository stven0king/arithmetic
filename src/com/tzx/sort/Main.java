package com.tzx.sort;

import com.tzx.utils.Util;

/**
 * Created by tanzhenxing on 17-4-26.
 */
public class Main extends Util{
    public static void main(String[] args) {
        Sort sort = new SelectSort();
        int[] a = new int[]{1, 3, 5, 7, 9, 12, 32, 1, 14};
        println(a);
        a =sort.sort(a);
        println(a);
    }
}