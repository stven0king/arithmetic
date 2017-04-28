package com.tzx.sort;

/**
 * Created by tanzhenxing on 17-4-28.
 *
 * Merge Sort:将一个数组分成两个长度相等的子数组，为每一个子数组排序，然后再将它们合并成一个数组。这是一个递归的思想。
 * 归并的方法：
 * 1、首先将两个有序数组的第一元素进行比较，并将较小的作为合并数组中的最小值，把这个最小值从它所在的数组中取出并放到数组的第一个位置；
 * 2、继续用这种方法，不断比较两个数组中未被处理序列的最前端的元素，并将结果中较小的依次放入输出数组综合能够，职位不剩下输入元素为止。
 *
 * 归并排序算法的最佳、平均、最差运行时间均为O(nlog2n)
 * 归并排序算法需要占用的附加存储较多（需要另外一个与原待排序对象对象数组同样大小的辅助数组），且这两个数组之间需要额外的拷贝操作。者是归并算法的缺点。
 * 归并排序是一个稳定的排序方法。
 */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] a) {
        if (a == null || a.length <= 1) return ;
        int n = a.length;
        int[] p = new int[n];
        mergesort(a, 0, n -1, p);

    }

    public void mergesort(int[] a, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergesort(a, first, mid, temp);     //左边有序
            mergesort(a, mid + 1, last, temp);      //右边有序
            mergesort(a, first, mid, last, temp);       //再讲两个有序数组合并
        }
    }

    /**
     * 将有两个有序数列a[first...mid]和a[mid...last]合并
     * @param a
     * @param first
     * @param mid
     * @param last
     * @param temp
     */
    public void mergesort(int[] a, int first, int mid, int last, int[] temp) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[first + i] = temp[i];
        }
    }
}
