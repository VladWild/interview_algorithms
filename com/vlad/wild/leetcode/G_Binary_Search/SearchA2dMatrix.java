package vlad.wild.leetcode.G_Binary_Search;

/**
 * Вам дается матрица m x n целочисленных матриц со следующими двумя свойствами:
 *
 * Каждая строка сортируется в порядке, не убывающем.
 * Первое целое число каждой строки больше последнего целого числа предыдущей строки.
 * Если задана целочисленная цель, возвращаем true, если цель находится в матрице, или false в противном случае.
 *
 * Решение необходимо написать в временной сложности O(log(m * n)) времени.
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 12;

        boolean result = searchMatrix(arr, target);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return searchArray(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            }
        }

        return false;
    }

    public static boolean searchArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }
}
