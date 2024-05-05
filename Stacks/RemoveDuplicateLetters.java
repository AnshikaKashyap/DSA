package Stacks;

import java.util.Stack;
/*Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
the smallest in lexicographical order
 among all possible results.
 Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"*/
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println("ans is: "+removeDuplicateLetters(s));

    }
    public static String removeDuplicateLetters(String s) {
        Stack stack = new Stack<>();
        // initialize frequency array
        int[] freq = new int[26];
        for(int i=0; i< s.length(); i++)
        {
            freq[s.charAt(i)-'a'] ++;
        }
        // declare isPresent array

        int[] present = new int[256];
        stack.push(s.charAt(0));
        freq[s.charAt(0)-'a'] --;
        present[s.charAt(0)] = 1;

        for(int i=1; i< s.length(); i++)
        {
            freq[s.charAt(i)-'a'] --;
            if(present[s.charAt(i)] == 1)
                continue;
            while(!stack.isEmpty() && ((char)stack.peek() > s.charAt(i)) && freq[(char)stack.peek()-'a'] > 0)
            {
                present[(char)stack.peek()] = 0;
                stack.pop();
            }
            stack.push(s.charAt(i));
            present[s.charAt(i)] = 1;


        }

    return stack.toString();

    }
}
