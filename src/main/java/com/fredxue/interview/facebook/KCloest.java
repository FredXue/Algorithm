package com.fredxue.interview.facebook;

import java.util.PriorityQueue;

/**
 * Created by fredxue on 29/11/2017.
 */
public class KCloest {
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> {
            int res = (int)(distance(b, origin) - distance(a, origin));
            if(res == 0){
                return b.x - a.x == 0 ? b.y - a.y : b.x - a.x;
            } else return res;
        });
        for(Point p : points) {
            pq.add(p);
            if(pq.size() > k) pq.poll();
        }
        Point[] res = new Point[points.length < k? points.length : k];
        for(int i = res.length -1; i >= 0; i--){
            res[i] = pq.poll();
        }
        return res;
    }

    public static double distance(Point a, Point b) {
        return Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2);
    }
}
