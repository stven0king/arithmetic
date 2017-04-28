package com.tzx.sort;

/**
 * Created by tanzhenxing on 17-4-27.
 *
 * 每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子序列中的适当位置，直到全部记录插入完成为止。
 * 初始时，a[0]自成1个有序区，无序区为a[1...n-1]。令i=1
 * 将a[i]并入当前的有序区a[0...i-1]中形成a[0...i]的有序区间
 * i++并重复第二步直到i==n-1。排序完成。
 */
public class BinaryInsertSort implements Sort {
    @Override
    public int[] sort(int[] a) {
        if (a == null || a.length <= 1) return a;
        int temp, left, right, middle;
        for (int i = 1, size = a.length; i < size; i++) {
            temp = a[i];
            left = 0;
            right = i - 1;

            //寻找合适的位置
            while (left <= right) {
                middle = (left + right) / 2;
                if (a[middle] > temp) {
                    right = middle -1;
                } else {
                    left = middle + 1;
                }
            }

            //如找到一个合适的位置
            //将比a[i]大的数据向后移动
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
        }
        return a;
    }
}
