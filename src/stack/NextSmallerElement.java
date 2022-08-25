package stack;

import java.util.Stack;
import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://www.codingninjas.com/codestudio/problems/next-smaller-element_1112581?leftPanelTab=1">Next Smaller Element</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Start traversing from the last</li>
 *          <li>Push when the current element is greater than the stack top</li>
 *          <li>Pop all the elements from the stack until the current element becomes greater than stack top</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class NextSmallerElement{
	public static void main(String[] args) {
		int arr[] = {3, 6, 1, 2, 9, 5};
		System.out.println(Arrays.toString(findNextSmaller(arr)));
	}
	
	static int[] findNextSmaller(int [] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		
		Stack<Integer> st = new Stack();
		
		for(int j=n-1; j>=0; j--) {
			while (!st.empty() && arr[j]<=st.peek())
				st.pop();
			ans[j] =  st.empty() ? -1 : st.peek();
			st.push(arr[j]);
		}
		
		return ans;
	}
}
