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

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class Ex_1_1_39
{
    private static int[] experiments = {
        1000,    // 10^3
        10000,   // 10^4
        100000,  // 10^5
        1000000, // 10^6
    };

    private static final int BEGIN = 100000;
    private static final int END = 1000000;

    private static double runTrials(int T, int N)
    {
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int count = 0;

        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < N; j++)
            {
                arr1[j] = StdRandom.uniform(BEGIN, END);
                arr2[j] = StdRandom.uniform(BEGIN, END);
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            for (int k = BEGIN; k < END; k++)
                if (BinarySearch.indexOf(arr1, k) != -1 &&
                        BinarySearch.indexOf(arr2, k) != -1)
                    count++;
        }

        return (double) count / T;
    }

    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);

        for (int i = 0; i < experiments.length; i++)
        {
            int N = experiments[i];
            StdOut.printf("N = %8d, avg = %.2f\n", N, runTrials(T, N));
        }
    }
}
