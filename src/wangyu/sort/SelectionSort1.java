package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/12 0012 10:37
 * 描述：
 */
public class SelectionSort1 {

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // 寻找[i, n)区间里的 最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                // 使用compareTo方法比较两个Comparable对象的大小
                if( arr[j].compareTo( arr[minIndex] ) > 0 )
                    minIndex = j;

            swap( arr , i , minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 14, 8, 18, 0, 11};
        SelectionSort1.sort(arr);
        SortUtil.printArray(arr);
        System.out.println("---------------");
        Integer[] array = SortUtil.RandomArray(100, 0, 100);
        SelectionSort1.sort(array);
        System.out.println(SortUtil.isSort(array));
        SortUtil.printArray(array);

    }
}
