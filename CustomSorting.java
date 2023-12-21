/*You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.*/
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CustomSorting {
    public static void main (String[] args) {
        System.out.print(customSortString("cba","abcd"));
    }

        public static String customSortString(String order, String s) {
        int[] rank = new int[26];
        for(int i=0; i<order.length(); i++)
        {
            rank[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i< order.length(); i++)
        {
            // rank[0] should give rank[a], rank[1] should give rank[b]
            rank[order.charAt(i) - 'a'] = i;
        }

            Character[] tempArray = new Character[s.length()];
            for (int i = 0; i < s.length(); i++) {
                tempArray[i] = s.charAt(i);
            }

            Arrays.sort(tempArray,new Comparator<Character>(){
            public int compare(Character c1,Character c2){
                return rank[c1 - 'a'] - rank[c2 - 'a'];
            }});


//            String ans = tempArray.toString();
            StringBuilder builder = new StringBuilder();
            for(Character ch: tempArray)
            {
                builder.append(ch);
            }

            return builder.toString();

    }
}
