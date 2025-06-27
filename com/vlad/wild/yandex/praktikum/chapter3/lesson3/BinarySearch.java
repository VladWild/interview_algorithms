package vlad.wild.yandex.praktikum.chapter3.lesson3;

/**
 * Бинарный поиск в отсортированном массиве
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-2, -1, 0, 3, 7, 9};
        int key = -1;

        boolean b = binarySearch(arr, key);
        System.out.println("result: " + b);
    }

    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            System.out.println("middle: " + middle);

            if (key < array[middle]) {
                right = middle - 1;
            } else if (key > array[middle]) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
