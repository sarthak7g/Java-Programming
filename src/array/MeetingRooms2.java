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
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Tip: Think of the simple way to solve this question.</li>
 *      <li>Sort the array of intervals by startTime.</li>
 *      <li>We just need to maintain the endTime of each conference room, use MinHeap.</li>
 *      <li>Time complexity: O(n(log n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Separate startIndex and endIndex into new arrays and sort them.</li>
 *      <li>Now, apply or run two pointers approach, whenever start[i] >= end[j] i.e., meetings in one of the room has ended, else all the rooms are currently occupied and hence a new room needs to be allocated.</li>
 *      <li>Time complexity: O(n(log n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class MeetingRooms2 {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{15,25},{10,20}}));
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20},{25,45},{50,65},{35,55},{30,35}}));

        System.out.println(minMeetingRooms2(new int[][]{{0,30},{15,25},{10,20}}));
        System.out.println(minMeetingRooms2(new int[][]{{0,30},{5,10},{15,20},{25,45},{50,65},{35,55},{30,35}}));
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

    public static int minMeetingRooms2(int[][] arr) {
        int[] start = new int[arr.length];
        int[] end = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            start[i] = arr[i][0];
            end[i] = arr[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0, i=0, j=0;

        while(i<arr.length && j<arr.length) {
            if(start[i] >= end[j]) {
                i++;
                j++;
            }else {
                i++;
                count++;
            }
        }

        return count;
    }
}
