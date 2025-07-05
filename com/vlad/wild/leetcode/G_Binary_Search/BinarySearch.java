package vlad.wild.leetcode.G_Binary_Search;

/**
 * Имея массив целых чисел nums, который отсортирован в порядке возрастания, и целочисленную цель, описать функцию для поиска цели в nums.
 * Если цель существует, то возвращаем ее индекс. В противном случае возвращаем -1.
 * Необходимо написать алгоритм с O(log n) сложностью времени выполнения.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] sortArray = {-1,0,3,5,9,12};
        int target = 9;

        int search = search(sortArray, target);
        System.out.println(search);
    }

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; //убираем правую сторону, так как элемент слева
            } else {
                right = mid - 1; //убираем левую сторону, так как элемент справа
            }
        }

        return -1;
    }
}
