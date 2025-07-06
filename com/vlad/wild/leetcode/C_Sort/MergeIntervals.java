package vlad.wild.leetcode.C_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Дан массив интервалов, где intervals[i] = [starti, endi],
 * объединить все перекрывающиеся интервалы и вернуть массив неперекрывающихся интервалов,
 * которые покрывают все интервалы во входных данных.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] merge = merge2(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge2(int[][] intervals) {
        List<int[]> ints = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                //пересекается и идем к следующему и меняем текущий
                current = new int[]{current[0], Math.max(current[1], next[1])}; //ВОТ ЭТОТ ВАЖНЫЙ МОМЕНТ - тут напоролся!!!! - надо взять максимальный правый между текущим и следующим
            } else {
                //не пересекается -
                ints.add(current);
                current = next;
            }
        }

        ints.add(current);

        return ints
                .stream()
                .toArray(int[][]::new);
    }

    public static int[][] merge(int[][] intervals) {
        boolean[] merged = new boolean[intervals.length];

        List<int[]> mergeIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (!merged[i]) {
                int[] leftInterval = intervals[i];
                int leftLast = leftInterval[1];
                merged[i] = true;

                int j = 1;

                while (true) {
                    if (i + j >= intervals.length) {
                        mergeIntervals.add(leftInterval);
                        break;
                    }
                    int[] interval = intervals[i + j];
                    int left = interval[0];
                    int right = interval[1];

                    if (leftLast > right && leftLast > left) {
                        merged[i + j] = true;
                        ++j;
                        continue;
                    } else if (leftLast < left) {
                        mergeIntervals.add(leftInterval);
                        ++j;
                        break;
                    } else if (leftLast >= left && leftLast < right) {
                        mergeIntervals.add(new int[]{intervals[i][0], interval[1]});
                        merged[i + j] = true;
                        ++j;
                        break;
                    }
                }
            }
        }

        return mergeIntervals.stream().toArray(int[][]::new);
    }
}
