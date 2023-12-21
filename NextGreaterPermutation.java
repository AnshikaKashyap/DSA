/*A Permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, print the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Input Format

    The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow.
    The first line of each test contains integer N, denoting the size of a array nums.
    The next line contains N space-separated integers, denoting elements of array nums.

Output Format

    For each test case, print the next permutation of array nums.*/

import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterPermutation {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i=0; i< test_case; i++)
        {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for(int j=0; j<num;j++)
            {
                arr[j] = sc.nextInt();
            }
            nextGreaterPermutation(arr,num);
        }



    }


    static void nextGreaterPermutation(int[] arr,int num)
    {
        // find first index where descending streak breaks   123   321
        int index = num-1;
        while(index > 0 && arr[index] <= arr[index-1])
        {
            index --;
        }
        if((index -1) >= 0) {
            for (int j = num - 1; j >= index; j--) {
                if (arr[j] > arr[index-1]) {
                    // swap(arr[i],arr[index])
                    int temp = arr[j];
                    arr[j] = arr[index-1];
                    arr[index-1] = temp;
                }
                break;
            }
        }

        // sort the remaining suffix in ascending order
        {
            int x = index;
            int y = num - 1;
            while (x < y) {
                // swap(x, y, arr);
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
                x++;
                y--;
            }
        }

    }

    static void printPermutation(int[] arr, int n){
        int x = n-1;
        while(x > 0 && arr[x] <= arr[x-1]){
            x--;
        }

        if(x-1 >= 0){
            for(int y=n-1; y>=x; y--){
                if(arr[y] > arr[x-1]){
                    int temp = arr[y];
                    arr[y] = arr[x-1];
                    arr[x-1] = temp;
                    break;
                }
            }
        }
        int i=x, j=n-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
