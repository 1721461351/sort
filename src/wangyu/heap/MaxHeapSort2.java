package wangyu.heap;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/20 0020 17:43
 * 描述：
 */
public class MaxHeapSort2 {

    public static void sort(int[] arr){
        MaxHeap2 heap = new MaxHeap2(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            //这里要把a[i] 再赋值回去
            arr[i] = heap.push();
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Integer[] array = SortUtil.RandomArray(n, 0, n);
        int[] data = new int[n];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        MaxHeapSort2.sort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
    }
}
