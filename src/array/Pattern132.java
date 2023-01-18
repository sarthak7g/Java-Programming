package array;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[] {3,5,0,3,2}));
        System.out.println(find132pattern(new int[] {3,1,4,2}));
        System.out.println(find132pattern(new int[] {-1,3,2,0}));
        System.out.println(find132pattern(new int[] {3,5,0,3,4}));
        System.out.println(find132pattern(new int[] {1,4,0,-1,-2,-3,-1,-2}));
    }

    public static boolean find132pattern(int[] arr) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        int high;
        for (int j : arr) {
            if (s2.empty()) {
                if (s1.empty()) {
                    s1.push(j);
                } else if (s1.size() == 1) {
                    if (j <= s1.peek()) s1.pop();
                    s1.push(j);
                } else {
                    high = s1.pop();
                    if (j >= high) {
                        s1.push(j);
                        continue;
                    } else if (j > s1.peek()) return true;
                    else if (j < s1.peek()) {
                        s2.push(j);
                    }
                    s1.push(high);
                }
            } else {
                high = s1.pop();
                if (j >= high) {
                    s1.pop();
                    s1.push(s2.pop());
                    s1.push(j);
                    continue;
                } else if (j <= s2.peek()) {
                    s2.pop();
                    s2.push(j);
                } else if (j > s1.peek()) {
                    return true;
                }
                s1.push(high);
            }
//            System.out.println(i + " " + s1 + " " + s2);
        }
        return false;
    }
}
