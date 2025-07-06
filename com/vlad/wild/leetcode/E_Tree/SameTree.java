package vlad.wild.leetcode.E_Tree;

/**
 * Имея корни двух бинарных деревьев p и q, напишите функцию для проверки их идентичности.
 * Два бинарных дерева считаются одинаковыми, если они структурно идентичны, а узлы имеют одинаковое значение.
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

        boolean isSame = function(treeNode1, treeNode2);
        System.out.println(isSame);
    }

    /**
     * Тут проще надо думать, изначально прям закопался в условиях
     */
    public static boolean function(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || q.val != p.val) {
            return false;
        }

        return function(p.left, q.left) && function(p.right, q.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
