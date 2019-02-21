package wangyu.tree;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * 作者：王宇
 * 创建时间：2019/2/18 0018 20:13
 * 描述：二叉搜索树的递归实现
 */
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;//根节点
    private int count;//树的节点数目

    public BST() {
        root = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    private Node insert(Node root, Key key, Value value) {

        if (root == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(root.key) == 0) {
            root.value = value;
        } else if (key.compareTo(root.key) < 0)
            root.left = insert(root.left, key, value);
        else
            root.right = insert(root.right, key, value);


        return root;

    }

    public boolean contains(Key key) {
        return contains(root, key);
    }

    private boolean contains(Node node, Key key) {

        if (node == null)//递归到底的情况
            return false;
        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) < 0)
            return contains(node.left, key);
        else
            return contains(node.right, key);
    }


    public Value search(Key key) {
        return search(root, key);
    }

    private Value search(Node node, Key key) {
        if (node == null)
            return null;
        if (node.key.compareTo(key) == 0)
            return node.value;
        else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else
            return search(node.right, key);
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
//        if (node == null)
//            return;
        if (node != null) {
            System.out.print(node.key);//为什么打印key呢？
            preOrder(node.left);
            preOrder(node.right);
        }


    }

    public void cenOrder() {
        cenOrder(root);
    }

    private void cenOrder(Node node) {
//        if (node == null)
//            return;
        if (node != null) {
            preOrder(node.left);
            System.out.print(node.key);//为什么打印key呢？
            preOrder(node.right);
        }
    }

    //寻找最小值
    public Key min() {
        return min(root);
    }

    private Key min(Node root) {
        if (root.left == null)
            return root.key;
        if (root != null)
            return min(root.left);

        return null;
    }


    public Key max() {
        return max(root);
    }

    private Key max(Node root) {
        if (root.right == null)
            return root.key;
        if (root != null)
            return max(root.right);

        return null;
    }

    public Key removeMin() {
        if (root != null) {
            Key key = removeMin(root);
            return key;
        }
        return null;
    }

    private Key removeMin(Node node) {
        if (node.left != null) {
            node.left.key = removeMin(node.left);
        } else {//node的左边为空了，说明node为最小值
            Node right = node.right;//看右节点是否存在
            if (right == null)
                return node.key;
            else
                //todo
                return node.key;
        }
        return null;
    }


    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        bst.insert(1, 10);
        bst.insert(2, 12);
        bst.insert(3, 8);
        bst.insert(10, 20);
        bst.insert(4, 5);
        bst.insert(5, 11);
        bst.insert(6, 15);

        bst.preOrder();
        System.out.println();
        bst.cenOrder();
        System.out.println(bst.contains(2));
        System.out.println();

        System.out.println(bst.max());
        System.out.println(bst.min());

        System.out.println(bst.removeMin());
    }
}
