package Hashing;

import java.util.HashMap;

/*We have been given an integer array Arr[N]. Find the length of the longest consecutive sequence.
Input: Arr[ ] = {10, 3, 7, 9, 5, 4, 16, 20, 6, 5, 19}
Output: 5*/
public class LongestConsecutiveSequence1 {
    public static void main(String[] args) {
        int[] arr = {10, 3, 7, 9, 5, 4, 16, 20, 6, 5, 19};
        System.out.println(findLongestConsecutiveSequences(arr));
    }
    static int findLongestConsecutiveSequences(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        int ans = 0;
        for(int i=0; i< arr.length; i++)
        {
            map.put(arr[i],1);
        }
        for(int i=0; i<arr.length; i++)
        {
            // find if element is starting element
            if(map.get(arr[i]-1) != null)
                continue;
            if(visited.get(arr[i]) !=null)
                continue;
            // found starting element
            visited.put(arr[i],1);
            int length = 0;
            int elem = arr[i];
            while(map.get(elem) != null)
            {
                length++;
                elem++;
            }
            ans = Math.max(ans,length);
        }
        return ans;
    }
}
