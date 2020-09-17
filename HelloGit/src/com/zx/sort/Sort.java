package com.zx.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 1, 3, 4, 79, 6, 5, 9, 57, /*999, */9, 4, 70, 95, 79, 83, 29, 0, 54, 71, 29, 50, 7, 32, 7, 58, 9, 635, 27, 48, 96, 52, 0, 78, 97};
//        bobbleSort(arr);
//        select_sort(arr);
//        insert_sort(arr);
        shell_sort(arr);
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

    // 选择排序(假设i值前面是有序的)
    public static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    exchange(arr, i, j);
                }
            }
        }
    }

    // 插入排序(假设i值前是有序的)
    public static void insert_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                } else break;
            }
        }
    }

    // 希尔排序(分组后对每组进行插入排序，直到组数为一)
    public static void shell_sort(int[] arr) {
        int incre = arr.length;
        while (incre > 1) {
            incre /= 2;
            for (int k = 0; k < incre; k++) {
                for (int i = k; i < arr.length - incre; i += incre) {
                    for (int j = i; j >= k; j -= incre) {
                        if (arr[j] > arr[j + incre]) {
                            exchange(arr, j, j + incre);
                        } else break;
                    }
                }
            }
        }
    }
}

