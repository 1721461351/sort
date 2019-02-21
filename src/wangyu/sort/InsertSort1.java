package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/12 0012 12:40
 * 描述：插入排序的升级版
 */
public class InsertSort1 {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //这里写错了
//            for (int j = i; j > 0; j--)
//                //比较的是j和j-1的值，而不是i和i-1的值
//                if (arr[j].compareTo(arr[j - 1]) > 0)
//                    swap(arr, j, j - 1);
//                else
//                    break;

            int j;
            //先复制一个副本
            Comparable e = arr[i];
            for (j = i; j > 0 && arr[j - 1].compareTo(e) < 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;


        }
    }

    private static void swap(Object[] arr, int j, int maxIndex) {
        Object t = arr[j];
        arr[j] = arr[maxIndex];
        arr[maxIndex] = t;
    }


    public static void main(String[] args) {
        int n = 100;
        Integer[] array = SortUtil.RandomArray(n, 0, 100);
        SortUtil.testSort("wangyu.sort.InsertSort1", array);
        SortUtil.printArray(array);
        InsertSort.sort(array);
        SortUtil.printArray(array);

//        SortUtil.testSort("wangyu.sort.InsertSort",array);
    }

}
