package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/12 0012 11:30
 * 描述：插入排序
 */
public class InsertSort {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //这里写错了
//            for (int j = i; j > 0; j--)
//                //比较的是j和j-1的值，而不是i和i-1的值
//                if (arr[j].compareTo(arr[j - 1]) > 0)
//                    swap(arr, j, j - 1);
//                else
//                    break;


            for (int j = i;j > 0&& arr[j].compareTo(arr[j-1]) > 0;j--)
                swap(arr, j, j - 1);

        }
    }

    private static void swap(Object[] arr, int j, int maxIndex) {
        Object t = arr[j];
        arr[j] = arr[maxIndex];
        arr[maxIndex] = t;
    }


    public static void main(String[] args) {
        int n = 10000;
        Integer[] array = SortUtil.RandomArray(n, 0, n);
        SortUtil.testSort("wangyu.sort.InsertSort",array);
        SortUtil.printArray(array);
        InsertSort.sort(array);
        SortUtil.printArray(array);

//        SortUtil.testSort("wangyu.sort.InsertSort",array);
    }

}
