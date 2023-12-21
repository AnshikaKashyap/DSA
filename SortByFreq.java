/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;
/*Given an integer array nums, sort the array according to frequency of elements.
That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.*/
public class SortByFreq
{
    public static void main (String[] args)
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();
            int[] arr = new int[num];
            int[] freqArray = new int[61];
            List<Pairs> pairsList = new ArrayList<Pairs>();
            for(int j=0; j<num; j++)
            {
                arr[j] = sc.nextInt();
            }

        for(int j=0; j<num; j++)
        {
            freqArray[arr[j]]++ ;

        }

            for(int j=0; j<num; j++)
            {
                pairsList.add(new Pairs(arr[j],freqArray[arr[j]]));

            }

//        Collections.sort(pairsList,new Comparator<Pairs>(){
//            public int compare(Pairs s1,Pairs s2){
//                if(s1.freq != s2.freq )
//                    return s1.freq.compareTo(s2.freq);
//                else return s1.value - s2.value;
//            }});

        for(int j=0; j<num; j++)
        {
            System.out.println(pairsList.get(j).value+" "+pairsList.get(j).freq);

        }
        Collections.sort(pairsList);

            for(int j=0; j<num; j++)
            {
                System.out.print(pairsList.get(j).value+" ");

            }
            System.out.println();


    }




}

class Pairs implements Comparable<Pairs>{
     int value;
     int freq;

    Pairs(int value, int freq)
    {
        this.value = value;
        this.freq = freq;
    }


    @Override
    public int compareTo(Pairs p) {
        if(this.freq != p.freq )
            return (p.freq-this.freq) ;
        else return (this.value-p.value) ;
    }
}






