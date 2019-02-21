package wangyu.heap;

import wangyu.sort.InsertSort;
import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/17 0017 10:17
 * 描述：最大堆排序
 */
public class MaxHeapSort1 {


    public static void sort(Integer[] arr) {
        MaxHeap heap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
            System.out.print(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            //这里要把a[i] 再赋值回去
            arr[i] = heap.push();
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] array = SortUtil.RandomArray(n, 0, n);
//        SortUtil.testSort("wangyu.heap.MaxHeapSort1",array);
//        SortUtil.printArray(array);
//        InsertSort.sort(array);
//        SortUtil.printArray(array);
        MaxHeapSort1.sort(array);
        SortUtil.printArray(array);

    }
}
