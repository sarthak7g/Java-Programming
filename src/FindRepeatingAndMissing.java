import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1">Find Missing and Repeating</a>
 * <br/>
 * Approach 1:
 *      <ul>
 *          <li>Consider each value as the position of an element, so index=position-1</li>
 *          <li>Traverse through the array, negate the item pointed by the current element at that index, only if if it positive</li>
 *          <li>if the item at that index is -ve, i.e., we got a duplicate element</li>
 *          <li>Iterate the array again, the item which is positive is missing</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(1)</li>
 *      </ul>
 */

public class FindRepeatingAndMissing {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoElement(new int[]{1, 3, 5, 5, 4})));
    }

    static int[] findTwoElement(int[] arr) {
        int dup=0, miss=0, n= arr.length;

        for(int i=0; i<n; i++) {
            int abs = Math.abs(arr[i]);
            if(arr[abs-1] > 0) {
                arr[abs-1] = -arr[abs-1];
            }else {
                dup = abs;
            }

        }

        for(int i=0; i<n; i++) {
            if(arr[i] > 0) {
                miss = i+1;
                break;
            }

        }
        return new int[]{dup, miss};
    }
}
