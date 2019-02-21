package wangyu.heap;

/**
 * 作者：王宇
 * 创建时间：2019/2/20 0020 17:02
 * 描述：最大堆的二次实现
 */
public class MaxHeap2 {
    private int count;
    private int[] data;

    public MaxHeap2(int capacity){
        //索引从1开始
        data = new int[capacity + 1];
        count = 0;
    }

    public void insert(int element){
        data[count+1] = element;//先把要插入的元素放在最后一个位置
        count++;
        shiftUp(count);//元素上浮
    }

    //上浮操作
    private void shiftUp(int index) {
        //这里应该是索引，而不是对应的值，所以写错了
        while ((index/2)!=0&&data[index] > data[index/2]){
            swap(data,index,index/2);
            index = index/2;
        }
    }

    public int push(){
        int max = data[1];
        swap(data,count,1);

        count--;//缩容

        shiftDown(1);//下沉操作
        return max;
    }

    private void shiftDown(int k) {
        while (2*k <= count){//有左孩子
            int i = 2*k;//左孩子索引
            if (2*k+1 <= count && data[i+1] > data[i]){
                i = i+1;
            }
            if (data[i] < data[k])
                break;;
//            if (data[i] > data[k]){
                swap(data,i,k);
                k = i;
//            }
         }
    }


    private void swap(int[] array, int k, int i) {
        Integer t = array[k];
        array[k] = array[i];
        array[i] = t;
    }
}
