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

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_27
{
    private static double[][] cached;

    public static double binomial(int N, int k, double p)
    {
        if ((N == 0) && (k == 0)) return 1.0;
        if ((N  < 0) || (k  < 0)) return 0.0;

        if (cached[N][k] == 0.0) {
            cached[N][k] = (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
        }

        return cached[N][k];
    }

    public static void main(String[] args)
    {
        cached = new double[101][51];
        StdOut.printf("binomial(100, 50, 0.25) = %f\n", binomial(100, 50, 0.25));
    }
}
