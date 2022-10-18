package array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1}, 2));
        System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 2));
    }
    public static int longestOnes(int[] nums, int k) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        int sum=0, ans=0;
        for(int  val : nums) {
            sum += val;
            if(val == 0)
                map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        List<Integer> al = new ArrayList<>(map.keySet());
        // System.out.println(al);

        int start, zeros, ones=0, j;
        for(int i=0; i<al.size(); i++) {
            zeros = k;
            start = i>0 ? al.get(i-1) : 0;
            j = i;
            while(j<al.size() && zeros>=0) {
                ones = al.get(j) - start;
                zeros -= map.get(al.get(j));
                j++;
            }

            if(zeros >= 0) {
                ones = sum-start+k-zeros;
            }else ones += k;
//            System.out.println(ones);
            ans = Math.max(ans, ones);
        }
        if(al.size() != 0) {
            start = al.get(al.size()-1);
            ones = sum-start+k;
            ans = Math.max(ans, ones);
        }

        return ans;
    }
}
