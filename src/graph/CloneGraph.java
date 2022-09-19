package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use DFS, and maintain visited hashmap</li>
 *          <li>It's kind of DP, where problem can be divided into smaller sub-problems</li>
 *          <li>Time complexity: O(V)</li>
 *          <li>Space complexity: O(V)</li>
 *      </ul>
 */

public class CloneGraph {
    static Map<Integer, Node> visited = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        Node curr = new Node(node.val);
        visited.put(curr.val, curr);

        for(Node child: node.neighbors) {

            if(visited.containsKey(child.val)) {
                curr.neighbors.add(visited.get(child.val));
            }else {
                curr.neighbors.add(cloneGraph(child));
            }
        }
        return curr;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
