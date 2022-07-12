import java.util.HashMap;
import java.util.Map;


/**
 *
 * Level: Easy
 * refer to: https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1#
 *
 * Approach -
 *      Create a hashmap of size m(for the smaller array, i.e., a2).
 *      While traversing through a1 decrement the count of elements in hashmap
 *      If the count>=1, a2 is not the subset
 *
 * Time complexity: O(n)
 * Space complexity: O(m)
 */

public class IfArrayIsSubsetOfAnother {

    public static void main(String[] args) {
        long a1[] = {11, 1, 13, 21, 3, 7};
        long a2[] = {11, 3, 7, 1};
        System.out.println(isSubset(a1, a2, a1.length, a2.length));
    }
    public static String isSubset( long a1[], long a2[], long n, long m) {
        if(m>n) {
            return "No";
        }

        Map<Long, Long> map = new HashMap<>();
        for(int i=0; i<m; i++) {
            if(map.containsKey(a2[i])) {
                map.put(a2[i], map.get(a2[i])+1);
            }else {
                map.put(a2[i], 1L);
            }
        }

        for(int i=0; i<n; i++) {
            if(map.containsKey(a1[i])) {
                map.put(a1[i], map.get(a1[i])-1);
            }
        }

        String ans = map.values().stream().filter(x -> x>0).count() > 0 ? "No" : "Yes";
        return "No";
    }
}
