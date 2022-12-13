package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntervalsBetweenIdenticalElements {
    public static void main(String[] args) {

    }

    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n ;i++) {
            List<Integer> l;
            if(map.containsKey(arr[i])) {
                l = map.get(arr[i]);
            }
            else l = new ArrayList<Integer>();
            l.add(i);
        }
        System.out.println(map);

        for(Entry<Integer> entry : map.entrySet()) {
            solve(map.get(entry), ans);
        }

        return ans;
    }

    public long solve(List<Integer> list, long[] ans) {
        int n = list.size();
        long[] arr = new long[n+1];

        for(int i=0; i<n; i++) {
            arr[i+1] = arr[i] + list.get(i);
        }
        return ans;
    }
}
