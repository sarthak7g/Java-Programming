import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1">First non-repeating character in a stream</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use LinkedHashMap</li>
 *          <li>Time complexity: O(n * 26), where n is length of string</li>
 *          <li>Space complexity: O(26)</li>
 *      </ul>
 */

public class FirstNonRepeatingCharacterInAStream {
    public static void main(String[] args) {
        System.out.println(firstNonRepeating("zzdavavdgba"));
        System.out.println(firstNonRepeating("aabc"));
    }
    public static String firstNonRepeating(String str)
    {
        // code here
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);
            if(map.containsKey(temp)) {
                map.put(temp, map.get(temp)+1);
            }else map.put(temp, 1);

            ans.append(find(map));
        }
        return ans.toString();
    }

    public static char find(Map<Character, Integer> map) {
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
