package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/15 0015 18:55
 * 描述：插入排序
 */
public class InsertSort2 {


    public static void sort(Comparable[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i;j > 0;j--){
                /**
                 * 注意升降序的顺序
                 */
                if (arr[j].compareTo(arr[j-1]) < 0)//如果后面的数大于前面的数，交换位置
                    swap(arr,j,j-1);
                else break;
            }
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
        SortUtil.testSort("wangyu.sort.InsertSort2", array);
//        InsertSort.sort(array);
        SortUtil.printArray(array);

        System.out.println(SortUtil.isSort(array));

    }
}
