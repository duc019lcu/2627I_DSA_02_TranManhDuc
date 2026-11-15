package exercises.Week10.BaiTap;

public class Bai5 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isBST(Node root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean check(Node root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return check(root.left, min, root.data) && check(root.right, root.data, max);
    }
}