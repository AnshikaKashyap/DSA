package Hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
* Input: points = [[1,1],[2,2],[3,3]]
Output: 3*/
public class MaxPointsOnSameLine {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
    }
    public static int maxPoints(int[][] points) {
        if(points.length == 0)
            return 0;
        int ans = 1;
        HashMap<Slope,Integer> map = new HashMap<Slope, Integer>();

        for(int i=0; i< points.length; i++)
        {
            int olp =0;
            int maxm = 0;
            for(int j=i+1; j< points.length; j++)
            {
                // verify overlapping elements and increment the count
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1])
                    olp++;
                else {
                    int x_diff = (points[j][0]-points[i][0]);
                    int y_diff = (points[j][1]-points[i][1]);
                    int g = gcd(Math.abs(x_diff),Math.abs(y_diff));
                    // standardise the slope i.e. change 4/6 to 2/3
                    int f = x_diff/g;
                    int s = y_diff/g;
                    standardise(f,s);
                    if(map.get(new Slope(f,s)) != null)
                    {
                        int val = map.get(new Slope(f,s));
                        map.put(new Slope(f,s),val+1);
                    }
                    else map.put(new Slope(f,s),1);
                    System.out.println("slope is: "+map.get(new Slope(f,s)));
                    maxm = Math.max(maxm,map.get(new Slope(f,s)));


                }
            }
            ans = Math.max(ans, maxm+1+olp);
            map.clear();
        }
return ans;
    }

    static int gcd(int val1, int val2)
    {
        if(val1 == 0) return val2;
        if(val2 == 0) return val1;
        int m1 =  Math.max(val1,val2);
        int m2 = Math.min(val1,val2);
        if(m1%m2 == 0) return m2;
        return gcd(m1%m2,m2);
    }

    static void standardise(int x, int y)
    {
        if(x==0) y = 1;
        else if(y==0) x=1;
        else if ((x<0 && y<0) || (y<0))
        {
            x *= -1;
            y *= -1;
        }
    }
}

class Slope{
    int x_cord;
    int y_cord;

    public Slope(int x_cord, int y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slope)) return false;
        Slope slope = (Slope) o;
        return x_cord == slope.x_cord && y_cord == slope.y_cord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x_cord, y_cord);
    }
}
