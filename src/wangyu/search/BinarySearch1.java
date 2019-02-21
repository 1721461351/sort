package wangyu.search;

import wangyu.merge.MergeSort1;
import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/17 0017 18:29
 * 描述：二分搜索递归实现
 */
public class BinarySearch1 {

    public static int sort(Integer[] arr, int data) {
        return binary(arr,0,arr.length-1,data);
    }

    private static int binary(Integer[] arr, int l, int r, int data) {
        if (l > r)
            return -1;

        int mid = (l+r)/2;

        if (arr[mid] == data)
            return mid;
        else if (arr[mid] > data)//在左侧
            return binary(arr,l,mid - 1,data);
        else
            return binary(arr,mid+1,r,data);
    }

    public static void main(String[] args) {
        MergeSort1 mergeSort = new MergeSort1();
        Integer[] array = SortUtil.RandomArray(10, 0, 10);
        mergeSort.sort(array);
        SortUtil.printArray(array);
        System.out.println(BinarySearch1.sort(array,2));
    }
}
