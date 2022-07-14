import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Level: Medium
 * refer to: https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/#
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */


public class FindNextGreaterElement {

    public static void main(String[] args) {
        long [] ans = nextLargerElement(new long[]{12, 12, 12, 12, 1, 2, 3, 10, 19}, 9);
        System.out.println(Arrays.toString(ans));
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Integer> st = new Stack<>();
        st.push(0);


        for(int i=1; i<n; i++) {
            while(st.size()>0 && arr[st.peek()] < arr[i]) {
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while(st.size()>0){
            arr[st.pop()] = -1;
        }
        return arr;
    }
}
