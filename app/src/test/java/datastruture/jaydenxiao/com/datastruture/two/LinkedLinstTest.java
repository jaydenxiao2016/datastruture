package datastruture.jaydenxiao.com.datastruture.two;

import org.junit.Test;

/**
 * 类名：LinkedLinstTest.java
 * 描述：
 * 公司：北京海鑫科鑫高科技股份有限公司
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class LinkedLinstTest {
    @Test
    public void addition_isCorrect() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 4);
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(0,8);
//        linkedList.remove(4);
        for(int i = 0; i < linkedList.size; i++) {
            System.out.print( i + ":" + linkedList.get(i) + "  ");
        }
    }
}
