/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.*;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.color(PenColor.BLACK);
        for ( int i = 0; i < 4; i++){
            turtle.forward(sideLength);
            turtle.turn(90);
        }
        // throw new RuntimeException("implement me!");
    }

    /**
     * Determine inside angles of a regular polygon.
     *
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */


    public static double calculateRegularPolygonAngle(int sides) {
        if (sides<=2) throw new RuntimeException("Error: sides must be > 2.");
        return 180.0 - 360.0 / sides;
        // throw new RuntimeException("implement me!");
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     *
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think ablft the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        if (angle <= 0 || angle >= 180) throw new RuntimeException("Error: angle not belong to (0, 180)");
        double ans = 360.0/(180.0-angle);
        int ans_int = (int)ans;
        if(ans-ans_int>=0.5) return ans_int + 1;
        else return ans_int;

        // throw new RuntimeException("implement me!");
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        // Attention: need to turn the complementary angle of inner corners.
        double angle = 180.0 - calculateRegularPolygonAngle(sides);
        turtle.color(PenColor.BLACK);
        for(int i = 0; i < sides; i++)
        {
            turtle.forward(sideLength);
            turtle.turn(angle);
        }
        // throw new RuntimeException("implement me!");
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentBearing current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
                                                 int targetX, int targetY) {
        double targetBearing = Math.atan2(targetX-currentX, targetY-currentY) * 180.0 / Math.PI;
        double bearingToPoint = targetBearing - currentBearing;
        if(bearingToPoint < 0) bearingToPoint += 360.0;
        return bearingToPoint;
        // throw new RuntimeException("implement me!");
    }

    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) {
        if(xCoords.size() <= 1 || xCoords.size() != yCoords.size()){
            throw new Error("Error: Coords size <= 2 or xCoords size is not equal to yCoords size.");
        }

        List<Double> answer = new ArrayList<>();
        int n = xCoords.size();
        int cur_x = xCoords.get(0), cur_y = yCoords.get(0), tar_x, tar_y;
        double cur_bearing = 0.0, cur_toadd;
        for(int i = 1; i < n; i++){
            tar_x = xCoords.get(i);
            tar_y = yCoords.get(i);
            cur_toadd = calculateBearingToPoint(cur_bearing,cur_x,cur_y,tar_x,tar_y);
            answer.add(cur_toadd);
            cur_bearing += cur_toadd;
            if(cur_bearing>360.0) cur_bearing -= 360.0;
            cur_x = tar_x;
            cur_y = tar_y;
        }
        return answer;
        // throw new RuntimeException("implement me!");
    }
    
    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points 
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and 
     * there are other algorithms too.
     * 
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    public static Set<Point> convexHull(Set<Point> points) {

        // Now try Gift-wrapping algorithm (or Jarvis' March).c
        int n = points.size();
        if(n<=3) return points;

        Set<Point> pointSet = new HashSet<>();
        Point[] pointList = points.toArray(points.toArray(new Point[0]));
        int low = 0;

        for(int i = 0; i < n; i++){
            if(pointList[i].y()< pointList[low].y()||(pointList[i].y()== pointList[low].y()&&pointList[i].x()< pointList[low].x()) )
                low = i;
        }

        int first = low, last;
        do{
            pointSet.add(pointList[first]);
            last = (first + 1) % n;
            for(int i = 0; i < n; i++){
                Point a = pointList[first], b = pointList[last], c = pointList[i];
                double CCW_mark = (c.x()-a.x())*(b.y()-a.y())-(b.x()-a.x())*(c.y()-a.y());
                boolean isCCW = CCW_mark >= 0;
                if(isCCW && (CCW_mark - 0.0)*(CCW_mark-0.0) < 0.001){
                    double dis_i2 = (c.y()-a.y())*(c.y()-a.y())+(c.x()-a.x())*(c.x()-a.x());
                    double dis_last2 = (b.y()-a.y())*(b.y()-a.y())+(b.x()-a.x())*(b.x()-a.x());
                    if(dis_i2 > dis_last2) last = i;
                }
                else if(isCCW && (CCW_mark - 0.0)*(CCW_mark-0.0) > 0.001) last = i;
            }
            first = last;
        }while(first!=low);
        // System.out.println(pointSet);
        return pointSet;
        // throw new RuntimeException("implement me!");
    }

    /**
     * A temporary method, used in drawPersonalArt to get a Fibonacci spiral.
     * Get the n-th number in Fibonacci series.
     *
     * @param n The index of number to get in array "fib".
     * @return The number of index 'n' in "fib" array.
     */
    public static int fib(int n){
        if(n<0) throw new IndexOutOfBoundsException("Index input must be >= 0");
        if(n<=1) return 1;
        else return fib(n-1) + fib(n-2);
    }

    /**
     * A temporary method, used in drawPersonalArt to get a Fibonacci spiral.
     * Given the number of sides and an int "dividedBy" to draw the 'one dividedBys' of a regular polygon.
     * This method is used to simulate method 'circle' in library 'turtle' by dividing a Polygon.
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     *
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param dividedBy to paint the "1/dividedBy" of Polygon, must be > 0
     * @param sideLength length of each side
     */
    public static void drawDividedPolygon(Turtle turtle, int sides, int dividedBy, int sideLength) {
        if(dividedBy <= 0) throw new Error("Error: int 'dividedBy' <= 0");
        // Attention: need to turn the complementary angle of inner corners.
        double angle = 180.0 - calculateRegularPolygonAngle(sides);
        for(int i = 0; i < sides / dividedBy; i++)
        {
            turtle.forward(sideLength);
            turtle.turn(angle);
        }
        // throw new RuntimeException("implement me!");
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {

        // Now try a Fibonacci Spiral.
        // Initialize parameter of our Fibonacci Spiral.
        double init_angle = 90.0;
        int accuracyOfCircle = 60;
        int width = 10;
        int n = 10;
        int x;

        // Paint
        turtle.turn(init_angle);
        for (int i = 1; i <= n; i++)
        {
            x = fib(i);
            x *= width;

            // Dye the line.
            if(i % 3 == 1) turtle.color(PenColor.MAGENTA);
            else if (i % 3 == 2) turtle.color(PenColor.RED);
            else turtle.color(PenColor.PINK);

            for(int j = 0 ; j < 4; j++)
            {
                turtle.forward(x);
                turtle.turn(90);
            }
            int sideLength = (int) (2 * Math.PI * x / accuracyOfCircle);
            drawDividedPolygon(turtle,accuracyOfCircle,4, sideLength);
        }
        // throw new RuntimeException("implement me!");
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        // drawSquare(turtle, 100);
        // drawRegularPolygon(turtle, 6, 100);
        drawPersonalArt(turtle);
        // draw the window
        turtle.draw();
    }
}