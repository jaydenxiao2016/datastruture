package datastruture.jaydenxiao.com.datastruture.lsn_16;

import org.junit.Test;

/**
 * 类名：
 * 描述：插入排序
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class 插入排序 {
    @Test
    public void test(){
        int[] array=new int[]{2,3,4,5,6,7,1,8,9};
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }

    //直接插入排序
    public void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int j=i;
            int target=array[j];
            while(j>0 && target<array[j-1]){
                array[j]=array[j-1];
                j--;
            }
            array[j]=target;
        }
    }
}







