package array;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/132-pattern/description/">132 Pattern</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Start from RHS, check if each element can be 3 in 132 pattern.</li>
 *      <li>Create a min array which will save min value or 1 at each index.</li>
 *      <li>While traversing from back we will maintain a stack, which will have the smallest element at the top.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class Pattern132 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[] {3,5,0,3,2}));
        System.out.println(find132pattern(new int[] {3,1,4,2}));
        System.out.println(find132pattern(new int[] {-1,3,2,0}));
        System.out.println(find132pattern(new int[] {3,5,0,3,4}));
        System.out.println(find132pattern(new int[] {1,4,0,-1,-2,-3,-1,-2}));
    }

    public static boolean find132pattern(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] min = new int[arr.length];
        min[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            min[i] = Math.min(arr[i], min[i-1]);
        }

        for(int j=arr.length-1; j>=0; j--) {
            if(arr[j] == min[j]) continue;
            while(!s.empty() && arr[j] > s.peek()) {
                if(s.peek() > min[j]) return true;
                s.pop();
            }
            s.push(arr[j]);
        }
        return false;
    }
}
