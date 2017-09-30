import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //https://www.hackerrank.com/contests/university-codesprint-3/challenges/erupting-volcanoes
	/*
	 * This program is from University CodeSprint 3. The program takes the first line of input as an
	 * integer which determines the size of a grid. On this grid, there will be a certain number of 
	 * volcanoes (m) which each have a "strength" w and start at coordinates x, y. From the starting
	 * coordinates, a volcano spreads evenly in rings, and at each ring the strength is one level
	 * lower than the one before it.
	 * 
	 * The program calculates any overlapping of volcano spreads, and finds the point on the grid
	 * with the maximum strength, and prints it.
	 */
    
    public static void updateGrid(int[][] grid, int x, int y, int w, boolean[] directions) {
    	//This function recursively determines the effect of an individual volcano on the grid.
    	
    	//The directions array determines which directions we want to increase values in. This
    	//helps prevent a volcanos eruption from overlapping on itself. For example, if directions
    	// = [false, true, false, true] the loop will only increment the values of the grid 
    	// down and to the right. 
        if(x > grid.length-1 || y > grid.length-1 || x < 0 || y < 0 || w == 0) return;
        int row = x;
        int column = y;
        int value = w;
        int temp = grid[x][y];
        
        
        for(int i = 0; i < directions.length; i++) {
            if(directions[i]) {
                while (row > -1 && column > -1 && row < grid.length && column < grid.length && value > 0) {
                    grid[row][column] += value;

                    if (i == 0) row--;                
                    else if (i == 1) row++;
                    else if (i == 2) column--;
                    else if (i == 3) column++;
                    value--;
                }

                row = x;
                column = y;
                value = w;
            }
            row = x;
            column = y;
            value = w;
        }
        
        grid[x][y] = w + temp;
               
        if (directions[1] && directions[3]) updateGrid(grid, x+1, y+1, w-1, new boolean[] {false, true, false, true});
        if (directions[2] && directions[1]) updateGrid(grid, x+1, y-1, w-1, new boolean[] {false, true, true, false});
        if (directions[0] && directions[3]) updateGrid(grid, x-1, y+1, w-1, new boolean[] {true, false, false, true});
        if (directions[0] && directions[2]) updateGrid(grid, x-1, y-1, w-1, new boolean[] {true, false, true, false});
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //get volcano strength and coordinates
        int[][] volcanoes = new int[m][3];
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            volcanoes[a0][0] = x;
            volcanoes[a0][1] = y;
            volcanoes[a0][2] = w;
        }
        //initialize each spot on the grid with value 0
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
        
        for(int i = 0; i < m; i++) {
            updateGrid(grid, volcanoes[i][0], volcanoes[i][1], volcanoes[i][2], new boolean[] {true, true, true, true});
        }
                
        //uncomment the following lines to see the grid after volcano eruptions.
        
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > max) max = grid[i][j];
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > max) max = grid[i][j];
            }
        }
        System.out.println(max);
        in.close();
    }
}
