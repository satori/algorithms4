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

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_1_37
{
    private static void shuffle(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {   // Exchange a[i] with random element in a[0..N-1]
            int r = StdRandom.uniform(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            StdOut.println("exactly 2 arguments required");
            return;
        }

        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        int[] a = new int[M];
        int[][] stats = new int[M][M];

        for (int k = 0; k < N; k++)
        {
            for (int i = 0; i < M; i++)
                a[i] = i;

            shuffle(a);

            for (int i = 0; i < M; i++)
                stats[i][a[i]]++;
        }

        for (int i = 0; i < M; i++)
            StdOut.printf("%s\n", Arrays.toString(stats[i]));
    }
}
