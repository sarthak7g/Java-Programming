package array;

import java.util.HashMap;
import java.util.Map;

public class WildestPairOfIndices_PrefixSumLC {
    public static void main(String[] args) {
        int num1[] = {1,1,0,1};
        int num2[] = {0,1,1,0};
        System.out.println(widestPairOfIndices(num1,num2));
    }

    public static int widestPairOfIndices(int[] nums1, int[] nums2) {
        int j=0, n=nums1.length, s1=0, s2=0, dist=0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        while(j < n) {
            if(nums1[j] == 1) s1++;
            if(!map1.containsKey(s1)) map1.put(s1, j);

            if(nums2[j] == 1) s2++;
            if(!map2.containsKey(s2)) map1.put(s2, j);

            if(s1 == s2) {
                dist = Math.max(dist, j+1);
            }else if(s1 > s2) {
                dist = Math.max(dist, map1.get(s1-s2+1));
            }
            else dist = Math.max(dist, map2.get(s2-s1+1));

            j++;
        }
        return  dist;
    }
}
