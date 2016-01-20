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

public class Ex_1_1_18
{
    public static int mystery(int a, int b)
    {
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static int mysteryStar(int a, int b)
    {
        if (b == 0)     return 1;
        if (b % 2 == 0) return mysteryStar(a * a, b / 2);
        return mysteryStar(a * a, b / 2) * a;
    }

    public static void main(String[] args)
    {
        // mystery() is a product function
        assert mystery(2, 25) == 50;
        assert mystery(3, 11) == 33;
        // mysteryStar() is a power function
        assert mysteryStar(2, 5) == 32;
        assert mysteryStar(3, 4) == 81;
        StdOut.printf("mystery(2, 25) = %d\n", mystery(2, 25));
        StdOut.printf("mystery(3, 11) = %d\n", mystery(3, 11));
        StdOut.printf("mysteryStar(2, 5) == %d\n", mysteryStar(2, 5));
        StdOut.printf("mysteryStar(3, 4) == %d\n", mysteryStar(3, 4));
    }
}
