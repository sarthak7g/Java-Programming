package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/">Final Prices With a Special Discount in a Shop</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class FinalPricesWithSpecialDiscountInAShop {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] finalPrices(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < stack.getFirst()) {
                stack.remove();
            }
            if (stack.isEmpty()) ans[i] = arr[i];
            else ans[i] = arr[i] - stack.getFirst();

            stack.addFirst(arr[i]);
        }
        return ans;
    }
}
