
public class LongestConsecutiveSubseq {

    /**
     *  Refer to https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#
     */
    static int findLongestConseqSubseq(int arr[], int N)
    {
        int[] nums = new int[100001];

        for(int i=0; i<N; i++) {
            nums[arr[i]] = 1;
        }
        int maxCount = 0, count=1;
        for(int i=1; i<100001; i++) {

            if(nums[i-1] == nums[i] && nums[i]==1) {
                count+=1;
            }else if(nums[i] == 1) {
                count = 1;
            }else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }

        }

        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(findLongestConseqSubseq(new int[]{1, 5, 6, 99999, 100000, 99998}, 6));
    }
}
