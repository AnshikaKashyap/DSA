package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N]. Find the length of the longest consecutive sequence.
Input: Arr[ ] = {10, 3, 7, 9, 5, 4, 16, 20, 6, 5, 19}
Output: 5*/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {10, 3, 7, 9, 5, 4, 16, 20, 6, 5, 19};
        System.out.println(findLongestConsecutiveSequences(arr));

    }

    static int findLongestConsecutiveSequences(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i< arr.length; i++)
        {
            if(map.get(arr[i]) == null)
            {
                // fetch left and right streak
                int left_streak = map.get(arr[i]-1) == null? 0:map.get(arr[i]-1) ;
                int  right_streak = map.get(arr[i]+1) == null?0:map.get(arr[i]+1);

                // update answer
                ans = Math.max(ans,(left_streak+1+right_streak));

                // update streak of arr element as ls+1+rs
                map.put(arr[i],(left_streak+1+right_streak));

                // update streak of border element
                map.put(arr[i]-left_streak,(left_streak+1+right_streak));
                map.put(arr[i]+right_streak,(left_streak+1+right_streak));




            }
        }

        return ans;
    }
}
