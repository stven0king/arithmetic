package com.tzx.sort;

import com.tzx.utils.Util;

/**
 * Created by tanzhenxing on 17-4-28.
 *
 * 直接选择排序和直接插入排序类似，都将数据分为有序区和无序区，所不同的是直接插入排序是将无序区的第一个元素直接插入到有序区以形成一个更大的有序区，而直接选择排序是从无序区选一个最小的元素直接放到有序区的最后。
 *
 * 初始时，数组全为无序区为a[0...n-1]。令i=0
 * 在无序区a[i...n-1]中选取一个最小的元素，将其与a[i]交换。交换之后a[0...i]就形成了一个有序区。
 * i++并重复第二步直到i==n-1。排序完成。
 *
 * 直接选择排序的排序码比较次数KCN与对象的初始排列无关。设整个待排序对象序列有n个对象，则第i趟选择具有最小排序 码对象所需的比较次数总是n-i-1次。总的排序码比较次数为n(n-1)/2
 * 直接选择排序的对象的移动次数与对象序列的初始排列有关：
 *      当初始状态本就是从小到大有序时（最优情况），对象的移动次数RMN=0，达到最少。
 *      最坏情况是每一趟都要进行交换，总的对象移动次数为RMN=n-1。
 */
public class SelectSort implements Sort {
    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) return ;
        int i, j, mMinIndex;
        int n = a.length;
        for (i = 0; i < n; i++) {
            mMinIndex = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[mMinIndex]) {
                    mMinIndex = j;
                }
            }
            if (i != mMinIndex) {
                Util.swap(a, i, mMinIndex);
            }
        }
    }
}
