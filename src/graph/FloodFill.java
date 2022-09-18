package graph;

import java.util.Arrays;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/flood-fill/">Flood Fill</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>DFS- maintain visited array. At each point there are 4 options, explore.</li>
 *          <li>Time complexity: O(3^(n^2)). As there are N^2 cells from each cell there are 3 unvisited neighboring cells. So the time complexity O(3^(N^2).</li>
 *          <li>Auxiliary Space: O(3^(n^2)). As there can be at most 3^(n^2) cells in the answer so the space complexity is O(3^(n^2)).</li>
 *      </ul>
 */

public class FloodFill {
    public static void main(String[] args) {
        Arrays.stream(floodFill(new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 2, 0, 2))
                .forEach(arr-> System.out.println(Arrays.toString(arr)));
        Arrays.stream(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 2, 0, 2))
                .forEach(arr-> System.out.println(Arrays.toString(arr)));

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            System.arraycopy(image[i], 0, ans[i], 0, image[i].length);
        }
        ans[sr][sc] = color;

        int[][] visited = new int[image.length][image[0].length];
        visited[sr][sc] = 1;
        solve(image, sr, sc, color, ans, visited);
        return ans;
    }
    public static void solve(int[][] image, int sr, int sc, int color, int[][] ans, int[][] visited) {
        if(sr-1>=0 && visited[sr-1][sc]!=1 && image[sr-1][sc] == image[sr][sc]) {
            ans[sr-1][sc] = color;
            visited[sr-1][sc] = 1;
            solve(image, sr-1, sc, color, ans, visited);
        }
        if(sr+1<image.length && visited[sr+1][sc]!=1  && image[sr+1][sc] == image[sr][sc]) {
            ans[sr+1][sc] = color;
            visited[sr+1][sc] = 1;
            solve(image, sr+1, sc, color, ans, visited);
        }
        if(sc-1>=0 && visited[sr][sc-1]!=1 && image[sr][sc-1] == image[sr][sc]) {
            ans[sr][sc-1] = color;
            visited[sr][sc-1] = 1;
            solve(image, sr, sc-1, color, ans, visited);
        }
        if(sc+1<image[0].length && visited[sr][sc+1]!=1 && image[sr][sc+1] == image[sr][sc]) {
            ans[sr][sc+1] = color;
            visited[sr][sc+1] = 1;
            solve(image, sr, sc+1, color, ans, visited);
        }

    }
}
