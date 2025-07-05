package vlad.wild.leetcode.I_Dfs;

/**
 * Если дана двоичная сетка m x n 2D, которая представляет собой карту '1' (суша) и '0 (вода), возвращает количество островов.
 *
 * Остров окружен водой и образуется путем соединения смежных земель по горизонтали или вертикали.
 * Вы можете предположить, что все четыре края сетки окружены водой.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1},
        };

        int i = numIslands(grid);
        System.out.println(i);
    }

    public static int numIslands(int[][] grid) {
        boolean[][] visible = new boolean[grid.length][grid[0].length];

        int countIslands = 0;

        for (int i = 0; i < grid.length; i++) {           // i - строка
            for (int j = 0; j < grid[0].length; j++) {    // j - столбец
                if (visible[i][j] == false) {
                    IsIsland isIsland = new IsIsland();
                    deepClub(i, j, grid, visible, isIsland);
                    if (isIsland.isIsland) {
                        ++countIslands;
                    }
                }
            }
        }

        return countIslands;
    }

    private static void deepClub(int i, int j, int[][] grid, boolean[][] visible, IsIsland isIsland) {
        if (grid[i][j] == 1) {
            visible[i][j] = true;
            isIsland.islandSetTrue();

            int nextRight = j + 1;

            if (nextRight < grid[0].length && visible[i][nextRight] != true) { //на право идем
                deepClub(i, nextRight, grid, visible, isIsland);
            }

            int nextLeft = j - 1;

            if (nextLeft > 0 && visible[i][nextLeft] != true) { //на лево идем
                deepClub(i, nextLeft, grid, visible, isIsland);
            }

            int nextDown = i + 1;

            if (nextDown < grid.length && visible[nextDown][j] != true) {
                deepClub(nextDown, j, grid, visible, isIsland);
            }

            int nextUp = i - 1;

            if (nextUp > 0 && visible[nextUp][j] != true) {
                deepClub(nextUp, j, grid, visible, isIsland);
            }

        } else { //grid[i][j] == 0
            visible[i][j] = true;
        }
    }

    public static class IsIsland {
        boolean isIsland;

        public IsIsland() {
            isIsland = false;
        }

        public void islandSetTrue() {
            isIsland = true;
        }
    }
}
