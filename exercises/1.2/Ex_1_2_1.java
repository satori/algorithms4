// Copyright (C) 2018  Maxim Bublis
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_2_1
{
    private static final double AREA_X_MIN = 0.0;
    private static final double AREA_X_MAX = 1000000.0;
    private static final double AREA_Y_MIN = 0.0;
    private static final double AREA_Y_MAX = 1000000.0;
    private static final double MAX_STRIP_CHECKS = 7;

    private static double bruteForce(Point2D[] points)
    {
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++)
                min = Math.min(min, points[i].distanceTo(points[j]));

        return min;
    }

    private static double closestDistance(Point2D[] px, Point2D[] py)
    {
        if (px.length <= 3)
            return bruteForce(px);

        int mid = px.length / 2;
        Point2D midPoint = px[mid];

        Point2D[] px_left = new Point2D[px.length];
        Point2D[] px_right = new Point2D[px.length];
        Point2D[] py_left = new Point2D[py.length];
        Point2D[] py_right = new Point2D[py.length];
        int px_idx_left = 0, px_idx_right = 0;
        int py_idx_left = 0, py_idx_right = 0;

        for (int i = 0; i < px.length; i++)
        {
            if (px[i].x() <= midPoint.x())
                px_left[px_idx_left++] = px[i];
            else
                px_right[px_idx_right++] = px[i];
        }

        for (int i = 0; i < py.length; i++)
        {
            if (py[i].x() <= midPoint.x())
                py_left[py_idx_left++] = py[i];
            else
                py_right[py_idx_right++] = py[i];
        }

        double dl = closestDistance(Arrays.copyOfRange(px_left, 0, px_idx_left),
                                    Arrays.copyOfRange(py_left, 0, py_idx_left));
        double dr = closestDistance(Arrays.copyOfRange(px_right, 0, px_idx_right),
                                    Arrays.copyOfRange(py_right, 0, py_idx_right));
        double d = Math.min(dl, dr);

        Point2D[] strip = new Point2D[py.length];
        int idx_strip = 0;
        for (int i = 0; i < py.length; i++)
            if (Math.abs(py[i].x() - midPoint.x()) < d)
                strip[idx_strip++] = py[i];

        return Math.min(d, closestStripDistance(Arrays.copyOfRange(strip, 0, idx_strip), d));
    }

    private static double closestStripDistance(Point2D[] points, double d)
    {
        double min = d;

        for (int i = 0; i < points.length - 1; i++)
            for (int j = i + 1; j < Math.min(points.length, i + MAX_STRIP_CHECKS); j++)
                min = Math.min(min, points[i].distanceTo(points[j]));
        return min;
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);

        Point2D[] px = new Point2D[N];
        Point2D[] py = new Point2D[N];

        for (int i = 0; i < N; i++)
        {
            Point2D point = new Point2D(StdRandom.uniform(AREA_X_MIN, AREA_X_MAX),
                                        StdRandom.uniform(AREA_Y_MIN, AREA_Y_MAX));
            px[i] = point;
            py[i] = point;
        }

        Arrays.sort(px, Point2D.X_ORDER);
        Arrays.sort(py, Point2D.Y_ORDER);

        StdOut.printf("d = %.6f\n", closestDistance(px, py));
    }
}
