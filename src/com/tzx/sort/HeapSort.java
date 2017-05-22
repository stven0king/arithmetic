package com.tzx.sort;

import com.tzx.utils.Util;

/**
 * Created by tanzhenxing on 17-5-12.
 */
public class HeapSort implements Sort {
    @Override
    public void sort(int[] a) {
        int n = a.length;
        initHeap(a, true);
        sortHeap(a, true);

    }

    private void initHeap(int[] a, boolean isMax) {
        int n = a.length;
        if (isMax) {
            for (int i = 0; i < n; i++) {
                maxHeapAddNumber(a, i, a[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                minHeapAddNumber(a, i, a[i]);
            }
        }
    }

    private void sortHeap(int[] a, boolean isMax) {
        int n = a.length;
        if (isMax) {
            for (int i = n -1; i > 0; i--) {
                Util.swap(a, 0, i);
                maxHeapFixDown(a, 0, i);
            }
        } else {
            for (int i = n -1; i > 0; i--) {
                Util.swap(a, 0, i);
                minHeapFixDown(a, 0, i);
            }
        }
    }

    private void minHeapAddNumber(int[] a, int n, int nNum) {
        a[n] = nNum;
        minHeapFixup(a, n);
    }

    //建堆
    //新加入ｉ节点，其父节点为（i-1）2
    private void minHeapFixup(int[] a, int i) {
        int j, temp;
        temp = a[i];
        j = (i -1) / 2;//父节点
        while(j >= 0 && i != 0) {
            if (a[j] <= temp) {
                break;
            }
            a[i] = a[j];//把较大的子节点往下移动，替换它的子节点
            i = j;
            j = (i - 1) / 2;
        }
        a[i] = temp;
    }

    //删除元素
    //按定义，堆中每次都只能删除第0个数据。为了便于重建堆，实际的错坐是将最后一个数据的值付给根节点，然后再从根节点开始进行一次从上向下的调整。
    //调整时先在左右儿子节点中找到最小的，如果父节点币这个最小的子节点还小说明不需要调整了，反之将父节点和它交换后再考虑后面的节点。
    //相当于从根节点将一个数据的“下沉过程”。
    private void minHeapFixDown(int[] a, int i, int n) {
        int j, temp;
        temp = a[i];
        j = 2 * i + 1;
        while (j < n) {
            //在左右孩子中找最小的
            if (j + 1 < n && a[j + 1] < a[j]) {
                j++;
            }
            if (a[j] >= temp) {
                break;
            }
            a[i] = a[j];    //把较小的子节点往上移动，替换它的父节点
            i = j;
            j = 2 * i + 1;
        }
        a[i] = temp;
    }

    private void maxHeapAddNumber(int[] a, int n, int nNum) {
        a[n] = nNum;
        maxHeapFixup(a, n);
    }

    private void maxHeapFixup(int[] a, int i) {
        int j, temp;
        temp = a[i];
        j = (i - 1) / 2;//父节点
        while (j >= 0 && i != 0) {
            if (a[j] >= temp) {
                break;
            }
            a[i] = a[j];    //把较小的子节点往下移动，替换它的子节点
            i = j;
            j = (i - 1) /2;
        }
        a[i] = temp;
    }

    private void maxHeapFixDown(int[] a, int i, int n) {
        int j, temp;
        temp = a[i];
        j = 2 * i + 1;
        while (j < n) {
            //在左右行子中找到最大的
            if (j + 1 < n && a[j + 1] > a[j]) {
                j++;
            }
            if (a[j] <= temp) {
                break;
            }
            a[i] = a[j];//把较大的子节点往上移动，替换它的父节点
            i = j;
            j = 2 * i + 1;
        }
        a[i] = temp;
    }

}
