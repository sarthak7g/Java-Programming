import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1">Isomorphic Strings</a>
 * <br/>
 * Approach :
 *      <ul>
 *          <li>While traversing str1 check,</li>
 *          <li>if the str1 char is seen first time, and the str2 char is also seen first time, then create an entry into the map and in the set</li>
 *          <li>if the str1 char is seen first time, and the str2 char is also seen before, return false</li>
 *          <li>if the str1 char is inside the map, then check if it matches with str2 char at that position or not</li>
 *      </ul>
 * Time complexity: O(n) <br/>
 * Space complexity: O(n)
 * </body>
 */

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(areIsomorphic("aaxv", "aara"));
        System.out.println(areIsomorphic("abcde", "bcdea"));
    }

    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length() != str2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<str1.length(); i++) {
            if(map.containsKey(str1.charAt(i))) {
                if(map.get(str1.charAt(i)) != str2.charAt(i)) return false;
            }
            else if(set.contains(str2.charAt(i))) return false;
            else{
                map.put(str1.charAt(i), str2.charAt(i));
                set.add(str2.charAt(i));
            }

        }
        return true;
    }
}
