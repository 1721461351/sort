package wangyu.sort;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/19 0019 19:25
 * 描述：冒泡排序基本实现
 *  冒泡排序的基本思想:
 *      相邻的两个数相比较，如果第二个数小于第一个数，交换，
 *      这样经过第一轮，循环，最大的元素就浮出水面了，最后的元素不用管了，
 *      就这样循环下去，就拍完顺序了
 *
 *
 */
public class BubbleSort {

    public static void sort(Integer[] arr){
        for (int i = 0;i < arr.length;i++){
            for (int j = 0;j < arr.length - i - 1;j++){
                if(arr[j+1] < arr[j])//如果后一个数小，交换
                    swap(arr,j+1,j);//最后的数再后面
            }
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int n = 10;
        Integer[] array = SortUtil.RandomArray(n, 0, n);
//        SortUtil.testSort("wangyu.sort.BubbleSort",array);
//        SortUtil.printArray(array);
//        InsertSort.sort(array);
//        SortUtil.printArray(array);

//        SortUtil.testSort("wangyu.sort.InsertSort",array);

        BubbleSort.sort(array);
        SortUtil.printArray(array);
    }
}
