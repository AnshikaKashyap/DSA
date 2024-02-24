package Sorting;

public class MoveZeroes {
    public static void main (String[] args)
    {
        int []arr = {0,1,0,3,12};
        moveZeroes_withrelativeorder(arr);
        for(int i=0; i< arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

    static void moveZeroes_withoutrelativeorder(int[] arr, int i, int j)
    {
        int l = i;
        int r = j;
        while (l<=r)
        {
            while(arr[l] != 0) l++;
            while(arr[r] == 0) r--;
            if(l<r) {
                // swap arr[l] and arr[r]
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
    }

    static void moveZeroes_withrelativeorder(int[] arr)
    {
        int cnt = 0;
        for(int i=0; i< arr.length; i++)
        {
            if(arr[i] != 0 && cnt != i) {
                // swap arr[i] and arr[cnt]
                int temp = arr[i];
                arr[i] = arr[cnt];
                arr[cnt] = temp;
                cnt ++;
            }
            else if(arr[i] != 0 && cnt == i)
            {
                cnt ++;
            }

        }
    }
}
