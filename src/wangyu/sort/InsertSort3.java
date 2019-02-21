package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/15 0015 19:21
 * 描述：
 */
public class InsertSort3 {

    public static void sort(Comparable[] arr){

        for (int i = 1; i < arr.length; i++) {
            int j;
            Comparable e = arr[i];
            //j前面的元素和e比较，不是j和e比较
            for (j = i;j > 0 && arr[j-1].compareTo(e) > 0;j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }


    private static void swap(Object[] arr, int j, int maxIndex) {
        Object t = arr[j];
        arr[j] = arr[maxIndex];
        arr[maxIndex] = t;
    }


    public static void main(String[] args) {
        int n = 10;
        Integer[] array = SortUtil.RandomArray(n, 0, n);
        SortUtil.testSort("wangyu.sort.InsertSort3", array);
        InsertSort3.sort(array);
        SortUtil.printArray(array);

        System.out.println(SortUtil.isSort(array));

    }
}
