using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Collections;
class Solution {
    /*
    * first line of input is 3 spaced integers with the size of 3 stacks.
    * the next 3 lines are the ”blocks” of a stack from top to bottom
    * that each are an integer representing the height of that block 
    * also separated by a space. this program finds the maximum height at
    * which all stacks of blocks is equal.
    */

    public static int[] getHeights(Stack stack) {
        /* returns all heights of the stack in order of least to greatest */
        int[] heights = new int[stack.Count + 1];
        int sum = 0;
        int index = 0;
        while(stack.Count > 0) {
            heights[index] = sum;
            sum += (int)stack.Pop();
            index += 1;
        }
        heights[index] = sum;
        return heights;

    }

    static void Main(String[] args) {
        string[] tokens_n1 = Console.ReadLine().Split(' ');
        int n1 = Convert.ToInt32(tokens_n1[0]);
        int n2 = Convert.ToInt32(tokens_n1[1]);
        int n3 = Convert.ToInt32(tokens_n1[2]);
        string[] h1_temp = Console.ReadLine().Split(' ');
        Stack h1 = new Stack(Array.ConvertAll(h1_temp,Int32.Parse));
        string[] h2_temp = Console.ReadLine().Split(' ');
        Stack h2 = new Stack(Array.ConvertAll(h2_temp,Int32.Parse));
        string[] h3_temp = Console.ReadLine().Split(' ');
        Stack h3 = new Stack(Array.ConvertAll(h3_temp,Int32.Parse));
        //find the height at each "index" of the stack, find the max where 
        //they all match, then pop off until that height is reached
        //may not be super efficient for the higher stuff
        //get height at all "indexes" by reversing the stack
        int[] heights1 = getHeights(h1);
        int[] heights2 = getHeights(h2);
        int[] heights3 = getHeights(h3);
        int result = -1;
        for(int i = heights1.Length-1; i > -1; i--) {
            if (heights2.Contains(heights1[i]) && heights3.Contains(heights1[i])) {
                result = heights1[i];
                break;
            }
        }
        Console.WriteLine(result);

    }
}
