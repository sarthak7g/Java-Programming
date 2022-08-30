package dp.lcs.variations;

public class PrintLCS {
    public static void main(String[] args) {
        System.out.println(findLCS("saransh", "sarthak"));
    }
    static String findLCS(String str1, String str2) {
        int m = str1.length()+1;
        int n = str2.length()+1;

        int[][] arr = new int[m][n];
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
            }
        }
        int i=m-1, j=n-1;
        StringBuilder ans = new StringBuilder();
        while(i>0 && j>0) {
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
                ans.insert(0, str1.charAt(i-1));
                i--;
                j--;
            }
            else if(arr[i][j] == arr[i-1][j]) {
                i--;
            }
            else j--;
        }
        return ans.toString();
    }
}
