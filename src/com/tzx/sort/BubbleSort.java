package com.tzx.sort;

/**
 * Created by tanzhenxing on 17-4-26.
 * 冒泡排序：以从小到大排序举例：设数组长度为N。
 * 比较相邻的前后两个数据，如果前面数据大于后面的数据，就将两个数据交换。i=0
 * 对数组的第N个数据到第i个数据进行一次遍历后，最大的一个数据就“浮”到数据第i个位置。
 * i=i++,如果i不为N-1就重复前面二步，否则排序完成
 *
 *
 * 外层循环次数为n-1
 * 内层循环次数与i相关，随着i的变大而主次减少，从最初的n-1到最后的1次。
 * 总的次数为O（n*n）
 * 事实上，冒泡排序算法并没有说明价值，是一种相对比较慢的排序
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] a) {
        if (a == null || a.length <= 1) return a;
        int i,j;
        int n = a.length;
        for (i = 0; i < n - 1; i++) {
            for (j = n - 1; j > i; j--) {
                if (a[j-1] > a[j]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a;
    }

    /**
     * 改进方法：设置一个标志，如果这一趟发生了交换，则为true，否则为false。
     * 明显如果有一趟没有发生交换，说明排序已经完成。
     * @param a
     * @return
     */
    public int[] sortOpt(int[] a) {
        if (a == null || a.length <= 1) return a;
        int i,j;
        int n = a.length;
        boolean swapChanged = true;
        for (i = 0; i < n - 1 && swapChanged; i++) {
            swapChanged = false;
            for (j = n - 1; j > i; j--) {
                if (a[j-1] > a[j]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                    swapChanged = true;
                }
            }
        }
        return a;
    }
}
