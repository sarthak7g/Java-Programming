package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/">Maximum Sum of an Hourglass</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Recursive DP</li>
 *      <li>Time complexity: O(2^n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 *
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Search for the pattern '010' and '101'.</li>
 *      <li>Consider for pattern '010' at each one calculate number of zeros at left and number of zeros at right. Same goes for second pattern.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class NumberOfWaysToSelectBuildings {
    public static void main(String[] args) {
        System.out.println(numberOfWays("001101"));
        System.out.println(numberOfWays("0011001010100"));
        System.out.println(numberOfWays("11100"));
        System.out.println(numberOfWays("0001001010101101"));

        System.out.println(numberOfWays2("001101"));
        System.out.println(numberOfWays2("0011001010100"));
        System.out.println(numberOfWays2("11100"));
        System.out.println(numberOfWays2("0001001010101101"));
    }
    static Map<List<Integer>, Long> dp;
    public static long numberOfWays(String s) {
        dp = new HashMap<>();
        return solve(s, '0', 0, 3) + solve(s, '1', 0, 3);
    }

    public static long solve(String s, char c, int index, int num_left) {
        if(num_left == 0) return 1;
        if(index > s.length() || num_left > s.length()-index) return 0;

        List<Integer> l = new ArrayList<>();
        if(c == '0') l.add(0);
        else l.add(1);
        l.add(index);
        l.add(num_left);

        if(dp.containsKey(l)) {
            return dp.get(l);
        }
        long ans = solve(s, c, index+1, num_left);
        if(s.charAt(index) == c) {
            ans += solve(s, opposite(c), index+1, num_left-1);
        }
        dp.put(l, ans);
        return ans;
    }

    public static long numberOfWays2(String s) {
        int n = s.length(), count = 0;

        // count number of '0's and '1's.
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }

        int zeros=0, ones=0;
        long ans=0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '1') {
                ones++;
                ans += ((long) zeros * (n-count-zeros));
            }
            else {
                zeros++;
                ans += ((long) ones * (count-ones));
            }
        }
        return ans;
    }

    public static char opposite(char c) {
        if(c == '0') return '1';
        return '0';
    }
}
