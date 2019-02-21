package wangyu.merge;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/15 0015 9:59
 * 描述：重新写归并排序
 */
public class MergeSort1 {

    public static void sort(Integer[] arr){
        __sort(arr,0,arr.length-1);
    }

    /***
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void __sort(Integer[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l+r)/2;
        __sort(arr,l,mid);
        __sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }


    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Integer[] arr, int l, int mid, int r) {
//        创建临时数组
//        Integer[] temp = new Integer[r - l + 1];
        Integer[] temp = new Integer[arr.length];

        for (int i =l;i <= r;i++){
            temp[i-l] = arr[i];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l;k <= r;k++){
            if (i > mid){
                arr[k] = temp[j-l];
                j++;
            }
            else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            }
            else if (temp[i-l]<temp[j-l]){//左半边所指元素<右半边所指的元素
                arr[k] = temp[i-l];
                i++;
            }
            else {
                arr[k] = temp[j-l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort1 mergeSort = new MergeSort1();
        Integer[] array = SortUtil.RandomArray(10, 0, 10);
        mergeSort.sort(array);
        SortUtil.printArray(array);
    }
}
