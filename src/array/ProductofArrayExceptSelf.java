package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/product-of-array-except-self/">Product Of Array Except Self</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Maintain fwd product and backward product. We will only use an array for forward product</li>
 *          <li>Time complexity: O(n)</li>
 *      </ul>
 */

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] arr) {
        int[] fwdProduct = new int[arr.length];
        int prod = 1;
        for(int i=0; i<arr.length; i++) {
            prod *= arr[i];
            fwdProduct[i] = prod;
        }
        prod = 1;
        for(int i=arr.length-1; i>0; i--) {
            fwdProduct[i] = fwdProduct[i-1] * prod;
            prod *= arr[i];
        }
        fwdProduct[0] = prod;
        return fwdProduct;
    }
}
