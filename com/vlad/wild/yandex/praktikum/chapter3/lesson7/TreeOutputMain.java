package vlad.wild.yandex.praktikum.chapter3.lesson7;

import java.util.ArrayList;
import java.util.List;

// Дано бинарное дерево, нужно вывести список списков значений вершин «по слоям».
// В каждом слое значения должны идти слева направо. Для дерева:
//       5
//     /   \
//    3     1
//     \   /
//      4 2

public class TreeOutputMain {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);

        List<List<Integer>> layers = getLayeredRepresentation(root);

        for (int i = 0; i < layers.size(); i++) {
            System.out.println("Level " + i + ": " + layers.get(i));
        }
    }

    public static List<List<Integer>> getLayeredRepresentation(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) return;

        if (depth >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(node.value);

        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
