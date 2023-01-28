package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/online-stock-span/description/">Online Stock Span</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Use a stack and an array list</li>
 *      <li>Time complexity: O(1)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class OnlineStockSpan {

    public static void main(String[] args) {
        OnlineStockSpan obj = new OnlineStockSpan();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }

    Stack<Integer> s;
    List<Integer> l;
    int idx;
    public OnlineStockSpan() {
        s = new Stack<>();
        l = new ArrayList<>();
        idx = 0;
    }

    public int next(int price) {
        l.add(price);
        if(idx == 0) {
            s.push(idx);
            ++idx;
            return 1;
        }
        while(!s.empty() && price >= l.get(s.peek())) {
            s.pop();
        }
        int ans = s.empty() ? idx+1 : idx-s.peek();
        s.push(idx);
        ++idx;
        return ans;
    }
}
