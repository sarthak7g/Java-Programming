package array;

public class NumberOfWaysToSelectBuildings {
    public static void main(String[] args) {

    }
    Map<List<Integer>, Long> dp = new HashMap<>();
    public long numberOfWays(String s) {
        return solve(s, '0', 0, 3) + solve(s, '1', 0, 3);
    }

    public long solve(String s, char c, int index, int num_left) {
        if(num_left == 0) return 1;
        if(index > s.length() || num_left > s.length()-index) return 0;

        List<Integer> l = new ArrayList<>();
        if(c == '0') l.add(0);
        else l.add(1);
        l.add(index);
        l.add(num_left);

        if(dp.containsKey(l)) {
            return dp.get(l);
        }
        long ans = solve(s, c, index+1, num_left);
        if(s.charAt(index) == c) {
            ans += solve(s, opposite(c), index+1, num_left-1);
        }
        dp.put(l, ans);
        return ans;
    }

    public char opposite(char c) {
        if(c == '0') return '1';
        return '0';
    }
}
