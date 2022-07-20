import java.util.ArrayList;

/**
 *
 * Level: Easy
 * refer to: https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 *
 * Time complexity: O(log(n))
 *
 */
public class FirstAndLastOccurencesOfX {
    public static void main(String[] args) {
        long arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125, 125 };
        System.out.println(find(arr, arr.length, 125));
    }
    static ArrayList<Long> find(long arr[], int n, int x)
    {
        int start = 0, end=n-1;
        int mid = (start+end)/2;
        while(start<=end) {
            if(arr[mid] == x) {
                break;
            }
            if(arr[mid]>x) {
                end = mid-1;
            }else start = mid+1;
            mid = (start+end)/2;
        }
        ArrayList<Long> ans = new ArrayList<>();

        if(start>end) {
            ans.add(-1L);
            ans.add(-1L);
            return ans;
        }

        long last = findLastOccurence(arr, mid, end, x);
        long first = findFirstOccurence(arr, start, mid, x);

        ans.add(first);
        ans.add(last);
        return ans;


    }

    static long findLastOccurence(long arr[], int start, int end, long x) {
        int mid = (start+end)/2;
        while(start<=end) {
            if(arr[mid] == x) {
                if(mid+1<=end && arr[mid+1]==x)
                    start = mid + 1;
                else return mid;
            }else {
                end = mid-1;
            }
            mid = (start + end)/2;
        }
        return mid;
    }

    static long findFirstOccurence(long arr[], int start, int end, long x) {
        int mid = (start+end)/2;
        while(start<=end) {
            if(arr[mid] == x) {
                if(mid-1>=start && arr[mid-1]==x)
                    end = mid;
                else return mid;
            }else {
                start = mid+1;
            }
            mid = (start + end)/2;
        }
        return mid;
    }
}
