import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/max-rectangle/1">Max Rectangle in Binary Matrix</a>
 * <br/>
 * Approach :
 *      <ul>
 *          <li>For each row, find the max area in histogram formed</li>
 *          <li>refer to {@link LargestRectangleInHistogram2}</li>
 *          <li>Height of bar in each row will be height of bar in prev row + 1, and 0 when value in curr cell is 0</li>
 *      </ul>
 * Time complexity: O(n^2) <br/>
 * Auxiliary Space: O(n)
 * </body>
 */

public class MaxRectangle {
    public static void main(String[] args) {
//        int matrix[][] = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int[][] matrix = {{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}
        };
        System.out.println(maxArea(matrix, matrix.length, matrix[0].length));
        System.out.println(maxArea2(matrix, matrix.length, matrix[0].length));
    }

    public static int maxArea(int[][] matrix, int n, int m) {
        // Approach 1:
        Map<List<Integer>, Integer> pairToAreaMap = new HashMap<>();
        Map<List<Integer>, Integer> newPairToAreaMap;

        int max=0, start, end, i, j;
        for(int row=0; row<n; row++) {
            i=0;
            newPairToAreaMap = new HashMap<>();
            while(i<m) {
                while(i<m && matrix[row][i]!=1) i++;
                if(i==m) break;
                start=i;
                j=i;
                while(j<m && matrix[row][j]==1) j++;
                end=j-1;

                for(List<Integer> entry : pairToAreaMap.keySet()) {
                    if(start <= entry.get(1) && end >= entry.get(0)) {
                        int mul = pairToAreaMap.get(entry)/(entry.get(1)-entry.get(0)+1);
                        int newStart = Math.max(start, entry.get(0));
                        int newEnd = Math.min(end, entry.get(1));
                        int val = (newEnd - newStart + 1) * (mul+1);
                        max = Math.max(max, val);
                        List<Integer> key = Arrays.asList(newStart, newEnd);
                        if(newPairToAreaMap.containsKey(key)) {
                            val = Math.max(newPairToAreaMap.get(key), val);
                        }
                        newPairToAreaMap.put(Arrays.asList(newStart, newEnd), val);
                    }
                }
//                System.out.println("start : " + start + ", " + "end : " + end);
                List<Integer> arr = Arrays.asList(start, end);
                if(!newPairToAreaMap.containsKey(arr)) {
                    max = Math.max(max, end-start+1);
                    newPairToAreaMap.put(arr, end-start+1);
                }

                i=j;
            }
//            System.out.println(newPairToAreaMap);
            pairToAreaMap = newPairToAreaMap;

        }
        return max;

    }

    public static int maxArea2(int[][] arr, int n, int m) {
        // Approach 2:
        int [] store = new int[m];
        int max=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                store[j] = arr[i][j]==0 ? 0 : store[j] + 1;
            }

            max = Math.max(calculate(store, m), max);
        }

        return max;
    }

    static int calculate(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int max = 0, temp, val;
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
                temp = arr[st.pop()];
                val = (i - 1 - (st.isEmpty() ? -1 : st.peek())) * temp;
                max = Math.max(max, val);
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            temp = arr[st.pop()];
            val = (n - 1 - (st.isEmpty() ? -1 : st.peek())) * temp;
            max = Math.max(max, val);
        }

        // System.out.println(max);
        return max;

    }
}
