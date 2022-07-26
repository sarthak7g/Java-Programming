/**
 *
 * Level: Hard
 * refer to: https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
 *
 * Approach:
 *      -> two pointers left and right at beginning and end of string respectively.
 *      -> if characters ore equal at both pointer, then decrease left and right by 1
 *      -> if unequal, then 1) move towards right to find the next element matches at right
 *                       2) if not found then move towards left till next element matches left is found
 *
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 *
 */

public class MinSwapsToMakeArrayPalindrome {
    public static void main(String[] args) {
        System.out.println(minMovesToMakePalindrome("aabbcrdcd"));
    }
    public static int minMovesToMakePalindrome(String str) {
        char arr[] = str.toCharArray();
        int right=str.length()-1, left = 0, k, count = 0, temp;

        while(left < right) {
            if(arr[left] == arr[right]) {
                left += 1;
                right -= 1;
            }
            else {
                k = left+1;
                while(k<right && arr[k] != arr[right]) {
                    k++;
                }
                if(k!=right) {
                    temp = k-left;
                    count += temp;
                    while(k>left) {
                        arr[k] = arr[k-1];
                        k--;
                    }
                    arr[left] = arr[right];
                    // System.out.println(Arrays.toString(arr) + " : " + temp);
                }else {
                    k = right-1;
                    while(k>left && arr[k] != arr[left]) {
                        k--;
                    }
                    if(k>left) {
                        temp = right-k;
                        count += temp;
                        while(k<right) {
                            arr[k] = arr[k+1];
                            k++;
                        }
                        arr[right] = arr[left];
                    }
                }

            }

        }

        return count;
    }
}
