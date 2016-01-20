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

public class Ex_1_1_5
{
    public static void printBetween0And1(double x, double y)
    {
        StdOut.printf("%f and %f both strictly between 0 and 1: %b\n",
                x, y,
                (x > 0.0) && (x < 1.0) && (y > 0.0) && (y < 1.0));
    }

    public static void main(String[] args)
    {
        printBetween0And1(0.3, 0.5);
        printBetween0And1(0.3, 1.5);
    }
}
