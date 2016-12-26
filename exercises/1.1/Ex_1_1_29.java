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
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_1_29
{
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                while (mid > 0 && a[mid - 1] == key)
                    mid--;
                return mid;
            }
        }
        return 0;
    }

    public static int count(int key, int[] a)
    {
        int cnt = 0;
        int idx = rank(key, a);
        while (a[idx++] == key)
            cnt++;
        return cnt;
    }

    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            StdOut.println("exactly 2 arguments required");
            return;
        }

        In in = new In(args[0]);
        int key = Integer.parseInt(args[1]);
        int[] arr = in.readAllInts();
        Arrays.sort(arr);

        StdOut.printf("key: %d, rank: %d, count: %d\n",
                key,
                rank(key, arr),
                count(key, arr));
    }
}
