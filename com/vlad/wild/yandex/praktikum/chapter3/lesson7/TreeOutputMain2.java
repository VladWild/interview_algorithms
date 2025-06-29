package vlad.wild.yandex.praktikum.chapter3.lesson7;

import java.util.ArrayList;
import java.util.List;

// Дано бинарное дерево, нужно вывести список списков значений вершин «по слоям».
// В каждом слое значения должны идти слева направо. Для дерева:
//       1
//      / \
//     2   3
//    /   / \
//   4   5   6
public class TreeOutputMain2 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = function(root);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("Level " + i + ": " + result.get(i));
        }
    }

    public static List<List<Integer>> function(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        func2(root, 0, result);
        return result;
    }

    private static void func2(TreeNode node, int deep, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (deep >= result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(deep).add(node.val);

        func2(node.left, deep + 1, result);
        func2(node.right, deep + 1, result);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
