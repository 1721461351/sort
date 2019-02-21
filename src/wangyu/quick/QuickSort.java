package wangyu.quick;

import wangyu.merge.MergeSort;
import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/15 0015 12:07
 * 描述：快速排序的基本实现
 *
 * // 比较Merge Sort和Quick Sort两种排序算法的性能效率
 * // 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
 * // Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
 *
 * // 对arr[l...r]部分进行partition操作
 * // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
 */
public class QuickSort {

    public static void sort(Integer[] arr){
        __sort(arr,0,arr.length-1);
    }

    private static void __sort(Integer[] arr, int l,int r) {
        if (l >= r)
            return;

        int p = partition(arr,l,r);
        //这里是p-1，不是p
        __sort(arr,l,p-1);
        __sort(arr,p+1,r);
    }

    /***
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(Integer[] arr, int l, int r) {

        int v = arr[l];
        int j = l;
        for (int i = l+1;i <= r;i++){
            if (arr[i] < v){
                swap(arr, i, j + 1);
                //不要忘记j++
                j++;
            }
        }
        swap(arr,l,j);
        return j;
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
//        MergeSort mergeSort = new MergeSort();
        Integer[] array = SortUtil.RandomArray(10, 0, 10);
        SortUtil.printArray(array);

        QuickSort.sort(array);
        SortUtil.printArray(array);
    }
}
