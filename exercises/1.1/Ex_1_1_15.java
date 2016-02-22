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
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_1_15
{
    private static int[] histogram(int[] a, int M)
    {
        int[] values = new int[M];

        for (int i = 0; i < a.length; i++)
            values[a[i]]++;

        return values;
    }

    private static void printArray(String name, int[] values)
    {
        StdOut.printf("%s:", name);
        for (int i = 0; i < values.length; i++)
            StdOut.printf(" %d", values[i]);
        StdOut.printf("\n");
    }

    public static void main(String[] args)
    {
        int M = 16;
        int N = 2048;

        int[] uniform = new int[N];
        int[] gaussian = new int[N];

        for (int i = 0; i < N; i++)
        {
            uniform[i] = StdRandom.uniform(M);
            gaussian[i] = (int)(StdRandom.gaussian(M/(double)2, 1.0));
        }

        printArray("uniform", histogram(uniform, M));
        printArray("gaussian", histogram(gaussian, M));
    }
}
