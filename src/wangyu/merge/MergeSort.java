package wangyu.merge;

import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/14 0014 14:08
 * 描述：归并排序
 */
public class MergeSort {

    /**
     *
     * @param arr
     * @param n 对n个元素进行排序
     */
    public void sort(Integer[] arr,int n){

        __mergeSort(arr,0,n-1);

    }

    //使用递归对[l,r]的范围进行排序
    private void __mergeSort(Integer[] arr,int l,int r){

        int mid = (l+r)/2;
        if (l >=r)
            return;
        else {
            __mergeSort(arr, 0, mid);
            __mergeSort(arr,mid+1,r);
            //对两段进行归并排序
            merge(arr,l,mid,r);
        }
    }

    /***
     * 将[l,mid]到[mid+1,r]进行归并
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private void merge(Integer[] arr, int l, int mid, int r) {
        //创建一个临时的数组
        Integer[] temp = new Integer[r-l+1];
        for (int i = l;i <= r;i++){//因为是闭区间的时候
            //temp从0开始，而arr是从l开始，相差l
            temp[i-l] = arr[i];
        }
        int i = l, j = mid+1;
        for (int k = l;k < r;k++){

            if (i > mid){
                arr[k] = temp[j-l];
                j++;
            }
            else if (j > r){
                arr[k] = temp[i-l];
                i++;
            }
            else if (temp[i-l] < temp[j-l]){
                arr[k] = temp[i-l];
                i++;
            }
            else  {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Integer[] array = SortUtil.RandomArray(10, 0, 10);
        mergeSort.sort(array,10);
        SortUtil.printArray(array);
    }
}
