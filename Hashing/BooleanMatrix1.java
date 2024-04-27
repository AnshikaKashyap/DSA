package Hashing;
/*We have been given a boolean matrix mat[M][N]. Transform it such that if mat[i][j]=1:

Make all cells in the ith row as 1
Make all cells in the jth column as 1 */
public class BooleanMatrix1 {
    public static void main(String[] args) {
        int[][] arr = {{0,1,0,0,0},{0,0,0,0,0},{0,0,0,0,1},{0,0,0,0,0}};
        convertmatrix(arr);

    }

    static void convertmatrix(int[][] arr)
    {
        // create row amd col array after scanning the matrix
        int row_size = arr.length;
        int col_size = arr[0].length;
        int[] row_array = new int[row_size];
        int[] col_array = new int[col_size];;

        for(int i=0; i<row_size; i++)
        {
            for(int j=0; j< col_size; j++)
            {
                if(arr[i][j] == 1)
                {
                    row_array[i] = 1;
                    col_array[j] = 1;

                }
            }
        }

        // iterate over the array and modify elements
        for(int i=0; i<row_size; i++)
        {
            for(int j=0; j< col_size; j++)
            {
                if(row_array[i]== 1 || col_array[j] == 1)
                {
                    arr[i][j] = 1;
                }
            }
        }
        System.out.println();
        // print the array
        for(int i=0; i<row_size; i++)
        {
            for(int j=0; j< col_size; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();

        }

    }
}
