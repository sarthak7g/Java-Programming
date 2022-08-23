package dp.lcs.variations;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("aaaabbaa"));
        System.out.println(longestPalindrome("abacdfgdcaba"));
    }
    static String longestPalindrome(String s){
        String s2 = reverse(s);
        System.out.println(s);
        System.out.println(s2);
        int n = s.length();
        int m = s2.length();
        int max=0, maxi=0, maxj=0;
        int arr[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                    if(arr[i][j] >= max) {
                        max = arr[i][j];
                        maxi=i;
                        maxj=j;
                    }
                }
            }
        }
        System.out.println(s.substring(maxi-arr[maxi][maxj], maxi));
        print(arr);
        return "";
    }

    private static String reverse(String s) {
        char[] arr = s.toCharArray();
        int i=0, j=s.length()-1;
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    static void print(int[][] arr) {
        Arrays.asList(arr).forEach(x->System.out.println(Arrays.toString(x)));
    }
}
