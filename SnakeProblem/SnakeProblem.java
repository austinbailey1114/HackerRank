import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    /*
     * From univsersity codesprint 3: https://www.hackerrank.com/contests/university-codesprint-3/challenges/the-snake-vs-the-wind/problem
     */
    
    public static void findSolution(int[][] grid, char d, int x, int y, int count) {
        int n = grid.length;
        if (x < 0 || x > n-1 || y < 0 || y > n-1 || grid[x][y] != 0) {
            return;
        }
        else if (count == Math.pow(n, 2)) {
            grid[x][y] = count;
            return;
        }
        
        else if (d == 'n') {
            grid[x][y] = count;
            count++;
            findSolution(grid, d, x-1, y, count);
            findSolution(grid, d, x, y+1, count);
            findSolution(grid, d, x, y-1, count);
            findSolution(grid, d, x+1, y, count);
        }
        else if (d == 's') {
            grid[x][y] = count;
            count++;
            findSolution(grid, d, x+1, y, count);
            findSolution(grid, d, x, y+1, count);
            findSolution(grid, d, x, y-1, count);
            findSolution(grid, d, x-1, y, count);
        }
        else if (d == 'e') {
            grid[x][y] = count;
            count++;
            findSolution(grid, d, x, y+1, count);
            findSolution(grid, d, x+1, y, count);
            findSolution(grid, d, x-1, y, count);
            findSolution(grid, d, x, y-1, count);
        }
        else {
            grid[x][y] = count;
            count++;
            findSolution(grid, d, x, y-1, count);
            findSolution(grid, d, x+1, y, count);
            findSolution(grid, d, x-1, y, count);
            findSolution(grid, d, x, y+1, count);
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char d = in.next().charAt(0);
        int x = in.nextInt();
        int y = in.nextInt();
        // Write Your Code Here
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
        findSolution(grid, d, x, y, 1);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
