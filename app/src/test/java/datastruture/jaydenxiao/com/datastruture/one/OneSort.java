package datastruture.jaydenxiao.com.datastruture.one;

import org.junit.Test;

/**
 * 类名：OneSort.java
 * 描述：冒泡与选择排序算法（蛮力法：适用于数据量足够小，比如斗牛游戏的牌面排序）
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class OneSort {
    @Test
    public void test() {
        int[] arrays = new int[]{5, 6, 7, 5, 1, 3, 4, 9};
        for (int array : arrays) {
            System.out.print(array);
        }
//        bubbleSort(arrays);
        selectSort(arrays);
        System.out.println();
        for (int array : arrays) {
            System.out.print(array);
        }
    }

    /**
     * 冒泡排序（最大的数上升）
     * 7 8 4 5 6 9 1 2 3
     * 8
     *
     * @param arrays
     */
    private void bubbleSort(int[] arrays) {
        for (int j = arrays.length - 1; j > 0; j--) {
            boolean flag = true;
            for (int i = 0; i < j; i++) {
                if (arrays[i] > arrays[i + 1]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 选择排序(最小的数沉底)
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            int index = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[index] > array[i]) {
                    index = i;
                }
            }
            if(index!=j) {
                int temp = array[j];
                array[j] = array[index];
                array[index] = temp;
            }
        }
    }
}
