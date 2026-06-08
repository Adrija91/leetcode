import java.util.*;

public class MeetingSchedule {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] meeting : intervals) {
            int start = meeting[0];
            int end = meeting[1];

            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            minHeap.offer(end);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingSchedule meetingSchedule = new MeetingSchedule();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meetingSchedule.minMeetingRooms(intervals1)); // 2

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(meetingSchedule.minMeetingRooms(intervals2)); // 1
    }
}