package exercises.Week9.Baitap;

public class Bai4 {
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

    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        return root;
    }
}