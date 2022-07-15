import java.util.HashMap;
import java.util.Map;

/**
 *
 * Level: Hard
 * refer to: https://workat.tech/problem-solving/practice/longest-substring-without-repeat
 *
 * Approach-
 *      1) Maintain a hashmap to know the already seen elements. Set is not used because indexes are also needed.
 *      2) While traversing ahead check if the element is seen after the count has started or not.
 *      (This is the most crucial condition). If yes, then change count, i.e., count = currIndex[elem] - prevIndex[elem]
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 */
public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeat("wwworkateabhisamikarnajayashikorzq"));
    }


    static int longestSubstringWithoutRepeat(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen=0, i=0, count=0;
        for(; i<s.length(); i++) {
            char curVal = s.charAt(i);
            if(map.containsKey(curVal) && map.get(curVal) >= i-count) {
                maxLen = Math.max(maxLen, count);
                // System.out.println(i + " : " + count + " : " + maxLen);
                count = i-map.get(curVal);
            }else {
                count += 1 ;
                // System.out.println(i + " : " + count + " : " + maxLen);
            }
            map.put(s.charAt(i), i);
        }
        // System.out.println(i + " : " + count + " : " + maxLen);
        maxLen = Math.max(maxLen, count);
        return maxLen;
    }
}