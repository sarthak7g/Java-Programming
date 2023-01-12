package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/description/">Maximize Number of Subsequences in a String</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Use two count variables for both the characters. First find the total subsequences without changing the text.</li>
 *      <li>Max sequences for the first char can always be at text[0], similarly max sequences for the second char will always be at text[n].</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class MaximizeNumberOfSubsequencesInString {
    public static void main(String[] args) {
        System.out.println(maximumSubsequenceCount("abdcdbc", "ac"));
        System.out.println(maximumSubsequenceCount("aabb", "ab"));
        System.out.println(maximumSubsequenceCount("vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign", "rr"));
        System.out.println(maximumSubsequenceCount("zigfj", "ju"));
    }

    public static long maximumSubsequenceCount(String text, String pat) {
        long ans = 0;
        int n = text.length(), first = 0, second = 0;

        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == pat.charAt(1)) {
                second++;
                ans += first;
            }
            if (text.charAt(i) == pat.charAt(0)) {
                first++;
            }
        }

        return Math.max(first, second) + ans;
    }
}
