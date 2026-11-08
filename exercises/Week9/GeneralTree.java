package exercises.Week9;
public class GeneralTree {
    static class Node {
        String info;
        int firstChild;
        int nextSibling;

        public Node(String info) {
            this.info = info;
            this.firstChild = -1;
            this.nextSibling = -1;
        }
    }

    private Node[] tree;
    private int root;
    private int size;

    public GeneralTree(int capacity) {
        tree = new Node[capacity];
        root = -1;
        size = 0;
    }

    public int addRoot(String info) {
        if (root != -1) return -1;
        tree[size] = new Node(info);
        root = size;
        return size++;
    }

    public int addChild(int parentIndex, String info) {
        if (parentIndex < 0 || parentIndex >= size || size >= tree.length) {
            return -1;
        }

        int newIndex = size++;
        tree[newIndex] = new Node(info);

        if (tree[parentIndex].firstChild == -1) {
            tree[parentIndex].firstChild = newIndex;
        } else {
            int cur = tree[parentIndex].firstChild;
            while (tree[cur].nextSibling != -1) {
                cur = tree[cur].nextSibling;
            }
            tree[cur].nextSibling = newIndex;
        }
        return newIndex;
    }

    public int findParent(int childIndex) {
        if (childIndex == root || childIndex < 0 || childIndex >= size) {
            return -1;
        }

        for (int i = 0; i < size; i++) {
            int child = tree[i].firstChild;
            while (child != -1) {
                if (child == childIndex) {
                    return i;
                }
                child = tree[child].nextSibling;
            }
        }
        return -1;
    }

    public String findParentInfo(String childInfo) {
        int childIndex = -1;
        for (int i = 0; i < size; i++) {
            if (tree[i] != null && tree[i].info.equals(childInfo)) {
                childIndex = i;
                break;
            }
        }
        int parentIdx = findParent(childIndex);
        return (parentIdx != -1) ? tree[parentIdx].info : null;
    }

    public void preOrder(int u) {
        if (u == -1) return;
        System.out.print(tree[u].info + " ");
        preOrder(tree[u].firstChild);
        preOrder(tree[u].nextSibling);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }
}