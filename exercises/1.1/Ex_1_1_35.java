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

public class Ex_1_1_35
{
    private static double[] runExperiments(int N, int SIDES)
    {
        double[] observed = new double[2 * SIDES + 1];

        for (int i = 0; i < N; i++)
        {
            int a = StdRandom.uniform(1, SIDES + 1);
            int b = StdRandom.uniform(1, SIDES + 1);
            observed[a + b] += 1.0;
        }

        for (int i = 2; i <= 2 * SIDES; i++)
            observed[i] /= N;

        return observed;
    }

    public static void main(String[] args)
    {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        StdOut.printf("Distribution: %s\n", Arrays.toString(dist));

        int[] experiments = {5000, 25000, 100000, 5000000, 25000000};

        for (int i = 0; i < experiments.length; i++)
        {
            int runs = experiments[i];
            StdOut.printf("Experiment(%d): %s\n", runs, Arrays.toString(runExperiments(runs, SIDES)));
        }
    }
}
