import java.util.*;

public class topKElement {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3,3,4};
        int k = 2;

        topKElement sol = new topKElement();

        int[] result = sol.topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freqMap.get(b) - freqMap.get(a)
        );

        for(Integer key : freqMap.keySet()) {
            pq.add(key);
            int a = pq.peek();
            System.out.println(a);
        }

        int[] arr = new int[k];

        for(int i = 0; i < k; i++) {
            arr[i] = pq.poll();
        }

        return arr;
    }
}