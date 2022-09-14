package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1">Detect cycle in a directed graph</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use DFS</li>
 *          <li>Time complexity: O(N+E)</li>
 *      </ul>
 */

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        System.out.println(isCyclic(4, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(1, 3), Arrays.asList(2, 3)
        )));
        System.out.println(isCyclic(4, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(2, 3), Arrays.asList(3, 3)
        )));
        System.out.println(isCyclic(5, Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2),
                Arrays.asList(1, 3), Arrays.asList(2, 3),
                Arrays.asList(3, 1)
        )));
    }
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<V; i++) {
            if(!visited.contains(i))
                if(checkCycleBFS(adj, i, visited)) return true;
        }
        return false;
    }

    static boolean checkCycleBFS(List<List<Integer>> adj, int source, Set<Integer> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited.add(source);
        while(!q.isEmpty()) {
            int el = q.poll();
            for(int child : adj.get(el)) {
                if(!visited.contains(child)) {
                    q.add(child);
                    visited.add(child);
                }else return true;
            }
        }
        return false;
    }
}
