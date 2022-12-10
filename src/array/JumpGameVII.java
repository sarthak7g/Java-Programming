package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/jump-game-vii/description/">Jump Game VII</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Use Queue to store index. At each index where s[i] = '0', check if it is reachable by previous indexes or not.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class JumpGameVII {
    public static void main(String[] args) {
        System.out.println(canReach("01", 1, 1));
        System.out.println(canReach("000000001", 2, 4));
        System.out.println(canReach("011010", 2, 3));
        System.out.println(canReach("0000000", 2, 3));
        System.out.println(canReach("011000001011110000", 4, 7));
    }
    public static boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        for(int i=minJump; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                while(!q.isEmpty() && q.peek()<i-maxJump) q.poll();

                if(q.isEmpty()) return false;
                if(q.peek() + minJump <= i) {
                    q.add(i);
                    if(i == s.length()-1) return true;
                }
            }
        }
        return false;
    }
}
