import java.util.Arrays;

/**
 *
 * Level: Easy
 * refer to: https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
 *
 * Approach-
 *      1) Count number of elements less than a and greater than b.
 *      2) two pointers -> left and right
 *
 * Time complexity: O(n)
 *
 */

// two pointers -> left and right, increment when left is found or right is found

public class ThreeWayPartion {
    public static void main(String[] args) {
        int arr[] = {39, 81, 19, 22, 71};
        threeWayPartition(arr, 13, 25);
        System.out.println(Arrays.toString(arr));
    }
    private static void threeWayPartition(int arr[], int a, int b)
    {

        int counta=0, countb=0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<a) {
                counta += 1;
            }else if(arr[i]>b) {
                countb += 1;
            }
        }

        int left=0, right=arr.length-1, index=0, temp;
        while(index<arr.length && left<counta && right>=arr.length-countb) {
            if(arr[index] < a) {
                temp = arr[left];
                arr[left] = arr[index];
                arr[index] = temp;
                left++;
                index++;
            }else if(arr[index] > b) {
                temp = arr[right];
                arr[right] = arr[index];
                arr[index] = temp;
                right--;
            }else index++;
        }

        while(index<arr.length && left<counta) {
            if(arr[index]<a) {
                temp = arr[left];
                arr[left] = arr[index];
                arr[index] = temp;
                left += 1;
            }
            index++;
        }

        while(index<arr.length && right>=arr.length-countb) {
            if(arr[index]>b) {
                temp = arr[right];
                arr[right] = arr[index];
                arr[index] = temp;
                right -= 1;
            }else index++;
        }

    }
}
