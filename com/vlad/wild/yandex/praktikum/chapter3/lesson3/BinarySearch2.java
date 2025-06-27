package vlad.wild.yandex.praktikum.chapter3.lesson3;

/**
 * Дана бинарная строка длины N, состоящая только из нулей и единиц.
 * Гарантируется, что самый левый её элемент 0, а самый правый — 1.
 * Найдите любое вхождение подстроки “01”.
 */
public class BinarySearch2 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 1, 1, 1};

        boolean b = binarySearch(arr);
        System.out.println("result: " + b);
    }

    private static boolean binarySearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
