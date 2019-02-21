package wangyu.merge;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/17 0017 7:45
 * 描述：归并排序第二版
 */
public class MergeSort2 {


    public static void sort(Comparable[] arr) {
        __sort(arr, 0, arr.length - 1);
    }

    private static void __sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        __sort(arr, l, mid);
        __sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }


    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] temp = new Comparable[arr.length];
        for (int i = l; i <= r; i++) {
            //给临时创建的数组赋值
            temp[i - l] = arr[i];
        }
        int j = mid + 1;
        int i = l;

        for (int k = l; k <= r; k++) {
            if (i > mid) {//左侧越界
                arr[k] = temp[j - l];
                j++;
            }
//            else if (j > l){
            else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            }
//            else if (arr[i].compareTo(arr[j]) > 0){//i大于j
            else if (temp[i - l].compareTo(temp[j-l]) > 0) {//这里写成了索引
                arr[k] = temp[j - l];
                j++;
            } else {
                arr[k] = temp[i - l];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort2 mergeSort = new MergeSort2();
        Integer[] array = SortUtil.RandomArray(10, 0, 10);
        mergeSort.sort(array);
        SortUtil.printArray(array);
    }
}
