package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/">Number of steps to make network connected</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use DFS, and maintain visited array</li>
 *          <li>Whenever an element is visited more than one times and it's also not in the path increment extra edges count/li>
 *          <li>Whenever an element is not visited once, we found a broken link, then increment count_disc/li>
 *          <li>Time complexity: O(N+E)</li>
 *          <li>Space complexity: O(N+E)</li>
 *      </ul>
 */

public class ConnectedNetwork {
    public static void main(String[] args) {
        int [][] edges = {{17,51},{33,83},{53,62},{25,34},{35,90},{29,41},{14,53},{40,84},{41,64},{13,68},{44,85},{57,58},{50,74},{20,69},{15,62},{25,88},{4,56},{37,39},{30,62},{69,79},{33,85},{24,83},{35,77},{2,73},{6,28},{46,98},{11,82},{29,72},{67,71},{12,49},{42,56},{56,65},{40,70},{24,64},{29,51},{20,27},{45,88},{58,92},{60,99},{33,46},{19,69},{33,89},{54,82},{16,50},{35,73},{19,45},{19,72},{1,79},{27,80},{22,41},{52,61},{50,85},{27,45},{4,84},{11,96},{0,99},{29,94},{9,19},{66,99},{20,39},{16,85},{12,27},{16,67},{61,80},{67,83},{16,17},{24,27},{16,25},{41,79},{51,95},{46,47},{27,51},{31,44},{0,69},{61,63},{33,95},{17,88},{70,87},{40,42},{21,42},{67,77},{33,65},{3,25},{39,83},{34,40},{15,79},{30,90},{58,95},{45,56},{37,48},{24,91},{31,93},{83,90},{17,86},{61,65},{15,48},{34,56},{12,26},{39,98},{1,48},{21,76},{72,96},{30,69},{46,80},{6,29},{29,81},{22,77},{85,90},{79,83},{6,26},{33,57},{3,65},{63,84},{77,94},{26,90},{64,77},{0,3},{27,97},{66,89},{18,77},{27,43}};
        System.out.println(makeConnected(100, edges));
        int[][] edges2 = {{0,1},{0,2},{0,3},{1,2},{1,3}, {4,5}};
        System.out.println(makeConnected(6, edges2));
    }

    public static int makeConnected(int n, int[][] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] ints : arr) {
            List<Integer> al1 = map.getOrDefault(ints[0], new ArrayList<>());
            al1.add(ints[1]);
            map.put(ints[0], al1);

            List<Integer> al2 = map.getOrDefault(ints[1], new ArrayList<>());
            al2.add(ints[0]);
            map.put(ints[1], al2);
        }

        int[] visited = new int[n];
        int count=0, count_disc=0;

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                count += bfs(map, i, visited);
                if(i>0) count_disc ++;
            }
        }

        count /= 2;

        return count>=count_disc ? count_disc : -1;

    }

    static int bfs(Map<Integer, List<Integer>> map, int source, int[] visited) {
        int count = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(source, -1));
        visited[source] = 1;

        while(!q.isEmpty()) {
            List<Integer> al = q.poll();
            for(int child : map.getOrDefault(al.get(0), Collections.emptyList())) {
                if(child ==  al.get(1)) continue;
                if(visited[child] == 1) count++;
                else{
                    q.add(Arrays.asList(child, al.get(0)));
                    visited[child] = 1;
                }
            }
        }
        return count;
    }
}
