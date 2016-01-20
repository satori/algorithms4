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

public class Ex_1_1_14
{
    private static int lg(int N)
    {
        int logarithm = 0;
        for (int n = N; n > 1; n /= 2)
            logarithm++;
        return logarithm;
    }

    public static void main(String[] args)
    {
        int[] values = {4, 5, 16, 38, 111};

        for (int i = 0; i < values.length; i++)
            StdOut.printf("lg(%d) ~= %d\n", values[i], lg(values[i]));
    }
}
