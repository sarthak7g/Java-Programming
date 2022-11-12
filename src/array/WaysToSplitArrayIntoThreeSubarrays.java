package array;

import java.util.TreeMap;

public class WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        System.out.println(waysToSplit(new int[]{4,2,3,0,3,5,3,12}));
        System.out.println(waysToSplit(new int[]{7,0,5}));
        System.out.println(waysToSplit(new int[]{1,2,2,2,5,0}));
        System.out.println(waysToSplit(new int[]{8892, 2631, 7212, 1188, 6580, 1690, 5950, 7425, 8787, 4361, 9849, 4063, 9496, 9140, 9986, 1058, 2734, 6961, 8855, 2567, 7683, 4770, 40, 850, 72, 2285, 9328, 6794, 8632, 9163, 3928, 6962, 6545, 6920, 926, 8885, 1570, 4454, 6876, 7447, 8264, 3123, 2980, 7276, 470, 8736, 3153, 3924, 3129, 7136, 1739, 1354, 661, 1309, 6231, 9890, 58, 4623, 3555, 3100, 3437}));
    }

    public static int waysToSplit(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer st_sum, end_sum;
        int sum = 0, ls = 0, si, ei;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        // System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            ls += nums[i];

            st_sum = map.ceilingKey(2 * ls);
            if (st_sum == null) {
                break;
            } else si = map.get(st_sum);
            si = Math.max(i + 1, si);

            end_sum = (sum + ls) / 2;
            end_sum = map.floorKey(end_sum);
            if (end_sum == null) {
                ei = i + 1;
            } else ei = map.get(end_sum);
            int k = ei + 1;
            while (k < nums.length && nums[k] == 0) {
                k++;
            }
//            System.out.println(si + " " + k);

            if (k > si) ans += k - si;
            else break;

        }

        return (int) (ans % 1000000007);
    }
}
