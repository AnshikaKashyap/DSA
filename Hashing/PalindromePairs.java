package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*You are given a 0-indexed array of unique strings words.

A palindrome pair is a pair of integers (i, j) such that:

0 <= i, j < words.length,
i != j, and
words[i] + words[j] (the concatenation of the two strings) is a
palindrome

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["a","a"]
.*/
public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> list = palindromePairs(words);
        System.out.println(Arrays.toString((list.toArray())));

    }
    public static List<List<Integer>> palindromePairs(String[] words) {
        // reverse the String and save in Hashmap along with their indices
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i< words.length; i++)
        {
            String str = new StringBuilder(words[i]).reverse().toString();
            map.put(str,i);
        }
        HashMap<List<List<Integer>>,Boolean> m = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i< words.length; i++)
        {
            if(map.get("") != null && map.get("") != i && isPalindrome(words[i],0,words[i].length()-1) && m.get(Arrays.asList(Arrays.asList(i,map.get("")))) == null)
            {
                // add an entry into tracking hash map m
                m.put(Arrays.asList(Arrays.asList(i,map.get(""))),true);
                m.put(Arrays.asList(Arrays.asList(map.get(""),i)),true);
                ans.add(Arrays.asList(i,map.get("")));
                ans.add(Arrays.asList(map.get(""),i));
            }
            String prefix;
            for(int j=0; j< words[i].length(); j++)
            {

                prefix = words[i].substring(0,j+1);

                if(map.get(prefix) != null && map.get(prefix) != i && isPalindrome(words[i],j+1,words[i].length()-1) && m.get(Arrays.asList(Arrays.asList(i,map.get(prefix)))) == null)
                {
                    // add an entry into tracking hash map m
                    m.put(Arrays.asList(Arrays.asList(i,map.get(prefix))),true);
                    ans.add(Arrays.asList(i,map.get(prefix)));
                }

            }

            String suffix;
            for(int j=0; j< words[i].length(); j++)
            {
                suffix = words[i].substring(words[i].length()-1-j,words[i].length());
                if(map.get(suffix) != null && map.get(suffix) != i && isPalindrome(words[i],0,words[i].length()-2-j) && m.get(Arrays.asList(Arrays.asList(map.get(suffix),i))) == null)
                {
                    // add an entry into tracking hash map m
                    m.put(Arrays.asList(Arrays.asList(map.get(suffix),i)),true);
                    ans.add(Arrays.asList(map.get(suffix),i));
                }

            }

        }

            return ans;


    }

    private static boolean isPalindrome(String word, int start, int end) {
        int i=start;
        int j = end;
        boolean ans = true;
        while(i<j)
        {
            if(word.charAt(i) == word.charAt(j))
            {
                i++;
                j--;
            }
            else {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
