package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/">Get Equal Substrings Within Budget</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Find the absolute value of the difference between each characters of string s and t starting from i=0.</li>
 *      <li>As you progress calculate prefix sum and find the key(using binary search) in hashmap greater than or equal to sum-maxCost and update the answer.</li>
 *      <li>Time complexity: O(n * log n)</li>
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
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        List<Integer> al = new ArrayList<>();
        al.add(0);

        int sum=0, ans=0, idx;

        for(int i=0; i<s.length(); i++) {
            sum += Math.abs(s.charAt(i)-t.charAt(i));
            idx = find(al, sum-maxCost);

            if(idx == al.size()) {
                idx = map.get(al.get(idx-1))+1;
            }else {
                idx = map.get(al.get(idx));
            }

            ans = Math.max(ans, i-idx);

            if(!map.containsKey(sum)) {
                map.put(sum, i);
                al.add(sum);
            }
        }

        return ans;
    }

    public static int find(List<Integer> al, int x) {
        int left=0, right=al.size()-1, mid;
        while(left <= right) {
            mid = (left+right)/2;
            if(x == al.get(mid)) return mid;

            if(x > al.get(mid)) {
                left = mid+1;
            }

            else right = mid-1;

        }


        return left;
    }
}
