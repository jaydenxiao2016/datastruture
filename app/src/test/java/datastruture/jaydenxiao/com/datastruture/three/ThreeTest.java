package datastruture.jaydenxiao.com.datastruture.three;

import org.junit.Test;

/**
 * 类名：ThreeTest.java
 * 描述：
 * 公司：北京海鑫科鑫高科技股份有限公司
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class ThreeTest {
    @Test
    public void test() throws Exception {
//        fun(3);
//        System.out.println(fact(5));
        hanoi(3, 1, 2, 3);
    }

    /**
     * 测试递归的思想
     */
    public void fun(int n) {  //3
        System.out.println(n);
        if (n < 0) {
            return;
        } else {
            fun(n - 1);
            System.out.println(n);
        }
    }

    /**
     * 1*2*3*4*5....     n!
     * 5!  = 5*4!      4! =  4*3!
     */
    public int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    /**
     * fibonacciSequence数列   8=7+6   7=6+5  6=5+4
     * 1   1  2  3  5  8   13  21  34  55  89  144......
     * 返回第n项
     */
    public int fibonacciSequence(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
        }
    }

    /**
     * @param n      盘子的个数
     * @param start  开始的柱子
     * @param middle 中介柱子
     * @param end    结果柱子
     */
    public static void hanoi(int n, int start, int middle, int end) {
        if (n <= 1) {
            System.out.println(start + "----->" + end);
        } else {
            hanoi(n - 1, start, end, middle);
            System.out.println(start + "----->" + end);
            hanoi(n - 1, middle, start, end);
        }
    }
}
