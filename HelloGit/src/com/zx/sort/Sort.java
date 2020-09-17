package com.zx.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 1, 8, 3, 2, 9, 6, 5, 10};
        bobbleSort(arr);
        traversal(arr);
    }

    public static void traversal(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // 交换数组中某两个下标的值
    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 冒泡排序
    public static void bobbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) return;
        }
    }
}

