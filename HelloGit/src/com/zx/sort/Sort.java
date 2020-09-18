package com.zx.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{50, 8, 1, 3, 4, 79, 6, 5, 9, 57, 999, 9, 4, 70, 95, 79, 83, 29, 0, 54, 71, 29, 50, 7, 32, 7, 58, 9, 635, 27, 48, 96, 52, 0, 78, 97};
//        bobbleSort(arr);
//        select_sort(arr);
//        insert_sort(arr);
//        shell_sort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        merge_sort(arr, 0, arr.length - 1);
        minHead_sort(arr);
        traversal(arr);
    }

    public static void traversal(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // 交换数组中某两个下标的值
    private static void exchange(int[] arr, int i, int j) {
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

    // 快速排序(挖坑填补+分治)
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int num = arr[i];
        while (i < j) {
            while (i < j && arr[j] > num) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < num) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = num;
        quickSort(arr, left, j - 1);
        quickSort(arr, i + 1, right);
    }

    // 归并排序
    public static void merge_sort(int[] arr, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            merge_sort(arr, first, middle);
            merge_sort(arr, middle + 1, last);
            mergeArray(arr, first, middle, last);
        }
    }

    // 合并 ：将两个序列a[first~middle],a[middle+1~end]合并
    private static void mergeArray(int[] arr, int first, int middle, int last) {
        int i = first;
        int j = middle + 1;
        int k = 0;
        int length = last - first + 1;
        int[] temp = new int[length];
        while (i <= middle && j <= last) {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                j++;
                k++;
            } else {
                temp[k] = arr[i];
                i++;
                k++;
            }
        }
        while (i <= middle) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= last) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int p = 0; p < k; p++) {
            arr[first + p] = temp[p];
        }
    }

    // 堆排序
    public static void minHead_sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < arr.length - 1; i++,length--) {
            minHead(arr,length);
        }
    }
    // 构建最小堆
    private static void minHead(int[] arr, int length) {
        int i = length / 2 - 1; // 第一个非叶子结点
        while (i >= 0) {
            int j = 2 * i + 1;
            if (j + 1 < length && arr[j] > arr[j + 1]) {
                j++;
            }
            if (arr[i] > arr[j]) {
                exchange(arr, i, j);
            }
            i--;
        }
        exchange(arr, 0, length - 1);
    }

}

