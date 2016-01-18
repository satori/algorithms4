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

public class Ex_1_1_3
{
    public static void main(String[] args)
    {
        if (args.length != 3)
        {
            StdOut.println("exactly 3 arguments required");
            return;
        }

        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++)
            numbers[i] = Integer.parseInt(args[i]);

        if ((numbers[0] == numbers[1]) && (numbers[0] == numbers[2]))
            StdOut.println("equal");
        else
            StdOut.println("not equal");
    }
}
