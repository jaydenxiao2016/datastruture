package datastruture.jaydenxiao.com.datastruture.lsn_8;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 类名：HuffmanTreeTest.java
 * 描述：哈夫曼树
 * 作者：xsf
 * 创建时间：2018/12/19
 * 最后修改时间：2018/12/19
 */
public class HuffmanTreeTest {
    TreeNode root;

    public TreeNode createHuffManTree(ArrayList<TreeNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            TreeNode left = list.get(list.size() - 1);
            TreeNode right = list.get(list.size() - 2);
            TreeNode parent = new TreeNode("p", left.weight + right.weight);
            parent.leftChild = left;
            left.parent = parent;
            parent.rightChild = right;
            right.parent = parent;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        root = list.get(0);
        return list.get(0);
    }

    public void showHuffman(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);//入队
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            System.out.println(node.data);
            if (node.leftChild != null) {
                list.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                list.offer(node.rightChild);
            }
        }
    }

    @Test
    public void test() {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode<String> node = new TreeNode("good", 50);
        list.add(node);
        list.add(new TreeNode("morning", 10));
        TreeNode<String> node2 =new TreeNode("afternoon", 20);
        list.add(node2);
        list.add(new TreeNode("hell", 110));
        list.add(new TreeNode("hi", 200));
        HuffmanTreeTest tree = new HuffmanTreeTest();
        tree.createHuffManTree(list);
        tree.showHuffman(tree.root);
        getCode(node2);
    }

    /**
     * 编码
     */
    public void getCode(TreeNode node) {
        TreeNode tNode = node;
        Stack<String> stack = new Stack<>();
        while (tNode != null && tNode.parent != null) {
            //left 0  right 1
            if (tNode.parent.leftChild == tNode) {
                stack.push("0");
            } else if (tNode.parent.rightChild == tNode) {
                stack.push("1");
            }
            tNode = tNode.parent;
        }
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    /**
     * 结点
     *
     * @param <T>
     */
    public static class TreeNode<T> implements Comparable<TreeNode<T>> {
        T data;
        int weight;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(T data, int weight) {
            this.data = data;
            this.weight = weight;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        /**
         * 默认升序
         * < return -1
         = return 0
         > return 1
         * @param o
         * @return
         */
        @Override
        public int compareTo(@NonNull TreeNode<T> o) {
            //降序
            if (this.weight > o.weight) {
                return -1;
            } else if (this.weight < o.weight) {
                return 1;
            }
            return 0;
        }
    }
}