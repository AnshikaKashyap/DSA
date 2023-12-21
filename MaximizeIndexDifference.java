/*Chef has gone shopping with his 5-year old son. They have bought N items so far. The items are numbered from 1 to N, and the item i weighs Wi grams.

Chef’s son insists on helping his father in carrying the items. He wants his dad to give him a few items. Chef does not want to burden his son. But he won’t stop bothering him unless he is given a few items to carry. So Chef decides to give him some items. Obviously, Chef wants to give the kid less weight to carry.

However, his son is a smart kid. To avoid being given the bare minimum weight to carry, he suggests that the items are split into two groups, and one group contains exactly K items. Then Chef will carry the heavier group, and his son will carry the other group.

Help the Chef in deciding which items should the son take. Your task will be simple. Tell the Chef the maximum possible difference between the weight carried by him and the weight carried by the kid.

Input Format

    The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow.
    The first line of each test contains two space-separated integers N and K.
    The next line contains N space-separated integers W1, W2, ..., WN.

Output Format

    For each test case, output the maximum possible difference between the weights carried by both in grams.*/
import java.util.*;

public class MaximizeIndexDifference {
    public static void main (String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        maxIndexDiff(arr);
    }
     static void maxIndexDiff(int[] arr)
    {
        // create a list
        List<Elements> elements = new ArrayList<>();
        for(int i=0; i< arr.length; i++)
        {
            elements.add(new Elements(arr[i],i));
        }

     // sort elements based on value
        Collections.sort(elements,new ValueCompare());
        // create suffixmax on indices
        int[] suffix_max = new int[arr.length];
        int suffix = Integer.MIN_VALUE;
        for (int i = arr.length-1; i>=0; i--)
        {
            suffix_max[i] = Math.max(elements.get(i).getIndex(),suffix);
            suffix = suffix_max[i];
            
        }
        // print suffix max
        // calculate max j-1
        int ans = Integer.MIN_VALUE;
        for(int i=0; i< elements.size(); i++)
        {
            if((i+1 != elements.size())) {
                ans = Math.max(ans, (suffix_max[i + 1]-elements.get(i).getIndex()));
            }

        }
        System.out.println(+ans);
    }

    public static class Elements{
        int value;
        int index;

        public Elements(int value,int index)
        {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }

    static class ValueCompare implements Comparator<Elements>{
        public int compare(Elements el1, Elements el2)
        {
            if (el1.getValue() < el2.getValue())
                return -1;
            if (el1.getValue() > el2.getValue())
                return 1;
            if (el1.getValue() == el2.getValue() && el1.getIndex() < el2.getIndex())
                return -1;
            if (el1.getValue() == el2.getValue() && el1.getIndex() > el2.getIndex())
                return 1;
            else
                return 0;

        }
    }



}


