package Queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]*/
public class MaxSlidingWindow8 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        List<Integer> ans = maxSlidingWindow( nums,k);
        for(int i=0; i<ans.size(); i++)
        {
//            System.out.println("ans:  ");
            System.out.println(ans.get(i));
        }
    }
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<k; i++)
        {
            insertAtBack(deque,i,nums);
        }
        for(int i=k; i< nums.length; i++)
        {
            ans.add(nums[deque.getFirst()]);

            // how ??
            if(deque.getFirst() == (i-k))
                deque.remove();
            insertAtBack(deque,i,nums);

        }
        ans.add(nums[deque.getFirst()]);
        return ans;

    }

    static void insertAtBack(Deque<Integer> deque, int index, int[] nums)
    {
        while(!deque.isEmpty() && nums[index] >= nums[deque.getLast()])
        {
            deque.removeLast();
        }
        deque.addLast(index);
    }
}
