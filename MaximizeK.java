/*We have been given an unsorted array Arr[N] containing only positive elements and an integer ‘x’ such that x>=0.
 We have to find the maximum possible ‘k’ such that none of the subarrays of size ‘k’ has a sum>x. */
public class MaximizeK {
   static int[] arr = {1,2,3};
    static int x = 7;
    static int mid;
    public static void main (String[] args){

        System.out.println(findMaxK(arr, x));
    }

    static boolean isPossible(int m)
    {
        System.out.println(" m is: "+m);
        boolean response;
        if(m == arr.length+1)
        {
            response = false;
           return response;
        }

        int sum = 0;
        for(int i=0; i<m; i++){
            sum = sum+ arr[i];
        }
        if(sum > x)
        {
            response = false;
            return response;
        }
        int start_index = 0;
        int end_index = m-1;

        while (end_index < arr.length -1) {
                sum = sum - arr[start_index];
                start_index++;
                end_index++;

                sum = sum + arr[end_index];
            System.out.println("sum is : "+start_index+" "+end_index+ " " + sum);
                if (sum > x ) {
                    response = false;
                    return response;
                }

            }

        return true;
    }

    static int findMaxK(int[] arr, int x)
    {
        int l=0; int h = arr.length;

        while(l<=h)
        {
          mid = (l+h)/2;

            if(!isPossible(mid))
            {
                h= mid-1;
            }

            else if(isPossible(mid))
            {
                if(!isPossible(mid+1))
                {
                    System.out.println("returned value is: "+mid);
                    break;


                }
                else l = mid+1;
            }
        }

        return mid;
        
    }
}
