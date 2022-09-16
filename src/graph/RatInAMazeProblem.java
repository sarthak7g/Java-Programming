package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1">Rat in a Maze Problem - I</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Divide problems into sub-problem</li>
 *          <li>Visit every cell other than the one already in path</li>
 *          <li>Time complexity: O(3^(n^2)). As there are N^2 cells from each cell there are 3 unvisited neighboring cells. So the time complexity O(3^(N^2).</li>
 *          <li>Auxiliary Space: O(3^(n^2)). As there can be at most 3^(n^2) cells in the answer so the space complexity is O(3^(n^2)).</li>
 *      </ul>
 */

public class RatInAMazeProblem {

    public static void main(String[] args) {
        System.out.println(findPath(new int[][]{{1}}));
        System.out.println(findPath(new int[][]{{0}}));
        System.out.println(findPath(new int[][]{{1, 0}, {1, 1}}));
        System.out.println(findPath(new int[][]{{1, 1, 0}, {1, 1, 0}, {1, 1, 1}}));
    }

    public static ArrayList<String> findPath(int[][] arr) {
        Set<ArrayList<Integer>> path = new HashSet<>();
        return find(arr, arr.length, 0, 0, path);
    }

    static ArrayList<String> find(int[][] arr, int n, int i, int j, Set<ArrayList<Integer>> path) {

        if(i>=n || j>=n || i<0 || j<0) return new ArrayList<>();

        ArrayList<Integer> indexList = new ArrayList<>();
        indexList.add(i);
        indexList.add(j);


        if(path.contains(indexList)) return new ArrayList<>();



        ArrayList<String> ans = new ArrayList<>();

        if(i==n-1 && j==n-1 && arr[i][j]==1){
            ans.add("");
            return ans;
        }

        path.add(indexList);
        if(arr[i][j] == 1) {
            ArrayList<String> leftList = find(arr, n, i, j-1, path);
            for(String str : leftList) {
                ans.add("L"+str);
            }

            ArrayList<String> upList = find(arr, n, i-1, j, path);
            for(String str : upList) {
                ans.add("U"+str);
            }

            ArrayList<String> downList = find(arr, n, i+1, j, path);
            for(String str : downList) {
                ans.add("D"+str);
            }

            ArrayList<String> rightList = find(arr, n, i, j+1, path);
            for(String str : rightList) {
                ans.add("R"+str);
            }
        }
        path.remove(indexList);
        return ans;

    }

}
