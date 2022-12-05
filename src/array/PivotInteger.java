package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-pivot-integer">Find the Pivot Integer</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Calculate total sum</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class PivotInteger {

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
        System.out.println(pivotInteger(4));
    }

    public static int pivotInteger(int n) {
        int total = (n*(n+1))/2, sum=0;
        for(int i=1; i<=n ; i++) {
            sum += i;
            if (total-sum+i == sum)
                return i;
        }
        return -1;
    }
}
