package datastruture.jaydenxiao.com.datastruture.six;

import org.junit.Test;

/**
 * 类名：SearchBinaryTree.java
 * 描述：二叉树排序
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class SixTest {
    @Test
    public void test() throws Exception {
        SearchBinaryTree tree=new SearchBinaryTree();
        //5  2  7  3  4  1  6
        int[] array=new int[]{5,2,7,3,4,1,6};

        for (int i : array) {
            tree.put(i);
        }
        tree.midOrderTraverse(tree.root);

//        for(int i=0;i<array.length-1;i++){
            SearchBinaryTree.TreeNode node=tree.searchNode(5);
            tree.delNode(node);
//        }

        System.out.println("----");
        tree.midOrderTraverse(tree.root);
//        System.out.println(node.data);

    }
}








