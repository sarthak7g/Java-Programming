package graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1">Detect cycle in a directed graph</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use DFS</li>
 *          <li>While traversing, also maintain path, if you have seen the current element in the path, then it is cycle, else continue</li>
 *          <li>Time complexity: O(V+E)</li>
 *          <li>Space complexity: O(E)</li>
 *      </ul>
 */

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        System.out.println(isCyclic(4, asList(
                Collections.singletonList(1), asList(2, 3),
                Collections.singletonList(3), Collections.singletonList(3)
        )));
        System.out.println(isCyclic(4, asList(
                Collections.singletonList(1), asList(2, 3),
                Collections.singletonList(3), Collections.emptyList()
        )));
        System.out.println(isCyclic(4, asList(
                Collections.singletonList(1), asList(2, 3),
                Collections.singletonList(3), Collections.singletonList(1)
        )));
    }
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        for(int i=0; i<V; i++) {
            if(!visited.contains(i)) {
                path.clear();
                if(checkCycleDFS(adj, i, visited, path)) return true;
            }

        }
        return false;
    }

    static  boolean checkCycleDFS(List<List<Integer>> adj, int source, Set<Integer> visited, Set<Integer> path) {
        visited.add(source);
        path.add(source);
        for(int el : adj.get(source)) {
            if(path.contains(el)) return true;

            if(visited.contains(el)) continue;

            if(checkCycleDFS(adj, el, visited, path)) return true;
            path.remove(el);
        }
        return false;
    }
}
