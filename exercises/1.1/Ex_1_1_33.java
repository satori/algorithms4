// Copyright (C) 2017, 2018  Maxim Bublis
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
import java.util.Arrays;

public class Ex_1_1_33
{
    static class Matrix
    {
        // vector dot product
        static double dot(double[] x, double[] y)
        {
            if (x.length != y.length)
                throw new IllegalArgumentException("vectors should be of the same size");

            double result = 0.0;
            for (int i = 0; i < x.length; i++)
                result += x[i] * y[i];

            return result;
        }

        // matrix-matrix product
        static double[][] mult(double[][] a, double[][] b)
        {
            int N = a.length;
            int P = b[0].length;

            double[][] result = new double[N][P];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < P; j++)
                    for (int k = 0; k < b.length; k++)
                        result[i][j] += a[i][k] * b[k][j];

            return result;
        }

        // transpose
        static double[][] transpose(double[][] a)
        {
            int N = a.length;
            int M = a[0].length;

            double[][] result = new double[M][N];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    result[j][i] = a[i][j];

            return result;
        }

        // matrix and column vector product
        static double[] mult(double[][] a, double[] x)
        {
            int N = a.length;
            double[] result = new double[N];

            for (int i = 0; i < N; i++)
                result[i] = dot(a[i], x);

            return result;
        }

        // row vector and matrix product
        static double[] mult(double[] y, double[][] a)
        {
            int M = a[0].length;

            double[] result = new double[M];

            for (int i = 0; i < M; i++)
                for (int j = 0; j < a.length; j++)
                    result[i] += y[j] * a[j][i];

            return result;
        }
    }

    private static void printMatrix(double[][] m)
    {
        for (int i = 0; i < m.length; i++)
            printVector(m[i]);
    }

    private static void printVector(double[] v)
    {
        StdOut.printf("%s\n", Arrays.toString(v));
    }

    public static void main(String[] args)
    {
        double[] x = {1, 2, 3};
        double[] y = {4, -5, 6};

        StdOut.printf("Dot product: %.2f\n", Matrix.dot(x, y));

        double[][] a = {
            {0, 4, -2},
            {-4, -3, 0},
        };

        double[][] b = {
            {0, 1},
            {1, -1},
            {2, 3},
        };

        StdOut.println("Matrix-matrix multiplication:");
        printMatrix(Matrix.mult(a, b));

        StdOut.println("Matrix transpose:");
        printMatrix(Matrix.transpose(a));

        double[] v = {-2, 1, 0};
        double[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };

        StdOut.println("Matrix-vector multiplication");
        printVector(Matrix.mult(m, v));

        StdOut.println("Vector-matrix multiplication");
        printVector(Matrix.mult(v, m));
    }
}
