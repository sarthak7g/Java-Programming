package array;

import java.util.TreeMap;

public class MaximumWhiteTilesCoveredByACarpet {
    public static void main(String[] args) {

    }

    public int maximumWhiteTiles(int[][] tiles, int cl) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = 0, sum = 0, left = 0, ans = 0, max = 0, temp;
        boolean flag=false;
        map.put(-1, -1);
        for(int[] tile : tiles) {
            n = Math.max(n, tile[1]);
            map.put(tile[0], map.getOrDefault(tile[0], 0)+1);
            map.put(tile[1]+1, map.getOrDefault(tile[1]+1, 0)-1);
        }

        System.out.println(map);

        // sliding window
        for(int right=0; right<=n; right++) {
            if(right-left > cl) {
                Integer val = map.floorKey(left);
                if(val != null && val != -1) {
                    ans -= 1;
                }
                left++;
            }
            temp = map.getOrDefault(right, 0);
            if(temp == -1) {
                flag = false;
            }
            else if(temp == 1) {
                flag = true;
            }
            if(flag) ans += 1;
            System.out.println(left + " " + right + " " + ans);
            max = Math.max(ans, max);
        }

        return max;
    }
}
