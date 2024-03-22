package TwoPointers;

/*We have been given two strings S and T. Return the minimum length substring of S that contains all the characters of T otherwise return an empty string if no such substring exists.

Input: S = ADOBECODEBANC
          T = ABC

Output: BANC*/

public class SmallestSubstring {
    public static void main(String []args)
    {
        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";

        getSubstring(str1, str2);
    }

    static void getSubstring(String str1, String str2)
    {

        //create freq array for both the strings
        int[] freq1 = new int[256];
        // update freq array for str2 and get no of unique char in string 2
        int[] freq2 =new int[256];
        int uniqueChar = 0;
        for(int i=0; i< str2.length(); i++)
        {
            if (freq2[str2.charAt(i)] == 0)
            {
                uniqueChar++;
            }
            freq2[str2.charAt(i)]++;

        }

        // get first eligible string starting with first index
        int i = 0; int j = 0;
        int count =0;
        for(int k=0; k< str1.length(); k++)
        {
            freq1[str1.charAt(k)]++;
            if (freq1[str1.charAt(k)] == freq2[str1.charAt(k)])
            {
                count ++;

            }
            if(count == uniqueChar)
            {
                j = k ;
                break;
            }

        }
        System.out.println("i and j: "+i+" "+j);
        int ans_start = i;
        int ans_end = j;
        int length = (j-i+1);
        while(j < str1.length())
        {
            if(freq1[str1.charAt(i)] > freq2[str1.charAt(i)])
            {
                freq1[str1.charAt(i)] --;
                i++;
                if(length > (j-i+1))
                {
                    length = (j-1+1);
                    ans_start = i;
                    ans_end = j;
                }

            }
            else {
                j++;
                if(j < str1.length()) {
                    freq1[str1.charAt(j)]++;
                }
            }
        }

        System.out.println("ans_start and ans_start: "+ans_start+" "+ans_end);
        System.out.println("ans is: "+str1.substring(ans_start,ans_end+1));

    }
}
