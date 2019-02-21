package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/12 0012 7:38
 * 描述：选择排序(从大到小的顺序)
 * 思路：
 * 1，找到最小值
 * 2，把最小值和第i个位置交换
 * 注意：
 *      在交换的时候，应该在第一重的时候。
 */
public class SelectionSort {

    public static void sort(Comparable arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            //从i+1的位置开始
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[maxIndex]) > 0){
                    //找到了最大的值
                    maxIndex = j;
//                    System.out.println(j);
                }
            }
            //此方法是在第一重循环里
            swap(arr, i, maxIndex);

        }
    }

    private static void swap(Object[] arr, int j, int maxIndex) {
        Object t = arr[j];
        arr[j] = arr[maxIndex];
        arr[maxIndex] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 14, 8, 18, 0, 11};
        SelectionSort.sort(arr);
        System.out.println(SortUtil.isSort(arr));
        SortUtil.printArray(arr);
        System.out.println("---------------");
        Integer[] array = SortUtil.RandomArray(1000, 0, 5);
        SelectionSort.sort(array);
        System.out.println(SortUtil.isSort(array));
        SortUtil.printArray(array);

        System.out.println("-----------------");
        Integer[] array1 = SortUtil.RandomArray(10000, 0, 10000);
        SortUtil.testSort("wangyu.sort.SelectionSort",array1);

    }
}
