package array;


import java.util.TreeMap;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/">Get Equal Substrings Within Budget</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Find the absolute value of the difference between each characters of string s and t starting from i=0.</li>
 *      <li>As you progress calculate prefix sum and find the ceilingKey in TreeMap of sum-maxCost and update the answer.</li>
 *      <li>Time complexity: O(n * log n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <br/>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Sliding Window Approach</li>
 *      <li>Find the absolute value of the difference between each characters of string s and t starting from i=0 and store it into an array.</li>
 *      <li>Use two pointers sliding window approach to find maximum answer.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
        System.out.println(equalSubstring("abcdxscccr", "abehxsccct", 3));
        System.out.println(equalSubstring("abcdxscccra", "abehxscccth", 3));
        System.out.println();
        System.out.println(equalSubstring2("abcd", "bcdf", 3));
        System.out.println(equalSubstring2("abcd", "cdef", 3));
        System.out.println(equalSubstring2("abcd", "acde", 0));
        System.out.println(equalSubstring2("abcdxscccr", "abehxsccct", 3));
        System.out.println(equalSubstring2("abcdxscccra", "abehxscccth", 3));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);


        int sum=0, ans=0;
        Integer idx;

        for(int i=0; i<s.length(); i++) {
            sum += Math.abs(s.charAt(i)-t.charAt(i));
            idx = map.ceilingKey(sum-maxCost);

            if(idx == null) {
                idx = map.get(map.lastKey())+1;
            }else idx = map.get(idx);

            ans = Math.max(ans, i-idx);

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return ans;
    }

    public static int equalSubstring2(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];

        int ans=0, left=0, wsize=0;

        for(int i=0; i<s.length(); i++) {
            arr[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        for(int right=0; right<arr.length; right++) {
            wsize += arr[right];
            while(wsize > maxCost && left<=right) {
                wsize -= arr[left++];
            }

            ans = Math.max(ans, right-left+1);
        }


        return ans;
    }
}
