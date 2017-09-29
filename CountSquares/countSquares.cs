using System;
using System.Collections.Generic;
using System.IO;

class Solution {
    /* This program finds the number of squares in the range of a start integer
    * and an end integer. For example, the squares in the range of [3,9] are 4 and 9, 
    * so the program outputs 2. It does this by looping through the range of sqrt(start) and
    * sqrt(finish). If the square is larger than the maximum value in the range, then the loop
    * breaks goes to the output. This is faster than looping through the entire range.
    */
    public static void findCount(double start, double finish) {

        int count = 0;
        start = Math.Sqrt(start);
        if (start % 1 != 0) {
            start = start+1;
        }
        int end = (int) Math.Sqrt(finish);
        int i = (int) start;
        while (i < end+1) {
            count++;
            i++;
        }
        Console.WriteLine(count);
        
    }
    static void Main(String[] args) {
        /* First line of input is the number of test cases n */
        int n = Convert.ToInt32(Console.ReadLine());
        /* Ever line after that is two space-separated integers that represent the range */
        for(int i = 0; i < n; i++) {
            String ends = Console.ReadLine();
            String[] separator = {" "};
            String[] values = ends.Split(separator, StringSplitOptions.RemoveEmptyEntries);
            findCount(Convert.ToDouble(values[0]), Convert.ToDouble(values[1]));
        }
    }
}