package com.tzx.sort;

import com.tzx.utils.Util;

/**
 * Created by tanzhenxing on 17-4-28.
 *
 * 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上有较大提高。
 *
 * 开始时gap的值比较大，子序列中的对象较少，排序速度较快；随着排序进展，gap值逐渐变小，子序列中对象个数逐渐变多，但由于进过前面操作后，大多数对象已基本有序，因此排序速度仍然会较快。
 * gap的取法有多种：
 *      适当的选择增量序列可使希尔排序较其他算法更有效。
 *      Shell提出取gap=|n/2|,gap=|gap/2|,直到gap=1.
 *      事实上，gap每次缩小3倍的效果要更好些。
 */
public class ShellSort implements Sort{

    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) return;
        int i, j, gap;
        int n = a.length;
        //计算步长
        for (gap = n / 2; gap > 0; gap /= 2) {
            Util.println(gap);
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < n; j += gap) {
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp) {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
                }
            }
            Util.println(a);
        }
    }
}
