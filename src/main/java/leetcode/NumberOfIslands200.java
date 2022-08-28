package main.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfIslands200 {
    public static void main(String[] args) {
        char[][] in = new char[4][5];
        in[0][0] = '1'; in[0][1] = '1'; in[0][2] = '1';in[0][3] = '1'; in[0][4] = '0';
        in[1][0] = '1'; in[1][1] = '1'; in[1][2] = '0'; in[1][3] = '1'; in[1][4] = '0';
        in[2][0] = '1'; in[2][1] = '1'; in[2][2] = '0'; in[2][3] = '0'; in[2][4] = '0';
        in[3][0] = '0'; in[3][1] = '0'; in[3][2] = '0'; in[3][3] = '0'; in[3][4] = '0';

        char[][] debug = new char[4][5];
        debug[0][0] = '1'; debug[0][1] = '1'; debug[0][2] = '0'; debug[0][3] = '0'; debug[0][4] = '0';
        debug[1][0] = '1'; debug[1][1] = '1'; debug[1][2] = '0'; debug[1][3] = '0'; debug[1][4] = '0';
        debug[2][0] = '0'; debug[2][1] = '0'; debug[2][2] = '1'; debug[2][3] = '0'; debug[2][4] = '0';
        debug[3][0] = '0'; debug[3][1] = '0'; debug[3][2] = '0'; debug[3][3] = '1'; debug[3][4] = '1';

        char[][] debug1 = new char[2][1];
        debug1[0][0] = '1';
        debug1[1][0] = '1';

        var solution = new NumberOfIslands200();
        solution.numIslands(debug1);
    }

    public int numIslands(char[][] grid) {
        Map<Integer, List<List<Integer>>> roots = new HashMap<>();

        int rootNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    roots.put(rootNum, new ArrayList<>());
                    dfs(grid, i, j, roots, rootNum);
                    rootNum++;
                }
            }
        }
        int i = (int) roots.values().stream().filter(a -> !a.isEmpty()).count();
        return i;
    }

    private void dfs(char[][] grid, Integer i, Integer j, Map<Integer, List<List<Integer>>> roots, int rootNum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        List<Integer> vertice = Arrays.asList(i, j);
        if (!roots.get(rootNum).contains(vertice)) {
            roots.put(rootNum, Arrays.asList(vertice));
        } else {
            roots.get(rootNum).add(vertice);
        }
        dfs(grid, i + 1, j, roots, rootNum);
        dfs(grid, i - 1, j, roots, rootNum);
        dfs(grid, i, j + 1, roots, rootNum);
        dfs(grid, i, j - 1, roots, rootNum);
    }
}
