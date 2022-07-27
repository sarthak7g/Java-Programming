import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Level: Medium
 * refer to: https://practice.geeksforgeeks.org/problems/max-rectangle/1
 *
 * PS: This solution should be optimised
 *
 * Time complexity: O(m * n * n^2)
 * Space complexity: O(n)
 *
 */


public class MaxRectangle {
    public static void main(String[] args) {
//        int matrix[][] = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int matrix[][] = {{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}
        };
        System.out.println(maxArea(matrix, matrix.length, matrix[0].length));
    }

    public static int maxArea(int matrix[][], int n, int m) {
        Map<List<Integer>, Integer> pairToAreaMap = new HashMap<>();
        Map<List<Integer>, Integer> newPairToAreaMap = new HashMap<>();

        int max=0, start, end, i, j;
        for(int row=0; row<n; row++) {
            start=-1;
            end=-1;
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
                System.out.println("start : " + start + ", " + "end : " + end);
                List<Integer> arr = Arrays.asList(start, end);
                if(!newPairToAreaMap.containsKey(arr)) {
                    max = Math.max(max, end-start+1);
                    newPairToAreaMap.put(arr, end-start+1);
                }

                i=j;
            }
            System.out.println(newPairToAreaMap);
            pairToAreaMap = newPairToAreaMap;

        }
        return max;

    }
}
