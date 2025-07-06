package vlad.wild.leetcode.K_Sliding_Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Медиана — это среднее значение в упорядоченном целочисленном списке. Если размер списка четный, то среднее значение отсутствует.
 * Таким образом, медиана — это среднее значение двух средних значений.
 *
 * Например, если arr = [2,3,4], медиана равна 3.
 * Например, если arr = [1,2,3,4], медиана равна (2 + 3) / 2 = 2,5.
 * Вам дан целочисленный массив nums и целое число k.
 * Есть скользящее окно размера k, которое перемещается из самой левой части массива в самую правую.
 * В окне можно увидеть только k номеров.
 * Каждый раз скользящее окно перемещается вправо на одну позицию.
 *
 * Возвращает медианный массив для каждого окна в исходном массиве. Будут приниматься ответы в пределах 10-5 от фактической стоимости.
 */
public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        double[] doubles = medianSlidingWindow2(arr, k);
        System.out.println(Arrays.toString(doubles));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        boolean chenoe = k % 2 == 0; //четное число

        List<Double> medians = new ArrayList<>();

        int[] intsCopy = null;

        for (int i = 0; i <= nums.length - k; i++) {
            int left = i;
            int right = i + (k - 1);

            intsCopy = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(intsCopy);

            if (chenoe) {
                int indexLeft = intsCopy.length / 2;
                int indexRight = indexLeft + 1;
                double num = ((double) (intsCopy[indexLeft] + intsCopy[indexRight])) / 2.0d;
                medians.add(num);
            } else {
                intsCopy = Arrays.copyOfRange(nums, left, right + 1);
                Arrays.sort(intsCopy);
                int index = intsCopy.length / 2;
                double num = intsCopy[index];
                medians.add(num);
            }
        }

        return medians.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    public static double[] medianSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // левая половина
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // правая половина
        Map<Integer, Integer> delayed = new HashMap<>(); // отложенные к удалению
        double[] result = new double[nums.length - k + 1];
        int left = 0, right = 0;

        while (right < nums.length) {
            // 1. Добавляем элемент
            if (maxHeap.isEmpty() || nums[right] <= maxHeap.peek()) {
                maxHeap.offer(nums[right]);
            } else {
                minHeap.offer(nums[right]);
            }

            // 2. Балансируем кучи
            balanceHeaps(maxHeap, minHeap);

            // 3. Окно размером k
            if (right - left + 1 == k) {
                // 4. Вычисляем медиану
                if (k % 2 == 0) {
                    result[left] = ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
                } else {
                    result[left] = maxHeap.peek();
                }

                // 5. Удаляем left элемент
                int toRemove = nums[left];
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove);
                } else {
                    minHeap.remove(toRemove);
                }
                balanceHeaps(maxHeap, minHeap);
                left++;
            }

            right++;
        }

        return result;
    }

    private static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
