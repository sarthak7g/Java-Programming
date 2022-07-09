/**
 *
 * Refer: https://practice.geeksforgeeks.org/problems/count-element-occurences/0/?category%5B%5D=Searching&page=1&query=category%5B%5DSearchingpage1
 *
 * The question generally asked like count elements which occur more than N/3 or N/4 times.
 *
 * The given solution takes O(NK) time and O(k-1) space.
 *
 */

public class CountOccurenceMoreThanNByK {


    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        Pair[] pairs = new Pair[k - 1];

        for (int j = 0; j < k - 1; j++) {
            pairs[j] = new Pair();
        }
        for (int j = 0; j < k - 1; j++) {
            pairs[j].count = 0;
        }

        int j, l;

        // outer loop through arr
        for (int i = 0; i < n; i++) {

            //check if elem already exists in pairs array
            for (j = 0; j < k - 1; j++) {
                if (pairs[j].elem == arr[i]) {
                    pairs[j].count++;
                    break;
                }
            }

            // if a new element has come, then go inside
            if (j == k - 1) {
                // check if any position is empty
                for (l = 0; l < k - 1; l++) {
                    if (pairs[l].count == 0) {
                        pairs[l].elem = arr[i];
                        pairs[l].count = 1;
                        break;
                    }
                }

                // if all positions are occupied, then decrease 1 to each pair
                if (l == k - 1) {
                    for (l = 0; l < k - 1; l++) {
                        pairs[l].count--;
                    }
                }
            }

        }

        // print all the final elements
        // for(j=0; j<k-1; j++) {
        //   System.out.println(pairs[j].elem + " " + pairs[j].count);
        // }

        // count the occurences of all elements
        int val = n / k, tempCount, countTotalElems = 0;
        for (j = 0; j < k - 1; j++) {
            tempCount = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == pairs[j].elem) {
                    tempCount++;
                }
            }
            if (tempCount > val) countTotalElems++;

        }

        return countTotalElems;

    }
}

class Pair {
    int elem;
    int count;
}

