package vlad.wild.yandex.praktikum.chapter3.lesson7;

/**
 * Бинарное Дерево
 */
public class TreeNodeMain {

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
