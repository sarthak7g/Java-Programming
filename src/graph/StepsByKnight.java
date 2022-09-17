package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1">Steps By Knight</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>To find the shortest path we need to use BFS. At each position there are 8 position to choose from.</li>
 *          <li>We'll maintain visited array and also the count array for steps at each position</li>
 *          <li>Time complexity: O(n^2)</li>
 *          <li>Auxiliary Space: O(n^2)</li>
 *      </ul>
 */

public class StepsByKnight {
    public static void main(String[] args) {
        System.out.println(minStepToReachTarget(new int[]{4, 5}, new int[]{1, 2}, 6));
        System.out.println(minStepToReachTarget(new int[]{2, 5}, new int[]{6, 8}, 8));
    }

    public static int minStepToReachTarget(int[] knight, int[] target, int N) {
        knight[0]--;
        knight[1]--;
        target[0]--;
        target[1]--;

        int[][] visited = new int[N][N];
        int[][] count = new int[N][N];
        Queue<List<Integer>> q = new LinkedList<>();

        List<Integer> arr = new ArrayList<>();
        arr.add(knight[0]);
        arr.add(knight[1]);

        q.add(arr);
        visited[knight[0]][knight[1]] = 1;
        count[knight[0]][knight[1]] = 0;

        int i, j;
        while (!q.isEmpty()) {
            List<Integer> pos = q.poll();
            if (target[0] == pos.get(0) && target[1] == pos.get(1))
                return count[pos.get(0)][pos.get(1)];

            i = pos.get(0) - 1;
            j = pos.get(1) - 2;
            if (i >= 0 && j >= 0 && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) - 1;
            j = pos.get(1) + 2;
            if (i >= 0 && j < N && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) + 1;
            j = pos.get(1) - 2;
            if (i < N && j >= 0 && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) + 1;
            j = pos.get(1) + 2;
            if (i < N && j < N && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) - 2;
            j = pos.get(1) - 1;
            if (i >= 0 && j >= 0 && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) - 2;
            j = pos.get(1) + 1;
            if (i >= 0 && j < N && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) + 2;
            j = pos.get(1) - 1;
            if (i < N && j >= 0 && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }
            i = pos.get(0) + 2;
            j = pos.get(1) + 1;
            if (i < N && j < N && visited[i][j] == 0) {
                q.add(Arrays.asList(i, j));
                visited[i][j] = 1;
                count[i][j] = count[pos.get(0)][pos.get(1)] + 1;
            }

        }

        return -1;

    }
}
