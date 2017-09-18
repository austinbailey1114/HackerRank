using System;
using System.Collections.Generic;
using System.IO;

class Solution {
    static int findSolution(double x, double n, int i) {
        if (x == 0) {
            //found unique solution
            return 1;
        }
        else if (x < 0) {
            //attempt failed
            return 0;
        }
        else {
            //try all valid possibilities
            int temp = 0;
            for(int j = i-1; j > 0; j--) {
                temp += findSolution(x-Math.Pow(j, n), n, j);
            }
            return temp;
        }
    }
    static void Main(String[] args) {
        //Program to recursively find the power sum of a number with a given power
        //First line of input is the number
        //second line of imput is the power
        string firstLine = Console.ReadLine();
        string secondLine = Console.ReadLine();
        double x = Convert.ToDouble(firstLine);
        double n = Convert.ToDouble(secondLine);
        
        int i = Convert.ToInt32(Math.Pow(x, 1/n));
        Console.WriteLine(findSolution(x, n, i+1));
        
            
    }
}