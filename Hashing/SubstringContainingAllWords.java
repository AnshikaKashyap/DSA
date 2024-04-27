package Hashing;
/*Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringContainingAllWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        List<Integer> ans = findSubstrings(s, words);
        System.out.println("ans length is: " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }

    static List<Integer> findSubstrings(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || (s.length() < words.length * words[0].length())) {
            return ans;
        }

        // update frequency map for elements in words array
        HashMap<String, Integer> words_freq = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (words_freq.get(words[i]) != null)
                words_freq.put(words[i], words_freq.get(words[i]) + 1);
            else
                words_freq.put(words[i], 1);
        }
//        System.out.println("word freq");
//        for (Map.Entry<String, Integer> entry : words_freq.entrySet()) {
//            System.out.println(entry.getKey() + "   " + entry.getValue());
//        }
//        System.out.println("word freq complete");
        // create a temp map to store freq of substrings in given String s
        HashMap<String, Integer> temp_freq = new HashMap<>();
        int words_length = words[0].length();
        int l = words.length;
        for (int i = 0; i < s.length() - words_length * l; i++) {
//            System.out.println("i is: "+i);
            for (int j = i; j < i + words_length * l; j += words_length) {
                String str = s.substring(j, j + words_length);
                if (temp_freq.get(str) != null)
                    temp_freq.put(str, temp_freq.get(str) + 1);
                else
                    temp_freq.put(str, 1);
            }
//                System.out.println("temp frequency");
//                for (Map.Entry<String, Integer> entry : temp_freq.entrySet()) {
//                    System.out.println(entry.getKey() + "   " + entry.getValue());
//                }
//                System.out.println("temp freq complete");
                // compare temp_freq and words_freq map
            int flag = 1;
                for (int k = 0; k < words.length; k++) {
                    if (temp_freq.get(words[k]) == null || temp_freq.get(words[k]) != words_freq.get(words[k])) {
                        flag = 0;
                        break;
                    }
                }
                    if (flag == 1) {
                        ans.add(i);
                        System.out.println("added i to ans: "+i);

                    }
            temp_freq.clear();

                }

        return ans;

            }

        }







