package array;

import java.util.TreeMap;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/">Find the Student that Will Replace the Chalk</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Use tree map.</li>
 *      <li>Time complexity: O(n*log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Hint: Just find total and then in the next loop compare with sum at index.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class StudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println(chalkReplacer(new int[]{3, 4, 1, 2}, 25));
        System.out.println();
        System.out.println(chalkReplacer2(new int[]{5, 1, 5}, 22));
        System.out.println(chalkReplacer2(new int[]{3, 4, 1, 2}, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        long sum = 0;
        map.put(0L, 0);

        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            map.put(sum, i + 1);
        }
        // System.out.println(map);

        long rem = k % sum;
        // System.out.println(rem);
        Long val = map.floorKey(rem);
        if (val != null) {
            return map.get(val);
        }
        return 0;
    }

    public static int chalkReplacer2(int[] chalk, int k) {
        long sum = 0;

        for (int j : chalk) {
            sum += j;
        }
        long rem = k % sum;

        if(rem == 0) return 0;

        sum = 0;
        for(int i=0; i<chalk.length; i++) {
            sum += chalk[i];
            if(sum == rem) {
                return i+1;
            }
            if(sum > rem) {
                return i;
            }
        }

        return 0;
    }
}
