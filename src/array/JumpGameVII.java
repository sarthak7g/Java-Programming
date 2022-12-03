package array;

public class JumpGameVII {
    public static void main(String[] args) {
        System.out.println(canReach("01", 1, 1));
        System.out.println(canReach("000000001", 2, 4));
        System.out.println(canReach("011010", 2, 3));
        System.out.println(canReach("0000000", 2, 3));
        System.out.println(canReach("011000001011110000", 4, 7));
    }
    public static boolean canReach(String s, int min, int max) {
//        System.out.println(s.length());
        int st=min, end=max, ns=min, ne=max;
        if(s.charAt(s.length()-1) == '1') return false;
        if(end == s.length()-1) return true;
        for(int i=0; i<s.length(); i++) {
            if(i > end) {
                return false;
            }
            if(i>=st && i<=end && s.charAt(i) == '0') {
                if(ns == st) {
                    ns = i+min;
                }else {
                    ns = Math.min(ns, i+min);
                }
                ne = i + max;

                if(ns <= s.length()-1 && ne >= s.length()-1) return true;

            }
            if(i == end && ns < s.length()) {
                st = ns;
                end = ne;
            }
//            System.out.println(i + " " + ns + " " + ne);
        }
        return false;
    }
}
