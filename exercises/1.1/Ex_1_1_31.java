// Copyright (C) 2016  Maxim Bublis
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
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_1_31
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            StdOut.println("exactly 2 arguments required");
            return;
        }

        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        if (p < 0 || p > 1)
        {
            StdOut.println("probability must be between 0.0 and 1.0");
            return;
        }

        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(-1.1, 1.1);
        StdDraw.setPenRadius(0.02);
        double[][] dots = new double[N][2];
        for (int i = 0; i < N; i++)
        {
            dots[i][0] = Math.cos(2 * Math.PI * i / N);
            dots[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(dots[i][0], dots[i][1]);
        }

        StdDraw.setPenRadius();
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (StdRandom.bernoulli(p))
                    StdDraw.line(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);
    }
}
