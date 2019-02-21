package wangyu.search;

import wangyu.merge.MergeSort1;
import wangyu.util.SortUtil;

/**
 * 作者：王宇
 * 创建时间：2019/2/17 0017 18:03
 * 描述：二分搜索经典查找算法
 */
public class BinarySearch {

    //查找data所在位置的索引
    public static int search(Integer[] arr,Integer data){
        int l = 0;
        int r = arr.length-1;

        while (l <= r){
            int mid = (l+r)/2;
            if (arr[mid].equals(data) ){//这里不能写等号啊
                return mid;
            }

            if (arr[mid] > data){//说明要查找的数在左边
//                mid =
                r = mid - 1;//注意：前面已经抛掉了mid这种情况，所以从mid-1算起。
            }
            else//说明要查找的数在右侧
                l = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        MergeSort1 mergeSort = new MergeSort1();
        Integer[] array = SortUtil.RandomArray(10, 0, 10);
        mergeSort.sort(array);
        SortUtil.printArray(array);
        System.out.println(BinarySearch.search(array,5));

    }
}
