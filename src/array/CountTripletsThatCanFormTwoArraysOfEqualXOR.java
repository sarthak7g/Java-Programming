package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">Count Triplets That Can Form Two Arrays of Equal XOR</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Intuition: Suppose the xor sum at i=0 is 1 and xor sum at i=3 is also 1, then the number of triplets are (3-0)-1=2.</li>
 *      <li>Create a map and store the indexes where the same xor sum is found.</li>
 *      <li>Iterate over the indexes for that xor sum and update the answer accordingly.</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Now, after getting a list of indexes where the prefix sum is same, how can we reduce the time to compute the response from O(n^2) to O(n).</li>
 *      <li>For ex: i/p is [1,1,1,1,1,1]. Now, you get prefix_sum=0 at indexes [-1, 1, 3, 5]. In the first approach we basically ran two loops.</li>
 *      <li>Now, if we write the answer for index=5, we get equation as: <br/>
 *      5 -(-1) -1 + <br/>
 *      5 -1 -1 + <br/>
 *      5 -3 -1 <br/>
 *      = 3*5 - 3 -(-1 + 1 + 3) <br/>
 *      = 3*(5-1) -(-1 + 1 + 3) <br/>
 *      Therefore, we can say that at each index, <br/> <b>answer = count * (i-1) - sumOfIndexes</b>
 *      </li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println();
        System.out.println(countTriplets2(new int[]{1, 1, 1, 1, 1}));
        System.out.println(countTriplets2(new int[]{2, 3, 1, 6, 7}));
    }

    public static int countTriplets(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        temp.add(-1);
        Map<Integer, List<Integer>> map = new HashMap() {
            {
                put(0, temp);
            }
        };

        int ans = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
            List<Integer> al = map.getOrDefault(sum, new ArrayList<>());
            // System.out.println(al);
            for (int el : al) {
                ans += i - el - 1;
            }
            al.add(i);
            map.put(sum, al);
            // System.out.println(map);
        }

        return ans;
    }

    public static int countTriplets2(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>(), sumOfIndexes = new HashMap<>();
        count.put(0, 1);
        sumOfIndexes.put(0, -1);

        int ans=0, prefix=0, c, t;
        for(int i=0; i<arr.length; i++) {
            prefix ^= arr[i];

            c = count.getOrDefault(prefix, 0);
            t = sumOfIndexes.getOrDefault(prefix, 0);

            ans +=  c * (i-1) - t;

            count.put(prefix, c+1);
            sumOfIndexes.put(prefix, t+i);

        }

        return ans;
    }
}

