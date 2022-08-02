import java.util.PriorityQueue;

/**
 *
 * Level: Hard
 * refer to: https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Approach:
 *      To find median we need to keep track of the highest element to the left side of a median and the lowest element to the right side of a median.
 *      We can solve this by having max heap for the left half and min heap for the right half.
 *
 * Time complexity: O(log(n))
 *
 */

public class MedianOfStreamOfIntegers {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double median;

    public MedianOfStreamOfIntegers() {
        minHeap = new PriorityQueue<>((o1, o2)-> o1-o2);
        maxHeap = new PriorityQueue<>((o1, o2)-> o2-o1);
        median = 0;
    }

    public void addNum(int num) {
        if(num <= median) {
            maxHeap.add(num);
            int diff = maxHeap.size()-minHeap.size();
            if(diff == 1) {
                median = maxHeap.peek();
                // printall(minHeap, maxHeap, median);
                return;
            }
            if(diff > 1) {
                minHeap.add(maxHeap.poll());
            }
        }else {
            minHeap.add(num);
            int diff = minHeap.size()-maxHeap.size();
            if(diff == 1) {
                median = minHeap.peek();
                // printall(minHeap, maxHeap, median);
                return;
            }
            if(diff > 1) {
                maxHeap.add(minHeap.poll());
            }
        }


        median = (double)(maxHeap.peek() + minHeap.peek())/2;
        // printall(minHeap, maxHeap, median);
    }

    public double findMedian() {
        return this.median;
    }

    private void printall(PriorityQueue<Integer> minHeap,
                          PriorityQueue<Integer> maxHeap, double median){
        System.out.println("minHeap: " + minHeap);
        System.out.println("maxHeap: " + maxHeap);
        System.out.println("median: " + median);
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 2, 9, 7, 6, 4};
        MedianOfStreamOfIntegers obj = new MedianOfStreamOfIntegers();
        for (int i = 0; i < arr.length; i++) {
            obj.addNum(arr[i]);
            System.out.println(obj.findMedian());
        }
    }
}
