package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1">Detect cycle in an undirected graph</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use DFS, while maintaining path and the last element in the path</li>
 *          <li>We know how to find cycle in directed graph, refer {@link graph.DetectCycleInDirectedGraph}</li>
 *          <li>Now, just we just have to check the case where child's next node is not its immediate parent</li>
 *          <li>Time complexity: O(V+E)</li>
 *          <li>Space complexity: O(E)</li>
 *      </ul>
 */

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        System.out.println(isCycle(4, Arrays.asList(
                Collections.singletonList(1), Arrays.asList(0, 2),
                Arrays.asList(1, 3), Arrays.asList(2, 3)
        )));
    }
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for(int i=0; i<V; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                path.add(i);
                if(checkCycleDFS(adj, i, visited, path, -1)) return true;
                path.clear();
            }

        }
        return false;
    }

    static boolean checkCycleDFS(List<List<Integer>> adj, int source, Set<Integer> visited, Set<Integer> path, int last) {
        for(int el : adj.get(source)) {
            // check when child's next node is not its parent
            if(el == last) continue;

            if(path.contains(el)) return true;

            if(visited.contains(el)) continue;

            visited.add(el);
            path.add(el);

            if(checkCycleDFS(adj, el, visited, path, source)) return true;
            path.remove(el);
        }
        return false;
    }
}
