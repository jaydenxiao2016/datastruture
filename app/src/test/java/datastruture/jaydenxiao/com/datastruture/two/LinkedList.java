package datastruture.jaydenxiao.com.datastruture.two;

/**
 * 类名：LinkedList.java
 * 描述：链表
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class LinkedList<E> {
    /**
     * 节点
     *
     * @param <E>
     */
    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> pre;

        public Node(Node<E> pre, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }

    }

    /**
     * 头结点
     */
    Node<E> first;
    /**
     * 尾节点
     */
    Node<E> last;
    /**
     * 链表大小
     */
    int size;

    public LinkedList() {
    }

    /**
     * 添加
     *
     * @param e
     */
    public void add(E e) {
        linkLast(e);
    }

    /**
     * 最后添加
     *
     * @param e
     */
    private void linkLast(E e) {
        Node<E> newNode = new Node<E>(last, e, null);
        Node<E> l = last;
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * 获取
     *
     * @param index
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return node(index).item;
    }

    /**
     * 获取第index位置上的节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        //index在前半部份
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else { //index在后半部份
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }

    /**
     * 在index的位置上添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            linkLast(e);
        } else {
            Node<E> target = node(index);
            Node<E> pre = target.pre;
            Node<E> newNode = new Node<>(pre, e, target);
            //要考虑index=0时的情况
            if (pre == null) {
                first = newNode;
            } else {
                pre.next = newNode;
            }
            target.pre = newNode;
            size++;
        }

    }

    /**
     * 添加所有
     *
     * @param all
     */
    public void addAll(LinkedList all) {
        for (int i = 0; i < all.size; i++) {
            add((E) all.get(i));
        }
    }

    /**
     * 替换
     *
     * @param index
     * @param e
     */
    public void replace(int index, E e) {
        if (size < 0) {
            return;
        }
        if (size > index) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        Node<E> node = node(index);
        node.item = e;
    }

    /**
     * 替换
     *
     * @param e1
     * @param e2
     */
    public void replace(E e1, E e2) {
        if (size < 0) {
            return;
        }
        Node<E> node = first;
        if (node == null) {
            return;
        }
        if (node.item == e1) {
            node.item = e2;
        } else {
            for (int i = 0; i < size; i++) {
                node = node.next;
                if (node.item == e1) {
                    node.item = e2;
                    break;
                }
            }
        }
    }

    /**
     * 移除
     */
    public E remove() {
        Node<E> node = node(size - 1);
        unlinkNode(node);
        if (node != null) {
            return node.item;
        } else {
            return null;
        }
    }

    /**
     * 移除
     *
     * @param index
     */
    public void remove(int index) {
        Node<E> node = node(index);
        unlinkNode(node);
    }

    /**
     * 移除node
     *
     * @param p
     */
    private void unlinkNode(Node<E> p) {
        Node<E> pre = p.pre;
        Node<E> next = p.next;

        if (pre == null) {
            first = p.next;//删除头节点
        } else {
            pre.next = p.next;
        }

        if (next == null) {
            last = p.pre;//删除尾结节
        } else {
            next.pre = p.pre;
        }
        size--;
    }

    public int size() {
        return size;
    }

}
