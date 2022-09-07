package dp.lcs.variations;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1">All Palindromic Subsequences</a>
 * <br/>
 *  Approach 1:
 *      <ul>
 *          <li>Recursive Dp</li>
 *          <l1>if s[i] == s[j], ans[i, j] = ans[i+1, j] + ans[i, j-1] + 1</l1>
 *          <l1>else ans[i, j] = ans[i+1, j] + ans[i, j-1] - ans[i+1, j-1]</l1>
 *          <li>Time complexity: O(n^2)</li>
 *          <li>Space complexity: O(n^2)</li>
 *          <li>refer: <a href="https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count_palindromic_subsequence/topic">Solution</a></li>
 *      </ul>
 * </body>
 */

public class AllPalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPS("pppppppppppppppppppppppppppppppppppppppppppppppppp"));
        System.out.println(countPS("ppppppppppppppppppppppppppppdsafhbjknlmafdfvasvnkmavapppppppppppppppppppppp"));
    }

    static long countPS(String s)
    {
        long[][] arr = new long[1001][1001];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                arr[i][j] = -1;
            }
        }
        long ans = find(s, 0, s.length()-1, arr);
        return (long)(ans % (Math.pow(10, 9) + 7));
    }

    static long find(String str, int i, int j, long[][] arr) {
        if(i>j) {
            return 0;
        }

        if(arr[i][j] != -1) return arr[i][j];

        if(i == j) {
            arr[i][j] = 1;
            return 1;
        }

        long subAns;

        if(str.charAt(i) == str.charAt(j))
            subAns = find(str, i, j-1, arr) + find(str, i+1, j, arr) + 1;

        else subAns = find(str, i, j-1, arr) + find(str, i+1, j, arr) - find(str, i+1, j-1, arr);

        arr[i][j] = (long)(subAns % (Math.pow(10, 9) + 7));
        return subAns;

    }
}
