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

public class Ex_1_1_13
{

    private static void printArray(int[][] values)
    {
        for (int i = 0; i < values.length; i++)
        {
            for (int j = 0; j < values[i].length; j++)
                StdOut.printf("%3d", values[i][j]);
            StdOut.printf("\n");
        }
    }

    public static void main(String[] args)
    {
        int M = 4;
        int N = 5;

        int[][] origin = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
        };

        int[][] transposed = new int[N][M];

        StdOut.println("Origin:");
        printArray(origin);

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                transposed[j][i] = origin[i][j];

        StdOut.println("Transposed:");
        printArray(transposed);
    }
}
