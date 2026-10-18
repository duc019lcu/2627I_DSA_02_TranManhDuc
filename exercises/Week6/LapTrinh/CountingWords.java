package exercises.Week6.LapTrinh;

import java.util.Scanner;

public class CountingWords {

    private static class Node {
        String word;
        int count;
        Node left;
        Node right;

        Node(String word) {
            this.word = word;
            this.count = 1;
        }
    }

    public static class BinarySearchTree {
        private Node root;

        public void put(String word) {
            root = put(root, word);
        }

        private Node put(Node node, String word) {
            if (node == null) {
                return new Node(word);
            }

            int cmp = word.compareTo(node.word);
            if (cmp < 0) {
                node.left = put(node.left, word);
            } else if (cmp > 0) {
                node.right = put(node.right, word);
            } else {
                node.count++; 
            }
            return node;
        }

        public void printInOrder() {
            inOrder(root);
        }

        private void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.println(node.word + ": " + node.count);
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (scanner.hasNext()) {
            String token = scanner.next();

            String cleanWord = token.replaceAll("[^a-zA-Z0-9áàảãạăắằẳẵặâấầẩẫậéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴĐ]", "").toLowerCase();

            if (!cleanWord.isEmpty()) {
                bst.put(cleanWord);
            }
        }

        bst.printInOrder();
        scanner.close();
    }
}
