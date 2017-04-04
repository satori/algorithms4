// Copyright (C) 2017  Maxim Bublis
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

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_32
{
    private static int getInterval(int N, double l, double r, double v)
    {
        return (int) (N * (v - l) / (r - l));
    }

    public static void main(String[] args)
    {
        if (args.length != 3)
        {
            StdOut.println("exactly 3 arguments required");
            return;
        }

        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]),
               r = Double.parseDouble(args[2]);
        int[] hist = new int[N];
        double[] values = StdIn.readAllDoubles();

        for (int i = 0; i < values.length; i++)
        {
            int k = getInterval(N, l, r, values[i]);
            hist[k]++;
        }

        int max = StdStats.max(hist);
        double xPadding = (r - l) / 10.0;
        double yPadding = max / 10.0;
        StdDraw.setXscale(l - xPadding, r + xPadding);
        StdDraw.setYscale(0, max + yPadding);

        for (int i = 0; i < N; i++)
        {
            double x = 1.0 * i / N;
            double y = hist[i] / 2.0;
            double rw = 0.4 / N;
            double rh = y;

            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
