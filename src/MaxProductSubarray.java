public class MaxProductSubarray {
    /**
     * PS: Given the list of integers, find the subarray with maximum product in O(N).
     * Ex1-
     *  i/p- {6, -3, -10, 0, 2}
     *  o/p- 180
     *
     * Ex2-
     *  i/p- {2, 3, 4, 5, -1, 0}
     *  o/p- 120
     *
     * Ex3-
     *  i/p- {0, 0, -5, 0, 0}
     *  o/p- 0
     *
     */

    long maxProduct(int[] arr, int n) {

        /**
         * Find the Forward product and Backward product.
         * Compare them to get the maximum
         */
        boolean isZero=false;
        long res, maxProd=1;

        long maxFwd=Integer.MIN_VALUE;
        long maxBwd=Integer.MIN_VALUE;

        int i=0;
        while(i<n) {
            maxProd*=arr[i];

            if(maxProd == 0) {
                isZero = true;
                maxProd=1;
                i++;
                continue;
            }
            // System.out.print(maxProd + "\t");
            maxFwd = Math.max(maxFwd, maxProd);
            i++;
        }

        i-=1;
        maxProd=1;
        while(i>=0) {
            maxProd*=arr[i];

            if(maxProd == 0) {
                isZero = true;
                maxProd=1;
                i--;
                continue;
            }

            maxBwd = Math.max(maxBwd, maxProd);
            i--;
        }

        res = Math.max(maxFwd, maxBwd);

        if(isZero)
            res = Math.max(0, res);

        return res;
    }

}
