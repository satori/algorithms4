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

public class Ex_1_1_30
{
    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            StdOut.println("exactly 1 argument required");
            return;
        }

        int N = Integer.parseInt(args[0]);

        boolean[][] arr = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = (gcd(i, j) == 1);

        StringBuffer header = new StringBuffer("  ");
        for (int i = 0; i < N; i++)
            header.append(" " + i);

        StdOut.println(header);

        for (int i = 0; i < N; i++)
        {
            StringBuffer buf = new StringBuffer();

            for (int j = 0; j < N; j++)
                buf.append(" " + (arr[i][j] ? "*" : " "));
            StdOut.printf("%d %s\n", i, buf);
        }
    }
}
