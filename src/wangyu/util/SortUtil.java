package wangyu.util;

import java.lang.reflect.Method;

/**
 * 作者：王宇
 * 创建时间：2019/2/12 0012 9:42
 * 描述：
 */
public class SortUtil {
    /**
     * 打印输出数组
     * @param arr
     */
    public static void printArray(Comparable[] arr) {
        System.out.print("排序后的结果为：");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static Integer[] RandomArray(int n, int rangeL, int rangeR){
        assert rangeL <=rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0;i < arr.length;i++){
            //生成rangeL到rangeR之间的随机数
            arr[i] = new Integer((int) (Math.random()*(rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    /***
     * 判断是否升序排列
     * @param arr
     * @return
     */
    public static Boolean isSort(Comparable[] arr){
        for (int i = 0;i < arr.length - 1;i++){
            if (arr[i+1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }

    public static void testSort(String className,Comparable[] arr){
        try {
            // 利用了java的反射原理
            Class aClass = Class.forName(className);
            Method sort = aClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] o = new Object[]{arr};

            long startTime = System.currentTimeMillis();
             sort.invoke(null, o);
            long endTime = System.currentTimeMillis();
            assert isSort(arr);
            System.out.println(className+"用时"+(endTime-startTime));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
