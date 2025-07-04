package vlad.wild.leetcode.D_Two_Pointers;

/**
 * Вам дан целочисленный массив height длины n.
 * Существует n вертикальных линий, нарисованных таким образом, что две конечные точки i-й линии равны (i, 0) и (i, height[i]).
 *
 * Найдите две линии, которые вместе с осью x образуют контейнер таким образом, чтобы контейнер содержал больше всего воды.
 *
 * Верните максимальное количество воды, которое может вместить контейнер.
 *
 * Обратите внимание, что контейнер нельзя наклонять.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        int result = maxArea2(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int currentAreaHeight = 0;

        for (int i = 0; i < height.length; i++) {
            currentAreaHeight = height[i];

            for (int j = i + 1; j < height.length; j++) {
                int currentAreaInnerHeight = height[j];
                int height1 = Math.min(currentAreaHeight, currentAreaInnerHeight);
                int resultV = height1 * (j - i);
                if (resultV > maxArea) {
                    maxArea = resultV;
                }
            }
        }


        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;

        int currentPointer = 0;
        int innerPointer = height.length - 1;

        while (currentPointer < innerPointer) {
            int heightLeft = height[currentPointer];
            int heightRight = height[innerPointer];

            int minHeight = Math.min(heightLeft, heightRight);
            int width = innerPointer - currentPointer;
            int area = minHeight * width;

            maxArea = Math.max(maxArea, area);

            // Двигаем ту сторону, где меньше высота
            if (heightLeft < heightRight) {
                currentPointer++;
            } else {
                innerPointer--;
            }
        }

        return maxArea;
    }
}
