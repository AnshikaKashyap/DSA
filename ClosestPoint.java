/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).*/
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPoint {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,new sortByDis());
        int[][] response = new int[points.length][points.length];
        for(int i=0; i<k;i++)
        {
            System.out.println(points[i][0]+" "+points[i][1]);
            response[i] = points[i];
        }

        return response;

    }
    public class sortByDis implements Comparator<int[] > {
        @Override
        public int compare(int[] o1, int[] o2) {
            int d1 = (o1[0] * o1[0]+o1[1] * o1[1]);
            int d2 = (o2[0] * o2[0]+o2[1] * o2[1]);
            return d1-d2;
        }
    }
    public static void main (String[] args)
    {
        int[][]points = {{1,3},{-2,2},{5,5}};
        int k = 3;
        ClosestPoint c= new ClosestPoint();
        c.kClosest(points,k);



    }
}
