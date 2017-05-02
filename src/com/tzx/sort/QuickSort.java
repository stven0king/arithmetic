package com.tzx.sort;

/**
 * Created by tanzhenxing on 17-5-2.
 *
 * 快速排序：又成为划分排序，是迄今为止所又内排序算法中在平均情况下最快的一种。
 * 先从数列中取出一个数作为基准数
 * 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 再对左右间重复第二步，直到各区间只有一个数。
 *
 * 挖坑填数
 *
 * 快速排序是递归的，需要右一个栈存放每层递归调用时的指针和参数。
 * 最大递归调用层次数与递归数的高度一致，理想的情况为[log2(n+1)]。因此要求的存储开销为O(log2n)
 * 在最坏的情况，即待排序对象序列已经按其排序码从小到大排好序的情况下，其递归树成为单支树，每次划分只得到一个比上次少一个对象的子序列。
 *
 * 快速排序是一种不稳定的排序方法。
 *
 * 快速排序改进：
 *      寻找较好的轴值（三者取中法）
 *      当子数组的长度小于9时停止快速排序，然后再一次插入排序算发放进行最后的调整
 *      用栈模拟递归调用
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int l = low;
            int h = high;
            int pit = array[low];   //挖好第一个坑
            while (low < high) {
                while (low < high && array[high] > pit) {       //从右向左找第一个小于等于x的数
                    high--;
                }
                if (low < high) {
                    array[low++] = array[high];
                }
                while (low < high && array[low] <= pit) {       //从左向右找到第一个大于x的数
                    low++;
                }
                if (low < high) {
                    array[high--] = array[low];
                }
            }
            array[low] = pit;
            quickSort(array, l, low - 1);
            quickSort(array, low + 1, h);
        }

    }
}
