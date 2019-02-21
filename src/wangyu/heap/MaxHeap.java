package wangyu.heap;

import java.util.Arrays;

/**
 * 作者：王宇
 * 创建时间：2019/2/16 0016 17:57
 * 描述：最大堆
 */
public class MaxHeap {

    private int size;
    private Integer[] array;
    private int capacity;
    public MaxHeap(int capacity) {
        //根节点从1开始，所以初始化容量的时候要加1
        array = new Integer[capacity + 1];
        size = 0;
        this.capacity = capacity;
    }


    public MaxHeap(Integer[] arr){
        array = new Integer[arr.length+1];
        capacity = arr.length+1;
        for (int i = 0;i <capacity;i++ ){
            array[i+1] = arr[i];
        }
        size = capacity;
        for (int i = size/2;i >= 1;i++)
            shiftDown(i);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer getParent(int index) {
        return index / 2;
    }

    public Integer getLeftChildren(int index) {
        return index * 2;
    }

    public Integer getRightChildren(int index) {
        return (index * 2 + 1);
    }

    /**
     * 向最大堆中添加元素
     *
     * @param e
     */
    public void insert(Integer e) {
        array[size + 1] = e;
        size++;
        //上浮操作
        shiftUp(size);
    }

    private void shiftUp(int k) {


        //这里要判断k/2处是不是为0
        while (array[k/2]!=null&&array[k] > array[k / 2]) {
//            if (k == 1) {
//                return;
//            } else {
                swap(array, k, k / 2);//交换位置
                k = k / 2;//索引上移
//            }
        }
    }


    private void swap(Integer[] array, int k, int i) {
        Integer t = array[k];
        array[k] = array[i];
        array[i] = t;
    }

    /**
     * 推出一个元素
     *
     */
    public Integer push(){
        Integer max = array[1];
        swap(array,size,1);
        size--;
        shiftDown(1);//这里要传的是索引值
        return max;
    }

    private void shiftDown(Integer k) {

        while (2*k <= size){//说明有左孩子
            int j = 2 * k;//先把把左孩子存起来
            if (j+1<=size && array[j+1] > array[j]){//说明有右孩子,并且右孩子数大于左孩子
                j += 1;//说明右孩子比左孩子大，这是右孩子的索引
            }
            if (array[j] < array[k])//如果k位置的索引比左右孩子大，不交换
                break;
            swap(array,j,k);
            k = j;
        }
    }

    private Integer max(Integer a,Integer b){
        if (a > b)
            return a;
        else return b;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(7);
        maxHeap.insert(12);
        maxHeap.insert(10);
        maxHeap.insert(30);

        System.out.println(maxHeap.getSize());

        System.out.println(maxHeap.push());
        System.out.println(maxHeap.push());
        System.out.println(maxHeap.push());
        System.out.println(maxHeap.push());
        System.out.println(maxHeap.push());

    }
}
