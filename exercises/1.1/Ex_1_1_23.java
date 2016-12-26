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

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_1_23
{
    private static int rank(int key, int[] a)
    {
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi)
    {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else                   return mid;
    }

    private static boolean filter(String op, int rank)
    {
        switch (op)
        {
            case "+": return rank != -1;
            case "-": return rank == -1;
            default:  return false;
        }
    }

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            StdOut.println("exactly 2 arguments required");
            return;
        }

        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        String op = args[1];

        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (filter(op, rank(key, whitelist))) {
                StdOut.println(key);
            }
        }
    }
}
