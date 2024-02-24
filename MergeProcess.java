public class MergeProcess {

    public static void main (String []args)
    {
        int[] arr1 = {2,5,9,11};
        int[] arr2 = {7,15};
        mergeArrays(arr1,arr2);
    }

    static void mergeArrays(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;
        int[] ans = new int [m+n];
        int i=0; int j=0; int c=0;
        for(;i<m && j<n;)
        {
            if(arr1[i] < arr2[j])
            {
                ans[c++] = arr1[i++];
            }

            else  ans[c++] = arr2[j++];
        }

        while(i<m)
        {
            ans[c++]= arr1[i++];
        }
        while(j<n)
        {
            ans[c++]= arr2[j++];
        }

        for(int k=0; k< ans.length; k++)
        {
            System.out.print(ans[k]+" ");
        }
    }
}
