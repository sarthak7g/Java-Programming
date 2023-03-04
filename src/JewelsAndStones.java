import java.util.HashSet;
import java.util.Set;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/jewels-and-stones/description/">Jewels and Stones</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: HashMap</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int i=0; i<jewels.length(); i++)
            set.add(jewels.charAt(i));
        for(int i=0; i<stones.length(); i++) {
            if(set.contains(stones.charAt(i))) res += 1;
        }
        return res;
    }
}
