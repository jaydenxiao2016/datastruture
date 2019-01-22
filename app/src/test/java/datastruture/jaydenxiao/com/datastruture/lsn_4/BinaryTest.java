package datastruture.jaydenxiao.com.datastruture.lsn_4;

import org.junit.Test;

/**
 * 类名：BinaryTest.java
 * 描述：二叉树测试
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class BinaryTest {
    @Test
    public void addition_isCorrect() throws Exception {
        BinaryTree binaryTree =new BinaryTree("A");
        binaryTree.createTree();
        binaryTree.midOrderTraverse(binaryTree.root);
        binaryTree.preOrderTraverse(binaryTree.root);
        binaryTree.postOrderTraverse(binaryTree.root);
    }
}