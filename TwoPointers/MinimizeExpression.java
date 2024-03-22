package TwoPointers;
/*Sorted arrays A[m], B[n], C[p]. We have to minimize the value of the expression: max(a, b, c) - min(a, b, c) such that a∈A, b∈B, c∈C.

Input: A[5] = {1, 4, 5, 8, 10}

          B[3] = {6, 9, 15}

           C[4] = {2, 3, 6, 6}

Output: 1  (5, 6, 6)*/
public class MinimizeExpression {
    public static void main(String []args)
    {
        int[] arr1 = {1, 4, 5, 8, 10};
        int[] arr2 = {6, 9, 15};
        int[] arr3 = {2, 3, 6, 6};
        getMinValue(arr1,arr2,arr3);
    }
    static void getMinValue(int[] arr1, int[]arr2, int[] arr3)
    {
        int i=0; int j = 0; int k=0;
        int ans = Integer.MAX_VALUE;
        while(i<arr1.length && j< arr2.length && k<arr3.length)
        {
            int val = Math.max(arr1[i],Math.max(arr2[j],arr3[k])) - Math.min(arr1[i],Math.min(arr2[j],arr3[k]));
            ans = Math.min(ans,val);
            int min = Math.min(arr1[i],Math.min(arr2[j],arr3[k]));
            if(arr1[i] == min) i++;
            else if (arr2[j] == min) j++;
            else k++;

        }
        System.out.println("ans is: "+ans);
    }
}
