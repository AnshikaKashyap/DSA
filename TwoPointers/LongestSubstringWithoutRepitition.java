package TwoPointers;

public class LongestSubstringWithoutRepitition {
    /*
    * brute force approach
    * complexity n^2
    * ans =0;
    * for i 0 to n-1
    * reinitialize freq arr
    * for j= i to n-1
    * if(freq[s[j]] > 0
    * break
    * else {
    * freq[s[j]]++
    * ans = max(ans, j-i+1)*/
    public static void main(String []args)
    {
        String arr = "abcdefcgkltmpq";

        getSubstringLength(arr);
    }
    static void getSubstringLength(String arr)
    {
        int ans =0;
        // initialize frequency array
        int[] freq = new int[256];
        int i=0;
        int j=0;
        freq[arr.charAt(0)]++;
        ans++;
        while(j< arr.length()-1)
        {
          if(freq[arr.charAt(j+1)] == 0)
          {
              freq[arr.charAt(j+1)]++;
              j++;
          }
          else {
              freq[arr.charAt(i)]--;
              i++;
          }
          ans = Math.max(ans, j-i+1);
        }
        System.out.println("ans is : "+ans);
    }
}
