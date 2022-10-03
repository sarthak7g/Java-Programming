package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h3>Level: Medium </h3>
 * <h4>LC PREMIUM</h4>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/meeting-rooms-ii/">Meeting Rooms II</a>
 * <br/>
 * <br/>
 * <b>Question:</b>
 * <ul>
 *     <li>Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.</li>
 * </ul>
 *
 * <b>Example:</b>
 * <ul>
 *      <li><b>Input:</b> intervals = [[0,30],[5,10],[15,20]]</li>
 *      <li><b>Output:</b> 2</li>
 * </ul>
 *
 * <b>Approach:</b>
 * <ul>
 *      <li>Tip: Think of the simple way to solve this question.</li>
 *      <li>Sort the array of intervals by startTime.</li>
 *      <li>We just need to maintain the endTime of each conference room, use MinHeap.</li>
 *      <li>Time complexity: O(n(log n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class MeetingRooms2_PrefixSum {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{15,25},{10,20}}));
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20},{25,45},{50,65},{35,55},{30,35}}));
    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int val;
        for(int[] arr : intervals) {
            if(pq.isEmpty()) {
                pq.add(arr[1]);
            }else {
                val = pq.peek();
                if(arr[0] >= val) {
                    pq.poll();
                }
                pq.add(arr[1]);
            }
        }

        return pq.size();
    }
}
