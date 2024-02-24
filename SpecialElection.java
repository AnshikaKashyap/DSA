public class SpecialElection {
    public static void main (String[] args) throws java.lang.Exception
    {
//        int[] arr = {4,3,2,1};
        int[] arr = {1,2,2,3,1};// output 1 2 3 2 -- 2 3 2 3 1
        specialElecResponse(arr);
        /*4  0 1 1 0       -1 0 1 0  -1 -1 0 1
        * 3  1 0 1 1
        * 2  0 1 0 1
        * 1  0 0 1 0 */
        
    }

    static int[] specialElecResponse(int[] arr)
    {
        // create prefix sum
         int[] prfix_sum = new int[arr.length];
        prfix_sum[0] = arr[0];
         for(int i=1; i< arr.length; i++)
         {
             prfix_sum[i] = prfix_sum[i-1]+arr[i];
         }

         // create ans array
        int[] ans = new int[arr.length];
         int[] suffix_sum_arr = new int[arr.length];

         // for each array elements update ans array to all the elments which given candidate can vote


        // find range of candidate in right
        for(int i=0; i< arr.length; i++) {

            int right_low = i + 1;
            int right_high = arr.length - 1;
            while (right_low <= right_high) {
                int mid = (right_low + right_high) / 2;
                int sandwich_sum = prfix_sum[mid - 1] - prfix_sum[i];
                if (sandwich_sum <= arr[i]) {
                    // check if mid is ans or not
                    if ((mid == arr.length - 1) || (sandwich_sum + arr[mid] > arr[i]))
                    // mid is ans
                    {
                        ans[mid]++;
                        ans[i]--;
                        break;
                    } else {
                        right_low = mid + 1;
                    }
                } else {
                    right_high = mid - 1;
                }
            }
        }

        for(int j=0; j< arr.length; j++)
        {
            System.out.print(ans[j]+" ");
        }
        System.out.println();
        // find range of candidate in left
        for(int i=0; i< arr.length; i++)
        {

                int left_low = 0; //0
                int left_high = i-1; //0 i=1
                while (left_low <= left_high)
                {
                    int mid = (left_low +left_high)/2; //0,i=1,arr[i] = 2
                    int sandwich_sum = prfix_sum[i-1]-prfix_sum[mid] ;  //0
                    if (sandwich_sum <= arr[i])
                    {
                        // check if mid is ans or not
                          if (mid ==0 &&((i-1) !=0) )
                    {
                        ans[i-1] ++;
                        break;
                    }
                        else if((i-1 !=0) && sandwich_sum+arr[mid] >arr[i])
                        // mid is ans
                        {
                            ans[i-1] ++;
                            ans[mid-1] --;

                            break;
                        }

                        else if (mid ==0 &&((i-1) ==0) )
                          {
                              ans[mid] ++;
                              break;
                          }


                        else {
                            left_high = mid-1;
                        }
                    }
                    else
                        left_low = mid +1; //3

                }

            }

        for(int j=0; j< arr.length; j++)
        {
            System.out.print(ans[j]+" ");
        }
        System.out.println();
        suffix_sum_arr[arr.length-1] = ans[arr.length-1];
        for(int j = arr.length-2; j>=0; j--)
        {
            suffix_sum_arr[j] = ans[j]+suffix_sum_arr[j+1];
        }
        for(int j=0; j< suffix_sum_arr.length; j++)
        {
            System.out.print(suffix_sum_arr[j]+" ");
        }
        return suffix_sum_arr;

    }
}
